FROM openjdk:17

COPY target/pixels-chatservice-1.jar pixels-chatservice

EXPOSE 8103

ENTRYPOINT ["java","-jar","pixels-chatservice.jar"]
