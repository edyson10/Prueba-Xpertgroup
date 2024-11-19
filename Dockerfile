# Imagen base con OpenJDK 17
FROM openjdk:17-jdk-slim AS builder

# Configurar el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar todos los archivos del proyecto al contenedor
COPY . .

# Compilar el proyecto usando Gradle Wrapper
RUN ./gradlew build -x test

# Imagen base para la aplicación
FROM openjdk:17-jdk-slim

# Configurar el directorio de trabajo
WORKDIR /app

# Copiar el JAR generado desde la etapa de compilación
COPY --from=builder /app/build/libs/*.jar app.jar

# Exponer el puerto
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
