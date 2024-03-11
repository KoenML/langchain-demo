package be.kuun.embeddingService.impl;

import be.kuun.embeddingService.EmbeddingService;
import dev.langchain4j.data.document.DocumentSplitter;
import dev.langchain4j.data.document.splitter.DocumentSplitters;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;

public abstract class AbstractEmbeddingService implements EmbeddingService {

    private DocumentSplitter splitter = DocumentSplitters.recursive(600, 0);

    @Override
    public EmbeddingStore<TextSegment> getStore() {
        return new InMemoryEmbeddingStore();
    }

    @Override
    public EmbeddingStoreIngestor getIngestor(EmbeddingModel model, EmbeddingStore<TextSegment> store) {
        return EmbeddingStoreIngestor.builder()
        .documentSplitter(splitter)
        .embeddingModel(model)
        .embeddingStore(store)
        .build();

    }

    @Override
    public EmbeddingStoreContentRetriever getRetriever(EmbeddingModel model, EmbeddingStore<TextSegment> store) {
        return EmbeddingStoreContentRetriever.builder()
                .embeddingStore(store)
                .embeddingModel(model)
                .maxResults(1)
                .build();
    }
}
