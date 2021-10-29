FROM openjdk:8

ADD foodbox-project.jar foodbox-project.jar

EXPOSE 8581

ENTRYPOINT ["java","-jar","foodbox-project.jar"]