FROM maven:3.8.4-openjdk-17 as builder
MAINTAINER Florian Grabowski <https://github.com/FlorianGrabowski>

WORKDIR /app
COPY  ./ .

RUN mvn clean install -DskipTests

FROM openjdk:17-alpine as runner
MAINTAINER Florian Grabowski <https://github.com/FlorianGrabowski>

WORKDIR /home/app
COPY --from=builder /app/target/finance-planner-api-0.1.jar /home/app
RUN chgrp -R root /home/app && chmod -R 770 /home/app

EXPOSE 8080
ENTRYPOINT ["java","-jar", "./finance-planner-api-0.1.jar"]
