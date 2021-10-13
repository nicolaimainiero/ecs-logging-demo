FROM adoptopenjdk:11-hotspot-bionic AS build
COPY ./ /opt/ecs-logging-demo/
WORKDIR /opt/ecs-logging-demo/
RUN ./mvnw -f /opt/ecs-logging-demo/pom.xml clean package

FROM adoptopenjdk:11-jre-hotspot-bionic
COPY --from=build /opt/ecs-logging-demo//target/ecs-logging-demo-0.0.1-SNAPSHOT.jar /opt/ecs-logging-demo.jar
ENTRYPOINT ["java","-jar","/opt/ecs-logging-demo.jar"]