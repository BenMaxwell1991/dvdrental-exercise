FROM openjdk:21

WORKDIR /app
COPY exercise-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080

ENV SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/dvdrental
ENV SPRING_DATASOURCE_USERNAME=postgres
ENV SPRING_DATASOURCE_PASSWORD=postgres

ENTRYPOINT ["java", "-jar", "app.jar"]
