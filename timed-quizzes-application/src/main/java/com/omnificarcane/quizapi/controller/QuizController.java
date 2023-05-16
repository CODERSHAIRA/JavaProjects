package com.omnificarcane.quizapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omnificarcane.quizapi.model.Quiz;
import com.omnificarcane.quizapi.service.QuizService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/quizzes")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody @Valid Quiz quiz) {
        Quiz createdQuiz = quizService.createQuiz(quiz);
        return new ResponseEntity<>(createdQuiz, HttpStatus.CREATED);
    }

    @GetMapping("/active")
    public ResponseEntity<List<Quiz>> getActiveQuiz() {
        List<Quiz> activeQuiz = quizService.getActiveQuizzes();
        return new ResponseEntity<>(activeQuiz, HttpStatus.OK);
    }

    @GetMapping("/{id}/result")
    public ResponseEntity<String> getQuizAnswer(@PathVariable Long id) {
        String result = quizService.getQuizResult(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        return new ResponseEntity<>(quizzes, HttpStatus.OK);
    }
}


    		
    		
    		
    		

    		