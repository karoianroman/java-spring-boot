# React Smoke Test & Cloud Run Deployment

A specialized project demonstrating a secure **DevSecOps** pipeline for containerized React applications, featuring automated deployment to **Google Cloud Platform (GCP)**.

## 🚀 Overview

This repository showcases a fully automated workflow that builds, scans, and deploys a React application to **Cloud Run**. The focus is on infrastructure security and verified cloud availability.

## 🛠 Tech Stack

- **Frontend:** React, Vite, pnpm
- **Containerization:** Docker
- **Cloud Provider:** Google Cloud Platform (Cloud Run, Artifact Registry)
- **CI/CD:** GitHub Actions
- **Security:** Gitleaks, Hadolint, Trivy

---

## 🏗 CI/CD & DevSecOps Pipeline

The automation in this project (GitHub Actions) performs a high-standard security audit and deployment flow:

### 🛡️ Security Gates (Automated)
* **Secret Scanning (Gitleaks):** Checks every commit for exposed API keys, tokens, or credentials.
* **Dockerfile Linting (Hadolint):** Validates the Dockerfile for security best practices (e.g., proper base images and layer optimization).
* **Vulnerability Scanning (Trivy):** Scans the final Docker image for OS-level and library vulnerabilities (CVEs) before deployment.

### 📦 Cloud Deployment Flow
* **Workload Identity Federation:** Secure, keyless authentication to Google Cloud—no static Service Account keys required.
* **Automated Build & Push:** Packages the app into a Docker container and stores it in **Artifact Registry**.
* **Serverless Hosting:** Deploys directly to **Cloud Run** with automated IAM configuration for public access.

### 🔥 Verification
* **Post-Deployment Smoke Test:** Once the deploy is complete, the pipeline automatically retrieves the live URL and uses `curl` to verify that the application is running and accessible (HTTP 200).

---

## 🚦 Local Setup

### Installation
```bash
pnpm install

Build & Run
Bash

pnpm build
# To run with Docker locally:
docker build -t react-smoke-test .
docker run -p 8080:8080 react-smoke-test