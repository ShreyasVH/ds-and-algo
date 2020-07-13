FROM openjdk:8

RUN apt-get update && apt-get -y install vim

WORKDIR /app