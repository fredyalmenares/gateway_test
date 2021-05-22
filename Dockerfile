FROM maven:3.6.3-jdk-11 as maven_build
WORKDIR /app
COPY pom.xml .
RUN mvn clean package -Dmaven.main.skip -Dmaven.test.skip && rm -r target
COPY src ./src
RUN mvn clean package -Dmaven.test.skip

FROM openjdk:11-jre-slim as app_server
COPY --from=maven_build /app/target/*.jar /app/target/app.jar
ADD entrypoint.sh /entrypoint.sh
ENTRYPOINT ["/bin/bash"]
CMD ["/entrypoint.sh"]