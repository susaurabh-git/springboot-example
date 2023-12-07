# rest-redis
This is Springboot reference project for REST application which will use redis cache to Retrieve, Create, Update and Delete User object.

## Pre-requisites
- java 21+
- maven 3.9.6+

## Run Redis in local 
- Download and install "Docker Desktop" from docker https://www.docker.com (If not already installed)
- Run redis with following command
```shell
cd rest-redis/docker
docker-compose up -d
```

## Build 
```shell
mvn clean install
```

## Test the Application

### Create User
```shell
curl -L -X POST 'https://xxxxxx.execute.api.{region}.amazonaws.com/dev/users' -H 'Content-Type: application/json' \
--data-raw '{
    "firstName":"John",
    "lastName":"Doe"
    }'
```

### Retrieve User
Get ID from above output
```shell
curl -L -X GET 'https://xxxxxx.execute.api.{region}.amazonaws.com/dev/users/{id-from-above-output}'
```

### Delete User
```shell
curl -L -X DELETE 'https://xxxxxx.execute.api.{region}.amazonaws.com/dev/users/{id-from-above-output}'
```