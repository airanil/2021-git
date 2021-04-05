FROM openjdk:11
ARG war_FILE=target/*.war
COPY ${war_FILE} app.war
ENTRYPOINT ["java","-jar","/app.war"]