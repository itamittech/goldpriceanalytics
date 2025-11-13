package com.goldanalytics.controller;

import com.goldanalytics.dto.ChatRequest;
import com.goldanalytics.dto.ChatResponse;
import com.goldanalytics.service.ChatbotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for chatbot interactions.
 * Provides AI-powered conversational interface for gold price analytics.
 */
@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*") // Configure appropriately for production
public class ChatbotController {

    private final ChatbotService chatbotService;

    /**
     * Process a chat message and return AI-generated insights.
     *
     * Example queries:
     * - "How did gold prices react to the 2020 US election?"
     * - "Show me price trends during major conflicts"
     * - "What's the correlation between inflation and gold prices?"
     */
    @PostMapping
    public ResponseEntity<ChatResponse> chat(@RequestBody ChatRequest request) {
        log.info("Received chat request: {}", request.message());

        ChatResponse response = chatbotService.processQuery(request);

        return ResponseEntity.ok(response);
    }

    /**
     * Get conversation history for a session.
     */
    @GetMapping("/history/{sessionId}")
    public ResponseEntity<?> getHistory(@PathVariable String sessionId) {
        log.info("Retrieving history for session: {}", sessionId);

        var history = chatbotService.getSessionHistory(sessionId);

        return ResponseEntity.ok(history);
    }

    /**
     * Health check endpoint.
     */
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Chatbot service is running");
    }
}
