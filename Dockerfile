FROM adoptopenjdk/openjdk11
WORKDIR /app
COPY ./target/vetApp-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 80
CMD ["java","-jar","app.jar"]