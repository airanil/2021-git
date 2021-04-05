
FROM openjdk:11
ARG JAR_FILE=target/*.war
COPY ${JAR_FILE} app.war
ENTRYPOINT ["java","-jar","/app.war"]

# --- above code will buld and package create image , but it will take time to build-----
# ---- it is recomended to build locallay and then create image---------

# Build stage


# FROM maven:3.6.0-jdk-11-slim AS build
# COPY src /home/app/src
# COPY pom.xml /home/app
# RUN mvn -f /home/app/pom.xml clean package -DskipTests


# Package stage

# FROM openjdk:11
# ARG JAR_FILE=/home/app/target/*.war
# COPY --from=build ${JAR_FILE} app.war
# ENTRYPOINT ["java","-jar","/app.war"]
  



