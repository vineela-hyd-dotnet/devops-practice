# 1️⃣ Base image (Java runtime)
FROM openjdk:17-jdk-slim

# 2️⃣ Set working directory inside container
WORKDIR /app

# 3️⃣ Copy built JAR from target folder
COPY target/*.jar app.jar

# 4️⃣ Expose application port
EXPOSE 8080

# 5️⃣ Command to run the app
ENTRYPOINT ["java","-jar","app.jar"]
