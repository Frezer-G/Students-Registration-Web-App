# RegisterShowAll Servlet Web Application

A simple Java Servlet–based web application for student registration and listing. This project demonstrates core concepts of Java Servlets, JDBC, and database integration using Apache NetBeans and Apache Tomcat.

---

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Application Flow](#application-flow)
- [Endpoints](#endpoints)
- [Database Schema](#database-schema)
- [Project Structure](#project-structure)
- [Setup & Installation](#setup--installation)
- [Validation Rules](#validation-rules)
- [Future Improvements](#future-improvements)
- [License](#license)

---

## Overview

**RegisterShowAll** is a basic servlet web application that allows users to register students into a database and view all registered students in a table. It follows a simple MVC-style approach where servlets act as controllers and JSP/HTML handle the presentation layer.

---

## Features

- Student registration via HTML form
- Server-side input validation
- Persistent data storage using a relational database
- Display of all registered students in tabular format
- Simple and clean structure suitable for learning purposes

---

## Tech Stack

- Java (JDK 8+)
- Java Servlets (Jakarta Servlet API)
- Apache NetBeans IDE
- Apache Tomcat
- JDBC
- MySQL or PostgreSQL
- HTML / CSS

---

## Application Flow

1. User fills out the student registration form
2. Form data is submitted to the `RegisterServlet`
3. Servlet validates and stores the data in the database
4. User can navigate to view all registered students
5. The `ShowAllServlet` retrieves and displays student data

---

## Endpoints

### Register Student

- **Method:** POST  
- **URL:** `/register`  
- **Description:** Accepts student name, email, and year, validates input, and inserts the record into the database.

### Show All Students

- **Method:** GET  
- **URL:** `/show_all`  
- **Description:** Fetches all student records and displays results in an HTML table.

---

## Database Schema

**Table Name:** `students`

| Column | Type         | Constraints                 |
|--------|--------------|----------------------------|
| id     | INT          | Primary Key, Auto Increment |
| name   | VARCHAR(100) | Not Null                    |
| email  | VARCHAR(100) | Not Null, Unique            |
| year   | INT          | Not Null                    |

---

## Project Structure

RegisterShowAll/
├── src/
│ └── java/
│ └── servlet/
│ ├── RegisterServlet.java
│ └── ShowAllServlet.java
├── web/
│ ├── index.html
│ ├── register.jsp
│ └── show_all.jsp
├── WEB-INF/
│ └── web.xml
└── README.md


---

## Setup & Installation

1. Install **Apache NetBeans** and **Apache Tomcat**
2. Create a new Java Web Application project
3. Configure Tomcat as the server
4. Create the `students` table in your database
5. Update JDBC connection details in the servlets
6. Build and deploy the application
7. Access the app via a web browser

---

## Validation Rules

- Name must not be empty
- Email must be unique and not empty
- Year must be a valid integer

---

## Future Improvements

- Update and delete student records
- Client-side validation
- Pagination and search
- Improved UI styling
- Authentication support

---

## License

This project is provided for educational and learning purposes.

