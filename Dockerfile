FROM adoptopenjdk/openjdk11:alpine-slim
MAINTAINER giorgirokhadze.me
VOLUME /app/petshop
EXPOSE 8080

ADD build/libs/petshop-0.0.1-SNAPSHOT.jar petshop-app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/petshop-app.jar"]