Online Job Portal System
📌 Project Overview
The Online Job Portal System is a web-based platform that connects job seekers with employers. It allows:

Job Seekers to browse and apply for jobs, upload resumes, and manage profiles.

Companies to post job vacancies, review applications, and manage hiring processes.

Admins to manage users, FAQs, and system configurations.

🔗 Fill GitHub code: https://github.com/Tharidi2002/Job-Grids-Project-master-new-update.git
🔗 YouTube Demo: Watch Video (https://youtu.be/IgtbjvjvGEw?si=z5K-9UuUtyJc6RAJ)


🛠 Technologies & Dependencies
Backend (Java - Spring Boot)
Framework: Spring Boot 3.4.4

Database: MySQL

Security: Spring Security + JWT

API Documentation: Swagger/OpenAPI

Dependencies:

xml
Copy
<dependencies>
    <!-- Spring Boot Starters -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-mail</artifactId>
    </dependency>
    
    <!-- Database -->
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>
    
    <!-- JWT -->
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-api</artifactId>
        <version>0.11.5</version>
    </dependency>
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-impl</artifactId>
        <version>0.11.5</version>
    </dependency>
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-jackson</artifactId>
        <version>0.11.5</version>
    </dependency>
    
    <!-- Utilities -->
    <dependency>
        <groupId>org.modelmapper</groupId>
        <artifactId>modelmapper</artifactId>
        <version>3.1.1</version>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    
    <!-- Swagger -->
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.3.0</version>
    </dependency>
</dependencies>
Run HTML
Frontend (HTML, CSS, JavaScript, Bootstrap 5)
UI Framework: Bootstrap 5

AJAX: jQuery

Icons: Font Awesome

2. Frontend Setup
Open index.html in a browser.

For development, use Live Server (VS Code extension).

🚀 Features
For Job Seekers
✅ Browse and apply for jobs
✅ Upload resumes & manage profiles
✅ Receive job alerts via email

For Companies
✅ Post job vacancies
✅ Manage applications
✅ Filter candidates

For Admins
✅ Manage users (Job Seekers & Companies)
✅ Approve/reject job postings
✅ Manage FAQs & system settings

📂 Project Structure
Copy
job-portal/
├── backend/  
│   ├── src/main/java/
│   │   ├── config/          # Security & Web Configs  
│   │   ├── controller/      # REST APIs  
│   │   ├── dto/             # Data Transfer Objects  
│   │   ├── entity/          # JPA Entities  
│   │   ├── repository/      # JPA Repositories  
│   │   ├── service/         # Business Logic  
│   │   └── util/            # JWT, Response Utils  
│   └── src/main/resources/  
│       ├── application.properties  
│       └── static/          # Frontend files  
│
├── frontend/  
│   ├── css/                 # Custom styles  
│   ├── js/                  # AJAX & scripts  
│   └── index.html           # Main page  
│
└── README.md  
📜 License
This project is licensed under MIT License.

📧 Contact
For support, email: tharidithisarani2002@gmail.com

🎥 Watch Demo on YouTube
🔗 YouTube Demo Link (https://youtu.be/snq_LXXGrws?si=fmGHTEQyAbns13bw)

🙏 Thank You!
Feel free to contribute or report issues! 🚀

