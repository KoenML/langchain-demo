package be.kuun;

import be.kuun.aiService.CvExtractor;
import be.kuun.aiService.domain.TechnicalProfile;
import be.kuun.documentService.DocumentService;
import be.kuun.documentService.impl.PdfDocumentService;
import be.kuun.embeddingService.EmbeddingService;
import be.kuun.embeddingService.impl.OllamaEmbeddingService;
import be.kuun.embeddingService.impl.OpenAiEmbeddingService;
import be.kuun.modelService.ModelService;
import be.kuun.modelService.impl.OllamaModelService;
import be.kuun.modelService.impl.OpenAiModelService;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;

public class Main {

    private final static String MODEL = "mistral";
    // private final static String EMBED_MODEL = "text-embedding-3-large"; => OpenAI uses a different model for embedding
    public static void main(String[] args) {
        ModelService models = new OllamaModelService();
        EmbeddingService embeddings = new OllamaEmbeddingService();
        DocumentService documents = new PdfDocumentService();

        ChatLanguageModel cModel = models.getModel(MODEL);

        EmbeddingModel eModel = embeddings.getModel(MODEL);
        EmbeddingStore<TextSegment> eStore = embeddings.getStore();
        EmbeddingStoreIngestor ingestor = embeddings.getIngestor(eModel, eStore);
        EmbeddingStoreContentRetriever retriever = embeddings.getRetriever(eModel, eStore);

        Document cv = documents.getDocument("/cv.pdf");
        ingestor.ingest(cv);


        

        CvExtractor extractor =
        AiServices.builder(CvExtractor.class)
                .chatLanguageModel(cModel)
                .contentRetriever(retriever)
                .build();

        TechnicalProfile p = extractor.getTechnicalProfile("Koen Luyten");
        System.out.println(p);        
        // System.out.println(extractor.getProgrammingLanguages());
        // System.out.println(extractor.getPreviousEmployers());
        // System.out.println(extractor.getEducationalDegrees());
    }
}