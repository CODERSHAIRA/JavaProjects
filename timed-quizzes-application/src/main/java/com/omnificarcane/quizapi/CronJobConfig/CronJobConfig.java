package com.omnificarcane.quizapi.CronJobConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.omnificarcane.quizapi.service.QuizService;

@Configuration
@EnableScheduling
public class CronJobConfig {
    
    @Autowired
    private QuizService quizService;

    @Scheduled(cron = "0 0 0 * * ?") // Runs at midnight every day
    public void runNightlyJob() {
        quizService.updateQuizStatus();
    }
}

