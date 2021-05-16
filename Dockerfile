FROM adoptopenjdk/openjdk11:jdk-11.0.11_9-alpine-slim

COPY ./target/ASDESS-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch ASDESS-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-XshowSettings:vm", "-XX:NativeMemoryTracking=summary", "-jar", "ASDESS-0.0.1-SNAPSHOT.jar"]