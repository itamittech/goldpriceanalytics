# Gold Price Analytics

A comprehensive analytical platform that explores the relationship between gold price fluctuations and major political and geographical events worldwide.

## Overview

Gold has historically been a safe-haven asset, responding to political instability, economic crises, and geographical conflicts. This project aims to uncover meaningful patterns and correlations between gold market movements and significant world events.

## Project Goals

- **Data Analysis**: Analyze historical gold price data across different timeframes
- **Event Correlation**: Map major political and geographical events to price movements
- **Insight Generation**: Provide data-driven insights on how specific event types affect gold prices
- **Visualization**: Create compelling visualizations showing price trends and event impacts
- **Predictive Patterns**: Identify potential patterns that could inform future market understanding

## Key Features (Planned)

### Data Collection
- Historical gold price data (spot prices, futures)
- Political events database (elections, policy changes, conflicts)
- Geographical events (natural disasters, territorial disputes)
- Economic indicators (inflation, currency fluctuations, central bank actions)

### Analysis Capabilities
- Time series analysis of gold prices
- Event impact quantification
- Correlation analysis between event types and price movements
- Statistical significance testing
- Trend identification and pattern recognition

### Visualization & Reporting
- Interactive price charts with event overlays
- Heatmaps showing event-price correlations
- Timeline views of major events and their market impact
- Comparative analysis across different event categories
- Insight reports and summaries

## Example Insights

This platform could answer questions like:
- How do gold prices typically react to geopolitical tensions?
- What is the average price movement following major election results?
- How long do price spikes last after significant conflict announcements?
- Which types of events have the strongest correlation with gold prices?
- Are there seasonal or cyclical patterns related to specific event types?

## Data Sources

### Gold Market Data
- **Alpha Vantage API** - Free tier available for daily/intraday gold prices
- **Yahoo Finance** - Historical gold spot prices (XAU/USD)
- **Metals-API** - Real-time and historical precious metals data
- **World Gold Council** - Market insights and historical data

### Political & Geographical Events
- **GDELT Project** (Global Database of Events, Language, and Tone)
  - Real-time monitoring of world events
  - 300+ categories of political/geographical events
  - Historical data back to 1979
  - Free public access via BigQuery
- **NewsAPI** - News articles for event correlation
- **ACLED** (Armed Conflict Location & Event Data) - Conflict events data

### Economic Indicators
- **World Bank Open Data API** - Economic indicators by country
- **IMF Data API** - International monetary and financial statistics
- **FRED API** (Federal Reserve Economic Data) - US economic data

## Tech Stack

### Core Technology
- **Java 21 LTS** - Latest long-term support version with modern features:
  - Virtual Threads (Project Loom) for efficient concurrent data processing
  - Pattern Matching and Records for clean data modeling
  - Sequenced Collections for time-series data handling

### Build & Dependency Management
- **Maven** - Project management and build automation

### AI & Machine Learning
- **Deeplearning4j (DL4J)** - Deep learning library for Java
- **Tribuo** - Oracle's machine learning library (decision trees, regression, clustering)
- **Apache Commons Math** - Statistical analysis and mathematics
- **Smile** - Statistical Machine Intelligence and Learning Engine

### Data Processing & Analysis
- **Tablesaw** - DataFrames for Java (similar to pandas)
- **Apache Commons CSV** - CSV parsing for data import
- **Jackson** - JSON processing for API responses
- **Univocity Parsers** - High-performance data parsing

### Time Series Analysis
- **JTimeSeries** - Time series data handling
- **Apache Commons Math** - Statistical time series functions

### Visualization
- **XChart** - Lightweight charting library
- **JFreeChart** - Comprehensive charting (if needed)

### HTTP & API Integration
- **OkHttp** - Modern HTTP client for API calls
- **Retrofit** - Type-safe REST client

### Database
- **PostgreSQL** - Primary data storage with TimescaleDB extension for time-series
- **H2** - Embedded database for testing
- **HikariCP** - High-performance JDBC connection pooling

### Optional Web Layer
- **Spring Boot 3.x** - Modern Java framework with native image support
- **Micronaut** - Alternative lightweight framework for microservices

### Testing
- **JUnit 5** - Unit testing framework
- **AssertJ** - Fluent assertion library
- **Mockito** - Mocking framework

## Project Status

This project is in initial development. Built completely using Claude Code as a demonstration of AI-assisted development.

## Getting Started

*Installation and usage instructions will be added as the project develops*

## Contributing

This is a demonstration project. Contributions and suggestions welcome.

## License

*To be determined*

---

**Built with Claude Code** - Showcasing AI-assisted software development
