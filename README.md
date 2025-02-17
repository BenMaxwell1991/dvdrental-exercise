# 🎬 DVD Rental Film Recommendation Service

This application provides **film recommendations** based on a customer's **rental history**.

## 🚀 **How to Run the Application**

### 🛠️ **Prerequisites**

- **Docker** installed and running on your system.
- **Git** installed to clone the repo.

---

### 🛠️ **Step 1: Clone the Repository**

Clone the repository and navigate to the project directory.

```bash
git clone https://github.com/BenMaxwell1991/dvdrental-exercise.git
cd dvdrental-exercise
```

### 🛠️ **Step 2: docker compose**

Using docker compose, build and run the application.

```bash
docker-compose up --build
```

### 🛠️ **Step 3: test the endpoint**

Open your browser and visit the following URL to test the endpoint:
```bash
http://localhost:8080/api/recommendations/1
```