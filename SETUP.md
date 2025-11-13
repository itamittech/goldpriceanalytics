# Setup Guide - Gold Price Analytics

This guide will help you set up and run the Gold Price Analytics application locally.

## ✅ Security Check

**Good News**: No sensitive information (API keys, passwords, etc.) has been committed to this repository. All sensitive configuration uses environment variables.

## Prerequisites

### Required Software

1. **Java 21 (JDK)**
   - Download: [OpenJDK 21](https://jdk.java.net/21/) or [Oracle JDK 21](https://www.oracle.com/java/technologies/downloads/#java21)
   - Verify installation:
     ```bash
     java -version
     # Should show: java version "21.0.x"
     ```

2. **Maven 3.8+**
   - Download: [Apache Maven](https://maven.apache.org/download.cgi)
   - Verify installation:
     ```bash
     mvn -version
     ```

3. **Node.js 18+ and npm**
   - Download: [Node.js](https://nodejs.org/)
   - Verify installation:
     ```bash
     node -v
     npm -v
     ```

## Quick Start (No API Keys Required)

The application works **out of the box** without API keys for basic functionality:

### 1. Clone the Repository

```bash
git clone <your-repo-url>
cd goldpriceanalytics
```

### 2. Run the Backend

```bash
# Build the project
mvn clean install

# Run the Spring Boot application
mvn spring-boot:run
```

The backend will start on `http://localhost:8080`

**Test it:**
```bash
curl http://localhost:8080/api/chat/health
# Should return: "Chatbot service is running"
```

### 3. Run the Frontend

Open a new terminal:

```bash
cd frontend
npm install
npm run dev
```

The frontend will start on `http://localhost:5173`

### 4. Open in Browser

Navigate to: `http://localhost:5173`

You'll see the chatbot interface! Try asking:
- "What's the current gold price?"
- "How do conflicts affect gold prices?"
- "Show me recent trends"

**Note**: Currently returns mock data. See below to configure real data sources.

## 🔑 API Keys Configuration (Optional - For Real Data)

To fetch real gold prices and event data, you'll need API keys:

### Free API Keys

#### 1. Alpha Vantage (Gold Prices)
- **Free Tier**: 25 requests/day
- **Sign up**: [https://www.alphavantage.co/support/#api-key](https://www.alphavantage.co/support/#api-key)
- **Cost**: FREE

#### 2. NewsAPI (News Events)
- **Free Tier**: 100 requests/day
- **Sign up**: [https://newsapi.org/register](https://newsapi.org/register)
- **Cost**: FREE

#### 3. GDELT Project (Geopolitical Events)
- **Access**: Completely free via Google BigQuery
- **No API key needed**: Public dataset
- **Info**: [https://www.gdeltproject.org/](https://www.gdeltproject.org/)

### Configure API Keys

You have two options:

#### Option 1: Environment Variables (Recommended)

**On Linux/Mac:**
```bash
export ALPHA_VANTAGE_API_KEY="your_alpha_vantage_key_here"
export NEWS_API_KEY="your_news_api_key_here"
mvn spring-boot:run
```

**On Windows (Command Prompt):**
```cmd
set ALPHA_VANTAGE_API_KEY=your_alpha_vantage_key_here
set NEWS_API_KEY=your_news_api_key_here
mvn spring-boot:run
```

**On Windows (PowerShell):**
```powershell
$env:ALPHA_VANTAGE_API_KEY="your_alpha_vantage_key_here"
$env:NEWS_API_KEY="your_news_api_key_here"
mvn spring-boot:run
```

#### Option 2: Local Configuration File

Create a file: `src/main/resources/application-local.yml`

```yaml
api:
  alpha-vantage:
    key: your_alpha_vantage_key_here
  news-api:
    key: your_news_api_key_here
```

Run with local profile:
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=local
```

**Note**: `application-local.yml` is already in `.gitignore` and won't be committed.

## 🗄️ Database Configuration

### Current Setup (H2 In-Memory)

By default, the app uses **H2 in-memory database** - no setup required!

- **Access H2 Console**: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:goldanalyticsdb`
- **Username**: `sa`
- **Password**: (leave empty)

### Optional: PostgreSQL Setup

For production use with persistent data:

1. **Install PostgreSQL**:
   ```bash
   # Ubuntu/Debian
   sudo apt-get install postgresql

   # macOS (Homebrew)
   brew install postgresql
   ```

2. **Create Database**:
   ```bash
   psql -U postgres
   CREATE DATABASE goldanalytics;
   CREATE USER golduser WITH PASSWORD 'your_password';
   GRANT ALL PRIVILEGES ON DATABASE goldanalytics TO golduser;
   ```

3. **Update Configuration**:

   Create `src/main/resources/application-local.yml`:
   ```yaml
   spring:
     datasource:
       url: jdbc:postgresql://localhost:5432/goldanalytics
       username: golduser
       password: your_password
       driver-class-name: org.postgresql.Driver
     jpa:
       properties:
         hibernate:
           dialect: org.hibernate.dialect.PostgreSQLDialect
   ```

4. **Run with PostgreSQL**:
   ```bash
   mvn spring-boot:run -Dspring-boot.run.profiles=local
   ```

## 🚀 Running in Production Mode

### Build for Production

```bash
# Build backend JAR
mvn clean package -DskipTests

# Build frontend
cd frontend
npm run build
```

### Run Production Build

```bash
# Run the JAR with production profile
java -jar target/gold-price-analytics-1.0.0-SNAPSHOT.jar \
  --spring.profiles.active=prod \
  --ALPHA_VANTAGE_API_KEY=your_key \
  --NEWS_API_KEY=your_key
```

## 🐳 Docker Setup (Coming Soon)

Docker support will be added in Phase 2 for easy deployment.

## 🧪 Testing the Application

### Test Backend Endpoints

```bash
# Health check
curl http://localhost:8080/api/chat/health

# Send a chat message
curl -X POST http://localhost:8080/api/chat \
  -H "Content-Type: application/json" \
  -d '{
    "message": "What is the current gold price?",
    "sessionId": "test_session",
    "timestamp": "2025-11-13T10:00:00"
  }'
```

### Run Unit Tests

```bash
mvn test
```

## 📊 Monitoring

### Application Logs

Logs are configured in `application.yml`:
- **Application logs**: INFO level
- **Spring Web logs**: INFO level
- **Hibernate logs**: WARN level

### H2 Database Console

Access the database while the app is running:
1. Navigate to: `http://localhost:8080/h2-console`
2. Enter connection details (see Database Configuration above)
3. View tables: `GOLD_PRICES`, `GEOPOLITICAL_EVENTS`

## 🔧 Troubleshooting

### Backend Issues

**Issue**: `Port 8080 already in use`
```bash
# Find process using port 8080
lsof -i :8080  # Mac/Linux
netstat -ano | findstr :8080  # Windows

# Kill the process or change port in application.yml
server:
  port: 8081
```

**Issue**: `Java version mismatch`
```bash
# Check Java version
java -version

# Set JAVA_HOME (Mac/Linux)
export JAVA_HOME=/path/to/java-21

# Set JAVA_HOME (Windows)
set JAVA_HOME=C:\path\to\java-21
```

### Frontend Issues

**Issue**: `Port 5173 already in use`
```bash
# Vite will automatically try next available port
# Or kill the process:
lsof -i :5173  # Mac/Linux
netstat -ano | findstr :5173  # Windows
```

**Issue**: `Cannot connect to backend`
- Ensure backend is running on `http://localhost:8080`
- Check browser console for CORS errors
- Verify backend health: `curl http://localhost:8080/api/chat/health`

**Issue**: `npm install fails`
```bash
# Clear npm cache
npm cache clean --force
rm -rf node_modules package-lock.json
npm install
```

## 🎯 Verifying Everything Works

1. **Backend Running**:
   - Open `http://localhost:8080/api/chat/health`
   - Should see: "Chatbot service is running"

2. **Frontend Running**:
   - Open `http://localhost:5173`
   - Should see purple gradient chatbot interface

3. **Integration Working**:
   - Type a message in the chatbot
   - Should receive AI-generated response
   - Check browser console for any errors

## 🔐 Security Best Practices

1. **Never commit API keys** - Already protected by `.gitignore`
2. **Use environment variables** for sensitive data
3. **Rotate API keys regularly**
4. **Use HTTPS in production**
5. **Enable authentication** for production deployments

## 📚 Next Steps

Once everything is running:

1. **Explore the chatbot** - Try different queries
2. **Check the code** - See how Java 21 features are used
3. **Read the README** - Learn about the AI/ML architecture
4. **Contribute** - Add new features or improve existing ones

## 🆘 Getting Help

- **Check logs**: Console output shows detailed error messages
- **GitHub Issues**: Report bugs or request features
- **README.md**: Comprehensive project documentation

## 🎓 Learning Resources

- [Java 21 Documentation](https://docs.oracle.com/en/java/javase/21/)
- [Spring Boot Guide](https://spring.io/guides/gs/spring-boot/)
- [React TypeScript](https://react-typescript-cheatsheet.netlify.app/)
- [Deeplearning4j](https://deeplearning4j.konduit.ai/)

---

**Ready to go!** 🚀 Start with `mvn spring-boot:run` in one terminal and `npm run dev` in another.
