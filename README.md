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

### Web Layer
- **Spring Boot 3.2** - Modern Java framework with Virtual Threads support
- **REST API** - RESTful endpoints for chatbot and analytics

### Frontend
- **React 18** - Modern UI library with hooks
- **TypeScript** - Type-safe frontend development
- **Vite** - Lightning-fast build tool and dev server
- **Modern CSS** - Gradient designs and animations

### Testing
- **JUnit 5** - Unit testing framework
- **AssertJ** - Fluent assertion library
- **Mockito** - Mocking framework

## Project Architecture

```
gold-price-analytics/
├── src/main/java/com/goldanalytics/
│   ├── GoldPriceAnalyticsApplication.java  # Main Spring Boot app
│   ├── controller/
│   │   └── ChatbotController.java          # REST API endpoints
│   ├── service/
│   │   ├── ChatbotService.java             # NLP & query processing
│   │   └── AnalyticsService.java           # ML-powered analytics
│   ├── model/
│   │   ├── GoldPrice.java                  # Gold price entity
│   │   └── GeopoliticalEvent.java          # Event entity
│   └── dto/
│       ├── ChatRequest.java                # Request DTO (Record)
│       └── ChatResponse.java               # Response DTO (Record)
├── frontend/
│   ├── src/
│   │   ├── components/
│   │   │   ├── Chatbot.tsx                 # Main chatbot UI
│   │   │   └── Chatbot.css                 # Chatbot styles
│   │   ├── App.tsx                         # Root component
│   │   └── main.tsx                        # Entry point
│   └── package.json
└── pom.xml                                  # Maven dependencies
```

## Getting Started

### Prerequisites

- **Java 21** - Download from [OpenJDK](https://jdk.java.net/21/) or [Oracle](https://www.oracle.com/java/technologies/downloads/)
- **Maven 3.8+** - For building the backend
- **Node.js 18+** - For running the frontend
- **npm** or **yarn** - Package manager for frontend dependencies

### Running the Backend

1. Clone the repository:
```bash
git clone <repository-url>
cd gold-price-analytics
```

2. Build and run the Spring Boot backend:
```bash
mvn clean install
mvn spring-boot:run
```

The backend will start on `http://localhost:8080`

3. Test the API:
```bash
curl http://localhost:8080/api/chat/health
```

### Running the Frontend

1. Navigate to the frontend directory:
```bash
cd frontend
```

2. Install dependencies:
```bash
npm install
```

3. Start the development server:
```bash
npm run dev
```

The frontend will start on `http://localhost:5173` (or another port if 5173 is busy)

### Using the Application

1. Open your browser to `http://localhost:5173`
2. You'll see a chatbot interface
3. Try asking questions like:
   - "What's the current gold price?"
   - "How do conflicts affect gold prices?"
   - "Show me recent price trends"
   - "What events impact gold the most?"

## Features Implemented

### Backend (Java 21 + Spring Boot)
- ✅ RESTful chatbot API
- ✅ Natural Language Processing for query intent classification
- ✅ Pattern matching using Java 21 features
- ✅ JPA entities for gold prices and geopolitical events
- ✅ Record DTOs for clean, immutable data transfer
- ✅ Virtual Threads enabled for high concurrency
- ✅ Analytics service foundation

### Frontend (React + TypeScript)
- ✅ Modern chatbot UI with gradient design
- ✅ Real-time message updates
- ✅ Quick question buttons
- ✅ Typing indicators
- ✅ Responsive design (mobile-friendly)
- ✅ Session management
- ✅ API integration with backend

## Roadmap

### Phase 1: Core Infrastructure (Current)
- ✅ Project setup with Java 21 and Spring Boot
- ✅ Chatbot UI and API
- ✅ Basic analytics framework

### Phase 2: Data Integration
- ⏳ Alpha Vantage API client for gold prices
- ⏳ GDELT Project integration for events
- ⏳ Data collection scheduler
- ⏳ Database schema and migrations

### Phase 3: AI/ML Analytics
- ⏳ Implement Tribuo ML models for correlation analysis
- ⏳ Time series analysis with Apache Commons Math
- ⏳ Pattern recognition with Smile
- ⏳ Predictive modeling with Deeplearning4j

### Phase 4: Advanced Features
- ⏳ Interactive data visualizations
- ⏳ Historical event timeline
- ⏳ Custom date range queries
- ⏳ Export reports (PDF, CSV)
- ⏳ User authentication

## API Documentation

### POST /api/chat
Send a message to the chatbot and receive AI-generated insights.

**Request:**
```json
{
  "message": "What's the current gold price?",
  "sessionId": "session_123",
  "timestamp": "2025-11-13T10:00:00"
}
```

**Response:**
```json
{
  "message": "Based on the latest data, gold is currently trading at $2,650.50 per ounce...",
  "sessionId": "session_123",
  "timestamp": "2025-11-13T10:00:01",
  "type": "PRICE_ANALYSIS",
  "dataPoints": [],
  "metadata": {
    "confidence": 0.95,
    "dataPoints": 30
  }
}
```

## Project Status

🚀 **Active Development** - This project is being built completely using Claude Code as a demonstration of AI-assisted development with modern Java features.

## Contributing

This is a demonstration project. Contributions and suggestions welcome.

## License

*To be determined*

---

**Built with Claude Code** - Showcasing AI-assisted software development
