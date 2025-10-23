# OAuth2 Integration with GitHub & Google

A Spring Boot web application demonstrating secure OAuth2 authentication with **Google** and **GitHub**.  
This project showcases session-based security, automatic user registration, and a simple user profile management module.

---

## 🚀 Features

-  OAuth2 login with **Google** and **GitHub**
-  Automatic user registration for first-time logins
-  Returning logins link to existing users
- 👤 User profile:
  - View `displayName`, `bio`, `avatar`, and `email`
  - Edit `displayName` and `bio`
-  Session-based authentication (no JWT)
-  H2 in-memory database for development
-  CSRF protection enabled

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

🔸 Paste this on the Command Prompt

set GOOGLE_CLIENT_ID=<your_google_client_id>
set GOOGLE_CLIENT_SECRET=<your_google_client_secret>
set GITHUB_CLIENT_ID=<your_github_client_id>
set GITHUB_CLIENT_SECRET=<your_github_client_secret>

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

%% OAuth2 Login App Architecture Diagram
flowchart TD

    %% ===============================
    %% Frontend Layer
    %% ===============================
    subgraph Frontend ["🌐 Frontend (ReactJS / Thymeleaf)"]
        FE1["Home Page (Login Buttons)"]
        FE2["Profile Page (View / Edit)"]
    end

    %% ===============================
    %% Backend Layer
    %% ===============================
    subgraph Backend ["⚙️ Backend (Spring Boot + Spring Security)"]
        BE1["OAuth2 Controller"]
        BE2["User Controller (Profile APIs)"]
        BE3["CustomOAuth2UserService"]
        DB[("🗄️ Database<br/>(H2 / MySQL / PostgreSQL)")]
    end

    %% ===============================
    %% OAuth2 Providers
    %% ===============================
    subgraph OAuthProviders ["🔐 OAuth2 Providers"]
        Google["Google OAuth2"]
        GitHub["GitHub OAuth2"]
    end

    %% ===============================
    %% Flows
    %% ===============================
    FE1 -->|User clicks 'Login with Google/GitHub'| BE1
    BE1 -->|Redirects to Provider| Google
    BE1 -->|Redirects to Provider| GitHub
    Google -->|Returns Auth Token| BE1
    GitHub -->|Returns Auth Token| BE1

    BE1 -->|Fetch & Persist User Data| BE3
    BE3 -->|Save/Update User Info| DB

    FE2 -->|GET /profile| BE2
    FE2 -->|POST /profile (Update)| BE2
    BE2 -->|Fetch / Update Profile Data| DB

    FE2 -->|GET /logout| BE1

    %% Styling
    classDef section fill:#f9f9f9,stroke:#bbb,stroke-width:1px,rounded-corners:10px;
    classDef box fill:#fff,stroke:#555,stroke-width:1px,rounded-corners:8px,shadow:2px;
    class Frontend,Backend,OAuthProviders section;
    class FE1,FE2,BE1,BE2,BE3,DB,Google,GitHub box;


👥 Developer

Justin Andry Diva 
IT342 - GO1
BSIT-4

