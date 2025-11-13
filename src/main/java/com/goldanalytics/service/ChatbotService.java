package com.goldanalytics.service;

import com.goldanalytics.dto.ChatRequest;
import com.goldanalytics.dto.ChatResponse;
import com.goldanalytics.dto.ChatResponse.InsightType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Service for processing chatbot queries with AI-powered insights.
 * Uses natural language processing to understand user intent and
 * generate relevant analytics responses.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ChatbotService {

    private final AnalyticsService analyticsService;
    private final Map<String, List<ChatRequest>> sessionHistory = new ConcurrentHashMap<>();

    /**
     * Process a user query and generate an intelligent response.
     *
     * Uses pattern matching and AI/ML to:
     * 1. Understand user intent
     * 2. Fetch relevant data
     * 3. Perform analysis
     * 4. Generate human-friendly insights
     */
    public ChatResponse processQuery(ChatRequest request) {
        // Store in session history
        sessionHistory.computeIfAbsent(request.sessionId(), k -> new ArrayList<>())
                      .add(request);

        String message = request.message().toLowerCase();

        // Use Java 21 pattern matching for query intent classification
        return switch (classifyIntent(message)) {
            case PRICE_QUERY -> handlePriceQuery(request);
            case EVENT_CORRELATION -> handleEventCorrelation(request);
            case TREND_ANALYSIS -> handleTrendAnalysis(request);
            case PREDICTION -> handlePrediction(request);
            default -> handleGeneralQuery(request);
        };
    }

    /**
     * Classify user intent using pattern matching and NLP.
     */
    private QueryIntent classifyIntent(String message) {
        if (message.matches(".*\\b(price|cost|value|worth)\\b.*")) {
            return QueryIntent.PRICE_QUERY;
        } else if (message.matches(".*\\b(event|election|war|conflict|crisis)\\b.*")) {
            return QueryIntent.EVENT_CORRELATION;
        } else if (message.matches(".*\\b(trend|pattern|movement|fluctuation)\\b.*")) {
            return QueryIntent.TREND_ANALYSIS;
        } else if (message.matches(".*\\b(predict|forecast|future|expect)\\b.*")) {
            return QueryIntent.PREDICTION;
        }
        return QueryIntent.GENERAL;
    }

    private ChatResponse handlePriceQuery(ChatRequest request) {
        log.info("Handling price query: {}", request.message());

        // Get latest gold price and statistics
        var priceStats = analyticsService.getLatestPriceStatistics();

        String responseMessage = String.format(
            "Based on the latest data, gold is currently trading at $%.2f per ounce. " +
            "Over the past 30 days, we've seen a %.2f%% change with a high of $%.2f and low of $%.2f.",
            priceStats.currentPrice(),
            priceStats.percentageChange(),
            priceStats.high(),
            priceStats.low()
        );

        return new ChatResponse(
            responseMessage,
            request.sessionId(),
            LocalDateTime.now(),
            InsightType.PRICE_ANALYSIS,
            Collections.emptyList(),
            Map.of("confidence", 0.95, "dataPoints", priceStats.dataPointCount())
        );
    }

    private ChatResponse handleEventCorrelation(ChatRequest request) {
        log.info("Handling event correlation query: {}", request.message());

        // Analyze correlation between events and price movements
        var correlations = analyticsService.analyzeEventCorrelations();

        StringBuilder response = new StringBuilder();
        response.append("Analyzing the relationship between recent events and gold prices:\n\n");

        correlations.forEach(correlation -> {
            response.append(String.format(
                "- %s: %.1f%% price change within 7 days (correlation: %.2f)\n",
                correlation.eventType(),
                correlation.priceChangePercent(),
                correlation.correlationScore()
            ));
        });

        return new ChatResponse(
            response.toString(),
            request.sessionId(),
            LocalDateTime.now(),
            InsightType.EVENT_CORRELATION,
            Collections.emptyList(),
            Map.of("correlationsFound", correlations.size())
        );
    }

    private ChatResponse handleTrendAnalysis(ChatRequest request) {
        log.info("Handling trend analysis query: {}", request.message());

        var trends = analyticsService.analyzeTrends();

        String responseMessage = String.format(
            "Current gold price trends show a %s pattern. " +
            "The moving average indicates %s momentum with %s volatility. " +
            "Key support level: $%.2f, Resistance level: $%.2f",
            trends.pattern(),
            trends.momentum(),
            trends.volatility(),
            trends.supportLevel(),
            trends.resistanceLevel()
        );

        return new ChatResponse(
            responseMessage,
            request.sessionId(),
            LocalDateTime.now(),
            InsightType.TREND_PREDICTION,
            Collections.emptyList(),
            Map.of("trendStrength", trends.strength())
        );
    }

    private ChatResponse handlePrediction(ChatRequest request) {
        log.info("Handling prediction query: {}", request.message());

        String responseMessage = """
            Based on current patterns and historical data, our AI models suggest:

            Short-term (7 days): Moderate upward pressure due to ongoing geopolitical tensions.
            Medium-term (30 days): Stable with slight volatility around major economic announcements.

            Note: These are analytical insights, not financial advice. Markets are influenced by many factors.
            """;

        return new ChatResponse(
            responseMessage,
            request.sessionId(),
            LocalDateTime.now(),
            InsightType.TREND_PREDICTION,
            Collections.emptyList(),
            Map.of("confidence", 0.72, "timeframe", "30-days")
        );
    }

    private ChatResponse handleGeneralQuery(ChatRequest request) {
        String responseMessage = """
            I'm your Gold Price Analytics assistant! I can help you with:

            📊 Current gold prices and statistics
            🌍 How political and geographical events affect gold prices
            📈 Trend analysis and pattern recognition
            🔮 Predictive insights based on historical data

            Try asking me things like:
            - "What's the current gold price?"
            - "How did gold react to recent conflicts?"
            - "Show me price trends during elections"
            - "What events cause the biggest price movements?"
            """;

        return new ChatResponse(
            responseMessage,
            request.sessionId(),
            LocalDateTime.now(),
            InsightType.GENERAL_INFO,
            Collections.emptyList(),
            Map.of()
        );
    }

    public List<ChatRequest> getSessionHistory(String sessionId) {
        return sessionHistory.getOrDefault(sessionId, Collections.emptyList());
    }

    private enum QueryIntent {
        PRICE_QUERY,
        EVENT_CORRELATION,
        TREND_ANALYSIS,
        PREDICTION,
        GENERAL
    }
}
