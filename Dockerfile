FROM openjdk:17-jdk-alpine3.14
COPY "./target/library-0.0.1-SNAPSHOT.jar " "/app/library-0.0.1-SNAPSHOT.jar"
EXPOSE 8080
CMD [ "java", "-jar", "/app/library-0.0.1-SNAPSHOT.jar " ]