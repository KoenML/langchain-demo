package be.kuun;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import org.testcontainers.containers.GenericContainer;

public class OllamaChatExample {

  public static void main(String[] args) {
    // The model name to use (e.g., "orca-mini", "mistral", "llama2", "codellama", "phi", or
    // "tinyllama")
    String modelName = "mistral";

    // Create and start the Ollama container
    GenericContainer<?> ollama =
        new GenericContainer<>("langchain4j/ollama-" + modelName + ":latest")
            .withExposedPorts(11434);
    ollama.start();

    // Build the ChatLanguageModel
    ChatLanguageModel model =
        OllamaChatModel.builder().baseUrl(baseUrl(ollama)).modelName(modelName).build();

    // Example usage
    UserMessage firstUserMessage = UserMessage.from("Hello, my name is Klaus");
    AiMessage firstAiMessage = model.generate(firstUserMessage).content(); // Hi Klaus, how can I help you?
    System.out.println(firstAiMessage.text());
    UserMessage secondUserMessage = UserMessage.from("What is my name?");
    AiMessage secondAiMessage = model.generate(firstUserMessage, firstAiMessage, secondUserMessage).content();
    System.out.println(secondAiMessage.text());

    // Stop the Ollama container
    ollama.stop();
  }

  private static String baseUrl(GenericContainer<?> ollama) {
    return String.format("http://%s:%d", ollama.getHost(), ollama.getFirstMappedPort());
  }
}