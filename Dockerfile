# 1. build
FROM amazoncoretto:21-alpine AS builder
WORKDIR /app

COPY . /app

RUN mvn -Dskiptests clean package

# 2. run
FROM amazoncorretto:21-alpine AS runner
WORKDIR /app

COPY --from=builder /app/target/*.jar /app/security.jar

EXPOSE 8084
CMD ["java", "-jar", "/app/security.jar"]