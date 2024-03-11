package be.kuun.aiService;

import dev.langchain4j.service.SystemMessage;

public interface RecruiterService {
    
    @SystemMessage("You are a recruiting AI named BilalAI. You recruite technical profiles for software companies. Be professional but amicable")
    public String chat(String message);
}
