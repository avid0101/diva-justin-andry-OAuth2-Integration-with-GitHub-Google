# OAuth2 Integration with GitHub & Google

A Spring Boot web application demonstrating secure OAuth2 authentication with **Google** and **GitHub**.  
This project showcases session-based security, automatic user registration, and a simple user profile management module.

---

## 🚀 Features

- OAuth2 login with **Google** and **GitHub**
- Automatic user registration for first-time logins
- Returning logins link to existing users
- 👤 User profile:  
  - View `displayName`, `bio`, `avatar`, and `email`  
  - Edit `displayName` and `bio`
- Session-based authentication (no JWT)
- H2 in-memory database for development
- CSRF protection enabled

---

## 🧰 Tech Stack

| Layer          | Technology                                    |
| -------------- | --------------------------------------------- |
| **Backend**    | Spring Boot 3, Spring Security, Spring Data JPA |
| **Database**   | H2 (development), MySQL/PostgreSQL compatible  |
| **Authentication** | spring-boot-starter-oauth2-client              |
| **Frontend**   | Thymeleaf templates                            |
| **Language / Build Tool** | Java 21, Maven                            |

---

## 🧭 Getting Started

### 1️⃣ Clone the Repository

git clone https://github.com/avid0101/diva-justin-andry-OAuth2-Integration-with-GitHub-Google.git

### 2️⃣ Prerequisites

- JDK 21
- Maven
- IDE (e.g., IntelliJ IDEA)
- OAuth2 credentials from:
  - Google Cloud Console
  - GitHub Developer Settings

---

### ⚙️ Setup Guide

#### Google OAuth2 Setup

1. Go to [Google Cloud Console](https://console.cloud.google.com/).
2. Create or select a project → APIs & Services → OAuth consent screen.
3. Choose **External**.
4. App name: `CIT OAuth2 Login`.
5. Go to Credentials → Create Credentials → OAuth Client ID.
6. Application type: **Web application**.
7. Add Redirect URI:  
   `http://localhost:8080/login/oauth2/code/google`.
8. Copy your Client ID and Client Secret.

#### GitHub OAuth2 Setup

1. Go to GitHub → Settings → Developer Settings → OAuth Apps.
2. Click **New OAuth App**.
3. Fill in:
   - Application name: `Spring OAuth2 Integration`
   - Homepage URL: `http://localhost:8080`
   - Authorization callback URL:  
     `http://localhost:8080/login/oauth2/code/github`
4. Copy your Client ID and Client Secret.

#### Environment Variables

Set OAuth2 credentials in your cmd prompt:

set GOOGLE_CLIENT_ID=<your_google_client_id>
set GOOGLE_CLIENT_SECRET=<your_google_client_secret>
set GITHUB_CLIENT_ID=<your_github_client_id>
set GITHUB_CLIENT_SECRET=<your_github_client_secret>


---

### ▶️ Running the Application
mvn spring-boot:run

Open your browser and access:

- Application: [http://localhost:8080/](http://localhost:8080/)
- H2 Console: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

H2 Console Configuration:

spring.h2.console.path=/h2-console
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=


---

## 📡 API Endpoints

| Method | Endpoint      | Description                    |
| ------ | ------------- | ------------------------------|
| GET    | `/`           | Home page with login buttons  |
| GET    | `/profile`    | View user profile             |
| POST   | `/profile`    | Update display name or bio    |
| GET    | `/logout`     | Logout and redirect to home   |

---

## 🧩 System Architecture

```
+----------------------+
|      Frontend        |
|----------------------|
|  Thymeleaf / ReactJS |
+----------+-----------+
           |
           |  Login Request / Profile / Logout
           v
+-------------------------------+
|            Backend            |
|-------------------------------|
| Spring Boot + Spring Security |
+---------------+---------------+
                |
                |  Fetch & Persist User
                v
        +------------------------+
        |       Database         |
        |------------------------|
        | H2 / MySQL / PostgreSQL|
        +------------------------+
                ^
                |
                |  OAuth2 Flow
+----------------+        +----------------+
|  Google OAuth2 |        |  GitHub OAuth2 |
+----------------+        +----------------+
```


## 👥 Developer

**Justin Andry Diva**  
IT342 - GO1  
BSIT-4

---



