# 💰 expense-tracker-api

> **Project 1 of 10** · [30-Day Dev Roadmap](https://github.com/eswarr-dasi/dev-project-roadmap) · Started: Jun 21, 2026
>
> A production-style **REST API** for tracking personal expenses and budgets, built with **Spring Boot** and **PostgreSQL**.
> Demonstrates clean layered architecture, JPA data modeling, input validation, and exception handling.
>
> ---
>
> ## ✨ Features
>
> - **Expense CRUD** — Create, read, update, and delete expense records
> - - **Category management** — Group expenses by category (Food, Transport, Utilities, etc.)
>   - - **Budget tracking** — Set monthly budgets per category and track spending vs. budget
>     - - **Filtering & pagination** — Filter by date range, category, and amount; paginated responses
>       - - **Summary endpoint** — Monthly/weekly spending totals by category
>         - - **Input validation** — Bean Validation with meaningful error responses
>           - - **Global exception handling** — Consistent error envelope across all endpoints
>            
>             - ---
>
> ## 🛠️ Tech Stack
>
> | Layer | Technology |
> |-------|------------|
> | Language | Java 17 |
> | Framework | Spring Boot 3.x |
> | Data access | Spring Data JPA / Hibernate |
> | Database | PostgreSQL 15 |
> | Build tool | Maven |
> | Testing | JUnit 5, Mockito |
> | API docs | Springdoc OpenAPI (Swagger UI) |
>
> ---
>
> ## 📊 API Endpoints
>
> ### Expenses
>
> | Method | Endpoint | Description |
> |--------|----------|-------------|
> | `GET` | `/api/v1/expenses` | List all expenses (with filters + pagination) |
> | `POST` | `/api/v1/expenses` | Create a new expense |
> | `GET` | `/api/v1/expenses/{id}` | Get expense by ID |
> | `PUT` | `/api/v1/expenses/{id}` | Update an expense |
> | `DELETE` | `/api/v1/expenses/{id}` | Delete an expense |
> | `GET` | `/api/v1/expenses/summary` | Monthly spending summary by category |
>
> ### Categories
>
> | Method | Endpoint | Description |
> |--------|----------|-------------|
> | `GET` | `/api/v1/categories` | List all categories |
> | `POST` | `/api/v1/categories` | Create a category |
>
> ### Budgets
>
> | Method | Endpoint | Description |
> |--------|----------|-------------|
> | `GET` | `/api/v1/budgets` | List all budgets |
> | `POST` | `/api/v1/budgets` | Set a monthly budget |
> | `GET` | `/api/v1/budgets/status` | Spending vs. budget status |
>
> ---
>
> ## 🏗️ Architecture
>
> ```
> src/main/java/com/eswarr/expensetracker/
> ├── controller/          # REST controllers (HTTP layer)
> ├── service/             # Business logic
> ├── repository/          # Spring Data JPA repositories
> ├── model/               # JPA entities
> ├── dto/                 # Request/Response DTOs
> ├── exception/           # Custom exceptions + global handler
> └── config/              # App configuration
> ```
>
> **Design decisions:**
> - DTOs decouple the API contract from the database schema
> - - `@ControllerAdvice` handles all exceptions in one place
>   - - Service layer is tested independently using Mockito (no DB needed)
>     - - Pagination uses Spring's `Pageable` for consistent behaviour
>      
>       - ---
>
> ## 🚀 Getting Started
>
> ### Prerequisites
> - Java 17+
> - - PostgreSQL 15+ running locally
>   - - Maven 3.8+
>    
>     - ### 1. Clone the repo
>     - ```bash
>       git clone https://github.com/eswarr-dasi/expense-tracker-api.git
>       cd expense-tracker-api
>       ```
>
> ### 2. Configure the database
> Create a database and update `src/main/resources/application.properties`:
> ```properties
> spring.datasource.url=jdbc:postgresql://localhost:5432/expense_tracker
> spring.datasource.username=your_username
> spring.datasource.password=your_password
> spring.jpa.hibernate.ddl-auto=update
> ```
>
> ### 3. Run
> ```bash
> mvn spring-boot:run
> ```
>
> ### 4. Explore the API
> Open Swagger UI: `http://localhost:8080/swagger-ui.html`
>
> ---
>
> ## 🧪 Testing
>
> ```bash
> mvn test
> ```
>
> Test coverage includes:
> - Service layer unit tests (Mockito)
> - - Controller integration tests (MockMvc)
>   - - Repository slice tests (@DataJpaTest)
>    
>     - ---
>
> ## 📝 Sample Request
>
> **Create an expense:**
> ```http
> POST /api/v1/expenses
> Content-Type: application/json
>
> {
>   "amount": 45.50,
>   "description": "Grocery run",
>   "categoryId": 1,
>   "date": "2026-06-21"
> }
> ```
>
> **Response:**
> ```json
> {
>   "id": 101,
>   "amount": 45.50,
>   "description": "Grocery run",
>   "category": "Food",
>   "date": "2026-06-21",
>   "createdAt": "2026-06-21T10:30:00Z"
> }
> ```
>
> ---
>
> ## 🎯 Career Relevance
>
> This project directly mirrors the **reconciliation and bank-payments financial workflows** I build
> professionally at Valens Software — REST API design, Spring Boot layered architecture, PostgreSQL data
> modeling, JPA, and comprehensive testing are all daily-use skills for Senior/Staff Full-Stack roles.
>
> ---
>
> ## 📅 Part of the 30-Day Dev Challenge
>
> | # | Project | Date |
> |---|---------|------|
> | **1** | **expense-tracker-api** *(this)* | Jun 21 |
> | 2 | react-dashboard-ui | Jun 24 |
> | 3 | batch-data-migrator | Jun 27 |
> | 4 | auth-service | Jun 30 |
> | 5 | log-analyzer-cli | Jul 03 |
> | ... | ... | ... |
>
> See the full roadmap: [dev-project-roadmap](https://github.com/eswarr-dasi/dev-project-roadmap)
>
> ---
>
> *Built by [Eswarr Dasi](https://github.com/eswarr-dasi) · Jun 2026*
