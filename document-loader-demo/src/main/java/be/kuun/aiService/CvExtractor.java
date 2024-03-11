package be.kuun.aiService;

import java.util.List;

import be.kuun.aiService.domain.TechnicalProfile;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

// 
public interface CvExtractor {

    // @SystemMessage("You are a recruiter for a software recruiting firm")
    @UserMessage("Please extract all info about {{it}} as of {{current_date}}.")
    TechnicalProfile getTechnicalProfile(String name);

    @UserMessage("Tell me all the programming languages this person knows")
    String getProgrammingLanguages();

    @UserMessage("Based duration of employement of each of the companies they worked, how much years of experience does this person have as of {{current_date}}")
    String getPreviousEmployers();

    @UserMessage("Tell me the highest educational degree this person attained")
    String getEducationalDegrees();
}