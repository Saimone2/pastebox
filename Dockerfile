FROM openjdk:19-alpine
MAINTAINER Khrushch Andriy
COPY target/*.jar pastebox.jar
ENTRYPOINT ["java","-jar","/pastebox.jar"]