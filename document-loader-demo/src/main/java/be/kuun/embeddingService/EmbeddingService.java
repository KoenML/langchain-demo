package be.kuun.embeddingService;

import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;

public interface EmbeddingService {
    EmbeddingModel getModel(String modelName);
    EmbeddingStore<TextSegment> getStore();
    EmbeddingStoreIngestor getIngestor(EmbeddingModel model, EmbeddingStore<TextSegment> store);
    EmbeddingStoreContentRetriever getRetriever(EmbeddingModel model, EmbeddingStore<TextSegment> store);
}
