package be.kuun.aiService.domain;

import java.util.List;

import dev.langchain4j.model.output.structured.Description;

public class TechnicalProfile {

    @Description("The name of the person")
    private String name;
    @Description("The total years of experience based on the time spent at previous employers, excluding education")
    private int workingExperienceInYears;
    @Description("A list of the names of the previous and current employer, excluding education")
    private List<String> previousEmployerNames;
    @Description("List of all the technical skills this person has, excluding spoken languages")
    private List<String> technicalSkills;
    @Description("List of all the spoken or natural languages this person knows, excluding programming languages")
    private List<String> languages;
    @Description("The highest degree of education this person has obtained, where a masters is higher than a bachelors and a PhD is higher than a masters")
    private String highestDegreeOfEducation;



}
