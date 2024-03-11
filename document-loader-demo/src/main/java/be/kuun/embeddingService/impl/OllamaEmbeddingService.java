package be.kuun.embeddingService.impl;

import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.ollama.OllamaEmbeddingModel;


public class OllamaEmbeddingService extends AbstractEmbeddingService {



    @Override
    public EmbeddingModel getModel(String modelName) {
        return OllamaEmbeddingModel.builder()
        .baseUrl("http://localhost:11434")
        .modelName(modelName)
        .build();
    }

}
