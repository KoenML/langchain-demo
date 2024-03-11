package be.kuun;

import dev.langchain4j.model.openai.OpenAiChatModel;

public class Main {
    public static void main(String[] args) {
        String apiKey = System.getenv("OPENAI_API_KEY");
        OpenAiChatModel model = OpenAiChatModel.withApiKey(apiKey);
        String answer = model.generate("Say 'Hello World'");
        System.out.println(answer); // Hello World
    }
}