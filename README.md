#  Smart Job Portal
A full-stack Job Portal web application developed using Spring Boot, Thymeleaf, MySQL, Bootstrap, and JPA/Hibernate.
## Project Overview
Smart Job Portal is a web-based platform that connects job seekers and recruiters. Users can register, create profiles, search and apply for jobs, while administrators can manage jobs, applications, and users through a dedicated dashboard.
##  Features

### User Features
* User Registration & Login
* Role-Based Authentication
* Attractive User Dashboard
* Profile View & Edit
* Browse Available Jobs
* Apply for Jobs
* Upload Resume
* Download Resume
* Save Jobs
* View Application Status
* Job Recommendations
* Skill Demand Analysis

### Admin Features

* Admin Dashboard
* Add New Jobs
* Edit/Delete Jobs
* View All Users
* View Job Applications
* Approve Applications
* Reject Applications
* Portal Analytics
* Dashboard Statistics
* 
## Technologies Used

### Backend

* Java
* Spring Boot
* Spring MVC
* Spring Data JPA
* Hibernate

### Frontend

* HTML5
* CSS3
* Bootstrap 5
* Thymeleaf

### Database

* MySQL

### Tools

* Maven
* Git
* GitHub
* VS Code / Eclipse / IntelliJ IDEA

## Project Structure

src/main/java
├── controller
├── entity
├── repository

src/main/resources
├── templates
├── application.properties

uploads
├── Resume Files

## Database

Create a MySQL database:
CREATE DATABASE jobportal;
Update application.properties with your MySQL username and password.
Example:
spring.datasource.url=jdbc:mysql://localhost:3306/jobportal
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

## Running the Project

1. Clone the repository
git clone https://github.com/vaish-debug/SmartJobPortal.git
2. Open the project in your IDE
3. Configure MySQL database
4. Run:
JobportalApplication.java
5. Open browser:
http://localhost:8080

## Modules

* User Management
* Job Management
* Application Management
* Resume Management
* Recommendation System
* Dashboard Analytics
* 
## Future Enhancements

* Email Notifications
* Forgot Password
* Job Search Filters
* Profile Picture Upload
* Interview Scheduling
* AI-Based Recommendations
* 
## Developer

Sampurna Adike
B.Tech Student
Smart Job Portal Internship Project – 2026

## Screenshots
<img width="695" height="591" alt="image" src="https://github.com/user-attachments/assets/4a9d91ad-1b74-4b74-ab90-7e2d2653304b" />
* Login Page
  
* Registration Page
* User Dashboard
* Admin Dashboard
* Job Listings
* Profile Page
* Application Management
* 
## License
This project is developed for educational and internship purposes.
