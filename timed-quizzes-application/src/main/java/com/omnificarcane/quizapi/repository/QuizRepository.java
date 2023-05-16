package com.omnificarcane.quizapi.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omnificarcane.quizapi.model.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

	List<Quiz> findAllByEndDateAfter(LocalDate now);

	List<Quiz> findByEndDateLessThan(LocalDate currentDate);


	
}
