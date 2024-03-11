package be.kuun.embeddingService.impl;

import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.openai.OpenAiEmbeddingModel;


public class OpenAiEmbeddingService extends AbstractEmbeddingService {

    @Override
    public EmbeddingModel getModel(String modelName) {
        String apiKey = System.getenv("OPENAI_API_KEY");
        return OpenAiEmbeddingModel.builder()
            .apiKey(apiKey)
            .modelName(modelName)
            .build();
    }

    

}
