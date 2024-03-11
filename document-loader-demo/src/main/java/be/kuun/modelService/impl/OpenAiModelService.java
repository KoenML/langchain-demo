package be.kuun.modelService.impl;

import be.kuun.modelService.ModelService;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;

public class OpenAiModelService implements ModelService {

    @Override
    public ChatLanguageModel getModel(String model) {
        String apiKey = System.getenv("OPENAI_API_KEY");
        return OpenAiChatModel.builder()
            .modelName(model)
            .apiKey(apiKey)
            .responseFormat("json_object")
            .build();
    }

}
