FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ADD target/country-details-workshop-0.0.1.jar country-details-workshop-0.0.1.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","country-details-workshop-0.0.1.jar"]
