# Java Spring Boot Backend (GCP Cloud Run)

A production-ready Spring Boot microservice demonstrating a high-standard **DevSecOps** pipeline for automated deployment to **Google Cloud Platform (GCP)**.

## 🚀 Project Overview

This repository showcases a professional backend architecture integrated with **GitHub Actions**. The pipeline handles everything from security auditing and container scanning to automated serverless deployment and **Cloud SQL** integration.

## 🛠 Tech Stack

- **Backend:** Java 17, Spring Boot 3.x
- **Infrastructure:** Docker, Google Cloud Run, Artifact Registry
- **Database:** Google Cloud SQL (PostgreSQL)
- **CI/CD:** GitHub Actions
- **Security Tools:** Gitleaks, Hadolint, Trivy

---

## 🏗 CI/CD & DevSecOps Pipeline

The automation flow (`CI-CD.yml`) ensures that every update is secure and verified before reaching production:

### 🛡️ Security & Quality Gates
* **Secret Scanning (Gitleaks):** Automatically checks for exposed passwords, API keys, or GCP credentials in the source code.
* **Dockerfile Linting (Hadolint):** Validates the `Dockerfile` for security best practices and layer optimization.
* **Image Vulnerability Scan (Trivy):** Scans the final Docker image for OS-level and library vulnerabilities (CVEs). The pipeline fails if **CRITICAL** or **HIGH** issues are found.

### 📦 Deployment Flow
* **Workload Identity Federation:** Secure, keyless authentication between GitHub and Google Cloud (eliminates the need for static Service Account JSON keys).
* **Automated Build & Push:** Packages the Java application into a Docker container and stores it in **Artifact Registry**.
* **Cloud Run Deployment:** Deploys the service to the `europe-west1` region with optimized memory limits (512Mi).
* **Database Integration:** Automatically connects to **Cloud SQL** using a secure socket factory and environment variables managed via GitHub Secrets.

### 🔥 Verification
* **Post-Deployment Smoke Test:** The pipeline retrieves the live service URL and uses `curl` to verify that the application (or `/actuator/health` endpoint) is responding with a success status.

---

## 🚦 Local Setup

### Prerequisites
- JDK 17+
- Maven
- Docker

### Commands
1. **Build the project:**
   ```bash
   ./mvnw clean install

    Run the application:
    Bash

    ./mvnw spring-boot:run

    Local Containerization:
    Bash

    docker build -t spring-demo .
    docker run -p 8080:8080 spring-demo