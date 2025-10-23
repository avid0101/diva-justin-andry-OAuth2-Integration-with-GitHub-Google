# OAuth2 Integration with GitHub & Google

A Spring Boot web application demonstrating secure OAuth2 authentication with **Google** and **GitHub**.  
This project showcases session-based security, automatic user registration, and a simple user profile management module.

---

## 🚀 Features

- 🔐 OAuth2 login with **Google** and **GitHub**
- 🧍 Automatic user registration for first-time logins
- 🔁 Returning logins link to existing users
- 👤 User profile:
  - View `displayName`, `bio`, `avatar`, and `email`
  - Edit `displayName` and `bio`
- 🧱 Session-based authentication (no JWT)
- 💾 H2 in-memory database for development
- 🛡️ CSRF protection enabled

---

## 🧰 Tech Stack

| Layer | Technology |
|-------|-------------|
| **Backend** | Spring Boot 3, Spring Security, Spring Data JPA |
| **Database** | H2 (dev), MySQL/PostgreSQL compatible |
| **Authentication** | spring-boot-starter-oauth2-client |
| **Frontend** | Thymeleaf templates |
| **Language / Build Tool** | Java 21, Maven |

---

## 📁 Project Structure

oauth2login/
├── src/
│ └── main/
│ ├── java/
│ │ └── divajustinandry/oauth2login/
│ │ ├── Oauth2loginApplication.java
│ │ ├── config/
│ │ ├── controller/
│ │ ├── model/
│ │ ├── repository/
│ │ └── service/
│ └── resources/
│ ├── templates/
│ │ ├── home.html
│ │ └── profile.html
│ ├── static/
│ └── application.properties
├── pom.xml
└── README.md
---

## 🧭 Getting Started

### 1️⃣ Clone the repository

```bash
git clone https://github.com/avid0101/diva-justin-andry-OAuth2-Integration-with-GitHub-Google.git
cd diva-justin-andry-OAuth2-Integration-with-GitHub-Google

2️⃣ Requirements

JDK 21

Maven

IDE (e.g., IntelliJ IDEA)

OAuth2 credentials from:

Google Cloud Console

GitHub Developer Settings

⚙️ Setup Guide
🔸 Google OAuth2

Visit Google Cloud Console

Create or select a project → APIs & Services → OAuth consent screen

Choose External

App name: CIT OAuth2 Login

Go to Credentials → Create Credentials → OAuth Client ID

Application type: Web application

Redirect URI:

http://localhost:8080/login/oauth2/code/google


Copy your Client ID and Client Secret

🔸 GitHub OAuth2

Go to GitHub → Settings → Developer Settings → OAuth Apps

Click New OAuth App

Fill in:

Application name: Spring OAuth2 Integration

Homepage URL: http://localhost:8080

Authorization callback URL:

http://localhost:8080/login/oauth2/code/github


Copy your Client ID and Client Secret

🔸 Add Environment Variables
GOOGLE_CLIENT_ID=<your_google_client_id>
GOOGLE_CLIENT_SECRET=<your_google_client_secret>
GITHUB_CLIENT_ID=<your_github_client_id>
GITHUB_CLIENT_SECRET=<your_github_client_secret>

▶️ Running the Application
mvn spring-boot:run


Then open:
👉 http://localhost:8080/

H2 Console:
👉 http://localhost:8080/h2-console

H2 Config:

spring.h2.console.path=/h2-console
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

📡 Endpoints
Method	Endpoint	Description
GET	/	Home page with login buttons
GET	/profile	View user profile
POST	/profile	Update display name or bio
GET	/logout	Logout and redirect home
🧩 Architecture Diagram
## 🧩 System Architecture

graph TD
    subgraph Frontend
        FE[Thymeleaf Templates]
    end

    subgraph Backend
        BE[Spring Boot + Spring Security]
        DB[(H2 / MySQL / PostgreSQL)]
    %% H2 is for development only
    end

    subgraph OAuth2 Providers
        Google[Google OAuth2]
        GitHub[GitHub OAuth2]
    end

    FE -->|Login Request| BE
    BE -->|Fetch & Persist User| DB
    BE -->|OAuth2 Flow| Google
    BE -->|OAuth2 Flow| GitHub
    FE -->|View/Edit Profile| BE
    FE -->|Logout| BE




👥 Developer

Justin Andry Diva 
IT342 - GO1
BSIT-4

