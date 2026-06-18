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
  
  <img width="1312" height="915" alt="image" src="https://github.com/user-attachments/assets/8786adca-406e-4c94-acc5-95624ebd7237" />
  
* Registration Page
  
  <img width="1722" height="876" alt="image" src="https://github.com/user-attachments/assets/a3dcd953-2e6d-4bb1-baa6-fde51a1c5568" />
  
* User Dashboard
  
  <img width="1708" height="1858" alt="image" src="https://github.com/user-attachments/assets/a848bc84-e14d-4c64-81c5-ab0ef5e01af7" />

* Admin Dashboard
  
  <img width="1675" height="522" alt="image" src="https://github.com/user-attachments/assets/243d7a3a-25f9-4287-a2a7-7a8e1341b673" />

* Job Listings
  
  <img width="1683" height="830" alt="image" src="https://github.com/user-attachments/assets/87224d92-ab0a-4021-b144-67e1a07dcc8c" />

* Profile Page
  
  <img width="1672" height="502" alt="image" src="https://github.com/user-attachments/assets/aec8a05a-e2a5-439d-897c-69fa7128166a" />

* Application Management
  
## License
This project is developed for educational and internship purposes.
