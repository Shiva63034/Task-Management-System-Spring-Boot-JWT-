# 🚀 Task Management System (Spring Boot + JWT)

## 📌 Project Overview
A secure and scalable Task Management REST API built using Spring Boot.  
This application enables users to register, authenticate, and efficiently manage tasks with role-based access control using JWT authentication.

---

## ✨ Key Features
- 🔐 Secure User Authentication (JWT-based login system)
- 👤 User Registration & Login with encrypted passwords
- 🛡️ Role-Based Authorization (Admin & User roles)
- 📋 Full Task Management (Create, Read, Update, Delete)
- 🔍 Fetch tasks by user and task ID
- 🚫 Protected endpoints using Spring Security
- ⚡ Stateless session management using JWT tokens
- 🧩 Clean layered architecture (Controller → Service → Repository)
- 💾 Persistent storage using MySQL database
- 📦 Maven-based project structure
- 🔄 Exception handling for better API responses

---

## 🛠️ Technologies Used
- ☕ Java
- 🌱 Spring Boot
- 🔐 Spring Security
- 🎟️ JWT (JSON Web Token)
- 🗄️ Hibernate / JPA
- 🐬 MySQL
- 📦 Maven

---

## 📂 Project Structure
src/main/java/com/shiva/shiva/
│
├── controller # REST Controllers
├── service # Business Logic
├── repository # Database Access
├── entity # Database Models
├── payload # DTOs (Data Transfer Objects)
├── security # JWT & Security Config
├── exception # Custom Exceptions

---

## 🔐 Authentication Flow
1. User logs in with email & password  
2. Server authenticates and generates JWT token  
3. Client stores token and sends it in Authorization header  
4. Server validates token before allowing access to secured APIs  

---

## ▶️ How to Run the Project
1. Clone the repository
   https://github.com/Shiva63034/Task-Management-System-Spring-Boot-JWT-.git
2. Open project in STS / Eclipse  
3. Configure MySQL in `application.properties`  
4. Run the Spring Boot application  
5. Use Postman to test APIs  

---

## 📌 Sample API Endpoints
- `POST /api/auth/register` → Register user  
- `POST /api/auth/login` → Login & get JWT  
- `GET /api/{userId}/tasks` → Get all tasks  
- `POST /api/{userId}/tasks` → Create task  
- `DELETE /api/{userId}/tasks/{taskId}` → Delete task  

---

## 📈 Future Enhancements
- Add Swagger API documentation  
- Implement pagination & sorting  
- Add frontend (React / Angular)  
- Dockerize the application  
- Deploy to cloud (AWS / Render)  

---
---

## 📸 API Outputs & Screenshots

### 🔐 User Login (Without Password Encryption)
This screenshot shows the basic login process before applying password encryption.

![User Login Without Encryption](login-without-encryption.png)

---

### 🔐 User Login (With Password Encryption)
This demonstrates secure login using encrypted passwords stored in the database.

![User Login With Encryption](images/login-with-encryption.png))

---

### 🎟️ JWT Token Generation
After successful login, the server generates a JWT token used for authentication.

![JWT Token](jwt-token.png)

---

### 🛡️ Accessing Secure APIs Using JWT
This shows how JWT token is used in the Authorization header to access protected endpoints.

![JWT Authorization](jwt-auth.png)

---

### 📋 Get Tasks API
Displays all tasks associated with a specific user.

![Get Tasks](get-tasks.png)

---

### 🗄️ Database - Users Table
Snapshot of the users table storing user details securely.

![Users Table](users-table.png)

---

### 🗄️ Database - Tasks Table
Snapshot of the tasks table storing task-related data.

![Tasks Table](tasks-table.png)

---

### 📊 Project Summary
Overview of the complete system including authentication and task management flow.

![Project Summary](summary.png)
## 👨‍💻 Author
**Eluri Siva**  
🔗 GitHub: https://github.com/Shiva63034
