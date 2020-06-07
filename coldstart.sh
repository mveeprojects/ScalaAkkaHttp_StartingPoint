#!/usr/bin/env bash

# Run this file if you need a fresh docker image of both the api and performance modules (this takes a bit of time!).
# If you already have the images created, just run the docker-compose command shown below from the root of this project.

docker-compose -f ./docker/docker-compose.yml down

sbt clean assembly

docker build ./api -t api

docker build ./performance -t performance-tests-api

docker-compose -f ./docker/docker-compose.yml up -d
