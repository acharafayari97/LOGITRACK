# ===== STAGE 1: build con Maven =====
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copio solo il pom.xml prima (per sfruttare la cache di Docker)
COPY pom.xml ./

# Copio il sorgente
COPY src ./src

# Compilo e genero il JAR (senza test per velocizzare)
RUN mvn -B -DskipTests package


# ===== STAGE 2: runtime leggero =====
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copio il JAR dal build stage
COPY --from=build /app/target/*.jar app.jar

# Espongo la porta (adatta se la tua app gira su 8080)
EXPOSE 8080

# Comando di avvio
ENTRYPOINT ["java", "-jar", "app.jar"]
