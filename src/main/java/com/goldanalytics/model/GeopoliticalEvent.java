package com.goldanalytics.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Entity representing a political or geographical event.
 * Sourced from GDELT, NewsAPI, and other event databases.
 */
@Entity
@Table(name = "geopolitical_events", indexes = {
    @Index(name = "idx_event_date", columnList = "eventDate"),
    @Index(name = "idx_event_type", columnList = "eventType"),
    @Index(name = "idx_country", columnList = "country")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeopoliticalEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime eventDate;

    @Column(nullable = false, length = 500)
    private String title;

    @Column(length = 2000)
    private String description;

    @Column(nullable = false, length = 50)
    private String eventType; // CONFLICT, ELECTION, POLICY_CHANGE, NATURAL_DISASTER, etc.

    @Column(length = 100)
    private String category; // Detailed category from GDELT

    @Column(length = 100)
    private String country;

    @Column(length = 100)
    private String region;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

    @Column(length = 50)
    private String severity; // LOW, MEDIUM, HIGH, CRITICAL

    @Column
    private Double impactScore; // Calculated impact score (0-100)

    @Column(length = 500)
    private String sourceUrl;

    @Column(length = 50)
    private String source; // GDELT, NEWSAPI, ACLED, etc.

    @Column
    private String externalId; // ID from source system

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
