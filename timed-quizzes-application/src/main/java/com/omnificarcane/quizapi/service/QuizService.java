package com.omnificarcane.quizapi.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnificarcane.quizapi.model.Quiz;
import com.omnificarcane.quizapi.repository.QuizRepository;

import jakarta.transaction.Transactional;

@Service
public class QuizService {
    private final QuizRepository quizRepository;

    @Autowired
    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public Optional<Quiz> getQuizById(Long id) {
        return quizRepository.findById(id);
    }

  
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public List<Quiz> getActiveQuizzes() {
       
        return quizRepository.findAllByEndDateAfter(LocalDate.now());
    }

    public String getQuizResult(Long id) {
        Optional<Quiz> optionalQuiz = quizRepository.findById(id);
        if (optionalQuiz.isPresent()) {
            Quiz quiz = optionalQuiz.get();
            return quiz.getOptions().get(quiz.getRightAnswer());
        }
        return null;
    }
    @Transactional
    public void updateQuizStatus() {
        LocalDate currentDate = LocalDate.now();
        List<Quiz> quizzes = quizRepository.findByEndDateLessThan(currentDate);
        quizzes.forEach(quiz -> {
            quiz.setStatus("Expired");
            // You can perform additional logic or update other fields as needed
        });
    }
}
