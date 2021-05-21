FROM maven:3.6.3-jdk-11 AS builder
WORKDIR /workdir/server
COPY pom.xml /workdir/server/pom.xml
RUN mvn dependency:go-offline

COPY src /workdir/server/src
RUN mvn clean install
RUN mkdir  -p target/depency
WORKDIR /workdir/server/target/dependency
RUN jar -xf ../*.jar

FROM openjdk:11.0.4-jre-slim

EXPOSE 8080
VOLUME /tmp
ARG DEPENDENCY=/workdir/server/target/dependency
COPY --from=builder ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=builder ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=builder ${DEPENDENCY}/BOOT-INF/classes /app
ADD entrypoint.sh /entrypoint.sh
RUN apt-get update && apt-get install -y curl && mkdir /logs && touch /logs/cobranza.log
ENTRYPOINT ["/bin/bash"]
CMD ["/entrypoint.sh"]