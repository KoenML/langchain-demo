package be.kuun.modelService.impl;

import java.util.HashMap;
import java.util.Map;

import org.testcontainers.containers.GenericContainer;

import be.kuun.modelService.ModelService;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;

public class TestContainerModelService implements ModelService {


    private Map<Integer, GenericContainer<?>> containerMap;

    public TestContainerModelService(){
        this.containerMap = new HashMap<>();
    }

    @Override
    public ChatLanguageModel getModel(String model) {
        

        // Create and start the Ollama container
        GenericContainer<?> container =
            new GenericContainer<>("langchain4j/ollama-" + model + ":latest")
                .withExposedPorts(11434);
        container.start();

        // Build the ChatLanguageModel
        ChatLanguageModel result =
            OllamaChatModel.builder().baseUrl(baseUrl(container)).modelName(model).build();
        
        containerMap.put(result.hashCode(), container);

        return result;
        
        
    }

    @Override
    public void stopModel(ChatLanguageModel model) {
        containerMap.get(model.hashCode()).stop();
    }

    private  String baseUrl(GenericContainer<?> modelContainer) {
        return String.format("http://%s:%d", modelContainer.getHost(), modelContainer.getFirstMappedPort());
    }

}
