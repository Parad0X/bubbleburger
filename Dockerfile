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

EXPOSE 8080

ENTRYPOINT [                                    \
  "java",                                       \
  "-XX:+UnlockExperimentalVMOptions",           \
  "-XX:+UseCGroupMemoryLimitForHeap",           \
  "-Djava.security.egd=file:/dev/./urandom",    \
  "-jar",                                       \
  "/app/src-0.0.1-SNAPSHOT.jar"                 \
]

