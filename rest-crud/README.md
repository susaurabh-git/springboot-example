# springboot-crud

This is sample Springboot CRUD implementation 

## Pre-requisites
- java 11+
- maven 3.6+

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