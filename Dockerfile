FROM eclipse-temurin:21
WORKDIR /app
COPY target/*.jar /app/myapp.jar
EXPOSE 8080
VOLUME /app/data
ENTRYPOINT ["java","-jar","/app/myapp.jar"]
