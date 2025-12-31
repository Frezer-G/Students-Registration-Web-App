Student Registration Servlet Application
Project Overview
This project is a simple Java web application built using Java Servlets, Apache Tomcat, and Maven.
The application allows users to:

Register students by submitting their name, email, and academic year.

View all registered students in a tabular format retrieved from a database.

The project demonstrates core concepts of:
Java Servlets
HTTP GET and POST methods
JDBC database connectivity
Maven project structure
Deployment on Apache Tomcat

Technologies Used
Java (JDK 8 or higher)
Java Servlets (Servlet API)
Apache Tomcat (v9 or v10)
Maven
JDBC
MySQL / PostgreSQL (any relational DB)
VS Code

Project Structure
student-registration/
│
├── src/main/java/
│   ├── config/
│   │   └── JakartaRestConfiguration.java
│   │
│   ├── resource/
│   │   └── JakartaEE8Resource.java
│   │
│   ├── model/
│   │   └── Student.java
│   │
│   └── database/
│       └── DatabaseConnection.java
│
├── src/main/webapp/
│
├── pom.xml
└── README.md


Application Features
1. Student Registration
Endpoint: POST /register
Input Fields:
Student Name
Email
Year

Process:
Data is received by the RegisterServlet
Input validation is performed
Data is inserted into the database using JDBC

2. View All Students
Endpoint: GET /show_all

Process:
ShowAllServlet connects to the database
Retrieves all student records
Displays them in an HTML table
Database Schema
Table Name: students
Column Name	Data Type	Constraints
id	INT	Primary Key, Auto Increment
name	VARCHAR(100)	NOT NULL
email	VARCHAR(100)	NOT NULL, UNIQUE
year	INT	NOT NULL

How the Project Works (Flow)
User opens the application in a browser.
The registration form is displayed.
User submits student details.

The servlet:
Reads request parameters
Validates input
Stores data in the database
User navigates to View Students.
Servlet fetches data and renders it in a table.

How to Run the Project
Step 1: Prerequisites
Make sure you have installed:
JDK 8 or later
Apache Tomcat
Maven
VS Code with Java extensions

Step 2: Database Setup
Create a database:
CREATE DATABASE student_db;
Create the table:

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    year INT NOT NULL
);

Update database credentials in your servlet or DB utility class.

Step 3: Maven Build
Open the project folder in VS Code and run:
mvn clean install
This will download dependencies and build the project.

Step 4: Configure Tomcat
Add Apache Tomcat server in VS Code.
Deploy the project to Tomcat.
Start the server.

Step 5: Access the Application
Open your browser and go to:
http://localhost:8080/student-registration/
Examples:
Registration page:
http://localhost:8080/student-registration/

View all students:
http://localhost:8080/student-registration/show_all

Common Issues & Solutions
404 Error:
Ensure servlet mappings are correct and Tomcat is running.

Database Connection Error:
Check JDBC URL, username, password, and database driver dependency.

Port Already in Use:
Change Tomcat port from 8080 in server.xml.

Conclusion

This project demonstrates a complete Java Servlet-based web application with database integration. It follows standard Maven structure and can be easily deployed using Apache Tomcat. It is suitable for academic labs and introductory web application development using Java.
