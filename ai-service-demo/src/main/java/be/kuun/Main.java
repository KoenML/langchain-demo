package be.kuun;

import be.kuun.aiService.RecruiterService;
import be.kuun.modelService.ModelService;
import be.kuun.modelService.impl.TestContainerModelService;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.AiServices;

public class Main {
    public static void main(String[] args) {
        ModelService modelService = new TestContainerModelService();
        ChatLanguageModel model = modelService.getModel("mistral");
        RecruiterService recruiterService = AiServices.create(RecruiterService.class, model);
        System.out.println(recruiterService.chat("I am looking for a job as a java software developer, can you help me?"));
        modelService.stopModel(model);
    }
}