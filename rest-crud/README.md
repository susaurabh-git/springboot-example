# springboot-crud

This is Springboot reference project for CRUD implementation 

## Pre-requisites
- java 21+
- maven 3.9.6+

## Build
Run following command to build and package
```
mvn clean install
```
## Test the Application

### Create User
```shell
curl -L -X POST 'http://localhost:8080/users' -H 'Content-Type: application/json' \
--data-raw '{
    "firstName":"John",
    "lastName":"Doe"
    }'
```

### Retrieve User
Get ID from above output
```shell
curl -L -X GET 'http://localhost:8080/users/{id-from-above-output}'
```

### Delete User
```shell
curl -L -X DELETE 'http://localhost:8080/users/{id-from-above-output}'
```

### Get All Users
```shell
curl -L -X GET 'http://localhost:8080/users'
```