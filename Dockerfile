# 1. build
FROM maven:3.9.4-amazoncorretto-21 AS builder
WORKDIR /app

COPY . /app

RUN mvn -Dskiptests clean package

# 2. run
FROM amazoncorretto:21-alpine AS runner
WORKDIR /app

COPY --from=builder /app/target/*.jar /app/security.jar

EXPOSE 8084
CMD ["java", "-jar", "/app/security.jar"]