#Go On
FROM maven as build

#making sure that container isn't running as root
RUN addgroup  cleanJava && adduser   -S -s  /bin/bash -g  cleanJava cleanJava
RUN chown cleanJava:cleanJava  /app/
USER cleanJava

WORKDIR /app
COPY . .
RUN mvn package

FROM openjdk
WORKDIR /app
COPY --from=build /app/target/phone.jar .
COPY --from=build /app/src/main/resources/sample.db .

EXPOSE 8080

ENTRYPOINT ["java", "-Dspring.data.rest.base-path=sample.db", "-jar","phone.jar"]