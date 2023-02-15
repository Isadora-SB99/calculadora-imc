FROM openjdk:11
COPY ./target/calculadora-imc.jar /app/calculadora-imc.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "calculadora-imc.jar"]
EXPOSE 8080