package com.goldanalytics.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity representing gold price data at a specific point in time.
 */
@Entity
@Table(name = "gold_prices", indexes = {
    @Index(name = "idx_timestamp", columnList = "timestamp"),
    @Index(name = "idx_date", columnList = "timestamp")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoldPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(precision = 10, scale = 2)
    private BigDecimal open;

    @Column(precision = 10, scale = 2)
    private BigDecimal high;

    @Column(precision = 10, scale = 2)
    private BigDecimal low;

    @Column(precision = 10, scale = 2)
    private BigDecimal close;

    @Column
    private Long volume;

    @Column(length = 10)
    private String currency = "USD";

    @Column
    private String source;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
