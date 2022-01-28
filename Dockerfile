FROM openjdk:16-alpine
ADD /target/Lab2SushiShop-0.0.1-SNAPSHOT.war sushi.war
COPY src/main/resources src/main/resources
EXPOSE 9999
ENTRYPOINT ["java", "-jar", "sushi.war"]