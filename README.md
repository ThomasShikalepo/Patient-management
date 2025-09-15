# 🏥 Patient Management System with Microservices

[![Java](https://img.shields.io/badge/Java-17-blue)](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)](https://spring.io/projects/spring-boot)
[![Docker](https://img.shields.io/badge/Docker-Container-blue)](https://www.docker.com/)
[![AWS](https://img.shields.io/badge/AWS-Cloud-orange)](https://aws.amazon.com/)

A **production-ready Patient Management System** built with **Java Spring Boot microservices**, containerized with Docker, and deployable to **AWS**. Designed for scalability and maintainability in healthcare systems.

---

## 📖 Overview

This project demonstrates:

- Microservice architecture with independent services
- RESTful API design for communication
- Containerization with Docker
- Deployment on AWS (EC2, RDS, S3)
- CI/CD automation for testing and deployment

---

## 🏗️ Project Structure

- **patient-service**: Manage patient records  
- **appointment-service**: Schedule and manage appointments  
- **notification-service**: Send notifications to patients  

Each service is self-contained with its own database and API endpoints.

---

## ⚙️ Prerequisites

- [Java 17+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)  
- [Maven](https://maven.apache.org/)  
- [Docker](https://www.docker.com/)  
- [AWS CLI](https://aws.amazon.com/cli/)  
- AWS Account

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/patient-management-system.git
cd patient-management-system
