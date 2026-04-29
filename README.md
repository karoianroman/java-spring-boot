# Java Spring Boot Backend

A production-ready Spring Boot microservice boilerplate. This project demonstrates a robust backend architecture integrated with a high-standard **DevSecOps** pipeline, specifically tailored for enterprise-grade deployments on **Google Cloud Platform (GCP)**.

## 🚀 Overview

This repository showcases a clean, scalable Java backend setup. It focuses on automation, containerization, and advanced security scanning to ensure that every deployment to **Cloud Run** is stable and secure.

## 🛠 Tech Stack

- **Backend:** Java 17+, Spring Boot 3.x, Maven/Gradle
- **Containerization:** Docker (Multi-stage builds)
- **Cloud Provider:** Google Cloud Platform (Cloud Run, Artifact Registry, Cloud SQL)
- **CI/CD:** GitHub Actions
- **Security:** Gitleaks, Hadolint, Trivy, SonarLint/Checkstyle

---

## 🏗 CI/CD Pipeline (DevSecOps)

The pipeline is designed to enforce quality and security at every stage of the development lifecycle:

### 🛡️ Security & Quality Gates
* **Gitleaks:** Scans for sensitive data (passwords, GCP keys) in the codebase.
* **Hadolint:** Ensures the `Dockerfile` is optimized (e.g., using non-root users, minimizing layers).
* **Trivy Scan:** Scans the final JAR-based Docker image for vulnerabilities in the JRE and dependencies.
* **Static Code Analysis:** (Optional/Included) Checkstyle or Maven Enforcer rules to maintain Java coding standards.

### 📦 Deployment Flow
* **Workload Identity Federation:** Secure, keyless authentication between GitHub and Google Cloud.
* **Artifact Registry:** Automates the build and push of the Java container image tagged with the Git SHA.
* **Cloud Run:** Serverless deployment with fine-tuned JVM memory management and auto-scaling.
* **Database Integration:** Configured for secure connections to **Cloud SQL** (PostgreSQL/MySQL) via Secret Manager.

### 🧪 Testing Strategy
* **JUnit & Mockito:** Automated execution of unit and integration tests during the `mvn package` phase.
* **Smoke Test:** Post-deployment validation using `curl` to verify the `/actuator/health` or API endpoints are live.

---

## 🚦 Getting Started

### Prerequisites
- [JDK 17+](https://adoptium.net/)
- [Maven](https://maven.apache.org/) or [Gradle](https://gradle.org/)
- [Docker](https://www.docker.com/)

### Local Development
1. **Clone the repository:**
   ```bash
   git clone [https://github.com/karoianroman/java-spring-boot-backend.git](https://github.com/karoianroman/java-spring-boot-backend.git)
   cd java-spring-boot-backend

    Build the project:
    Bash

    ./mvnw clean install

    Run the application:
    Bash

    ./mvnw spring-boot:run

    Run tests:
    Bash

    ./mvnw test