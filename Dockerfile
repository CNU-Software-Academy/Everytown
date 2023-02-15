FROM openjdk:17

COPY ./build/libs/everytown-0.0.1-SNAPSHOT.jar everytown-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/everytown-0.0.1-SNAPSHOT.jar"]