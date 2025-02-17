# 🎬 Java Technical Exercise - DVD Rental Film Recommendation Service

This application provides **film recommendations** based on a customer's **rental history**.

It uses:
- **Java 21** with **Spring Boot**
- **PostgreSQL** (DVD Rental sample database)
- **Docker Compose** for **easy deployment**

---

## 🚀 **How to Run the Application**

### 🛠️ **Prerequisites**

- **Docker** installed on your system.
- **Git** installed (optional for cloning the repo).

---

### 🛠️ **Step 1: Clone the Repository**

```bash
git clone https://github.com/BenMaxwell1991/dvdrental-exercise.git
cd dvdrental-exercise
```

### 🛠️ **Step 2: docker compose**

```bash
docker-compose up --build
```

### 🛠️ **Step 3: test the endpoint**

Open your browser and visit the following URL to test the endpoint:
```bash
http://localhost:8080/api/recommendations/1
```