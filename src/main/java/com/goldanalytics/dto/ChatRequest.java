package com.goldanalytics.dto;

import java.time.LocalDateTime;

/**
 * Request DTO for chatbot queries using Java 21 Record.
 * Immutable and concise data carrier.
 */
public record ChatRequest(
    String message,
    String sessionId,
    LocalDateTime timestamp
) {
    public ChatRequest {
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }
        if (timestamp == null) {
            timestamp = LocalDateTime.now();
        }
    }
}
