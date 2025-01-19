# Base da imagem
FROM eclipse-temurin:21-jdk-alpine AS builder

#Definindo diretorio
WORKDIR /app
COPY . .

RUN ./gradlew bootJar --no-daemon

# Etapa final
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
