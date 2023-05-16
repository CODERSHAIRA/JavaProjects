package com.omnificarcane.quizapi.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Quiz {
	
	@Id
	@GeneratedValue
    private Long id;
	
	@NotBlank(message = "Question cannot be left empty")
    private String question;
	
	@NotNull(message = "Options cannot be left empty")
    private List<String> options;
	
	@NotNull(message = "Answers cannot be left empty")
    private Integer rightAnswer;
    
    @NotNull(message = "Start date cannot be left empty")
    private LocalDate startDate;
    
    @NotNull(message = "End date cannot be left empty")
    private LocalDate endDate;

    public Quiz() {
    }

    public Quiz(String question, List<String> options, Integer rightAnswer, LocalDate startDate, LocalDate endDate) {
        this.question = question;
        this.options = options;
        this.rightAnswer = rightAnswer;
        this.startDate = startDate  ;
        this.endDate = endDate  ;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

	public void setStatus(String string) {
		// TODO Auto-generated method stub
		
	}

}
