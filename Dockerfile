# syntax=docker/dockerfile:1

FROM eclipse-temurin:19-jdk-jammy

ADD target/artifacts/Scamazone_jar/Scamazone.jar Scamazone.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "Scamazone.jar"]