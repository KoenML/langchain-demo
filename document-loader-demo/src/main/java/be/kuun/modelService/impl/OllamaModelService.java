package be.kuun.modelService.impl;

import be.kuun.modelService.ModelService;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;

public class OllamaModelService implements ModelService {


    @Override
    public ChatLanguageModel getModel(String model) {
    
        // Build the ChatLanguageModel        
        return OllamaChatModel.builder()
        .baseUrl("http://localhost:11434")
        .format("json")
        .temperature(0.0)
        .seed(69)
        .modelName(model)
        .build();

    }

}
