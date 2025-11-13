package com.goldanalytics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Main application class for Gold Price Analytics platform.
 *
 * This application provides AI-powered analysis of gold price fluctuations
 * correlated with political and geographical events worldwide.
 *
 * Built with Java 21 featuring:
 * - Virtual Threads for efficient concurrent processing
 * - Pattern Matching and Records for clean data models
 * - Modern ML libraries for predictive analytics
 */
@SpringBootApplication
@EnableScheduling
public class GoldPriceAnalyticsApplication {

    public static void main(String[] args) {
        // Enable Virtual Threads (Project Loom) for optimal concurrency
        System.setProperty("spring.threads.virtual.enabled", "true");

        SpringApplication.run(GoldPriceAnalyticsApplication.class, args);
    }
}
