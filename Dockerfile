FROM openjdk:15.0.2-slim-buster
ADD target/CopyProject01-0.0.1-SNAPSHOT.jar CopyProject01-0.0.1-SNAPSHOT.jar
EXPOSE 8082
ENTRYPOINT [ "java","-jar","CopyProject01-0.0.1-SNAPSHOT.jar" ]
