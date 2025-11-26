# Etapa 1: Construcción del JAR
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copiamos el pom y descargamos dependencias (cache)
COPY pom.xml .
RUN mvn -q -e dependency:go-offline

# Copiamos el código y construimos
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final lightweight
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copiamos el jar desde la etapa 1
COPY --from=build /app/target/*.jar app.jar

# Railway asigna el puerto dinámicamente
ENV PORT=8080
EXPOSE 8080

# Comando para ejecutar el microservicio
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT}"]
