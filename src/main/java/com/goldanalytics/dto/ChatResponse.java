package com.goldanalytics.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * Response DTO for chatbot using Java 21 Record.
 * Contains AI-generated insights and supporting data.
 */
public record ChatResponse(
    String message,
    String sessionId,
    LocalDateTime timestamp,
    InsightType type,
    List<DataPoint> dataPoints,
    Map<String, Object> metadata
) {
    public enum InsightType {
        PRICE_ANALYSIS,
        EVENT_CORRELATION,
        TREND_PREDICTION,
        HISTORICAL_COMPARISON,
        GENERAL_INFO
    }

    public record DataPoint(
        LocalDateTime date,
        Double value,
        String label,
        String eventDescription
    ) {}

    public ChatResponse {
        if (timestamp == null) {
            timestamp = LocalDateTime.now();
        }
    }
}
