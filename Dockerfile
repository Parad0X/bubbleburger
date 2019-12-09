#
# Build the app
#
FROM gradle:4.7.0-jdk8-alpine AS build

COPY --chown=gradle:gradle . /opt/src

WORKDIR /opt/src

RUN gradle build --no-daemon

#
# Start app
#
FROM openjdk:8-jre-slim

WORKDIR /app

COPY --from=build /opt/src/build/libs/*.jar ./
COPY db/* ./

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/src-1.0.jar"]
