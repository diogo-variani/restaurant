FROM maven:3.8.1-openjdk-8-slim

ARG APP_BASE_DIR=/usr/src/restaurante-app

COPY . ${APP_BASE_DIR}
WORKDIR ${APP_BASE_DIR}

EXPOSE 8080 8080

CMD ["mvn", "spring-boot:run"]
