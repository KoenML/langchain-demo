package be.kuun.modelService;

import dev.langchain4j.model.chat.ChatLanguageModel;

public interface ModelService {
    ChatLanguageModel getModel(String model);
}
