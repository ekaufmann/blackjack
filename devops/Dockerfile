FROM gradle:8.1.1-jdk17-alpine AS GRADLE_BUILD
WORKDIR /home/blackjack/
COPY --chown=gradle:gradle . .
#COPY --chown=gradle:gradle ../src /home/blackjack/gradle/src
RUN gradle build --no-daemon

ARG VERSION
ENV VERSION=$VERSION

FROM amazoncorretto:17-alpine3.17

RUN mkdir /app

COPY --from=GRADLE_BUILD /home/blackjack/build/libs/*.jar /app/blackjack.jar

ENTRYPOINT ["java","-jar","/app/blackjack.jar"]