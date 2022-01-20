# Secure API Demo

A proof of concept showing a secure API system using KeyCloak authentication, KrakenD API gateway and Java microservices.

# Setup

## Microservices

- Create a war file in the respective microservice folder.  
```mvn package```
- Build image.  
```docker build -t sites-api .```  
```docker build -t bus-api .```
- Run.  
```docker run -d -p 9080:9080 -p 9443:9443 --name sites sites-api```  
```docker run -d -p 9081:9081 -p 9444:9444 --name bus bus-api```

## Authentication
- Pull image.  
```docker pull quay.io/keycloak/keycloak```
- Got to the _keycloak_ folder. Run Keycloak.  
```docker run -d -p 8082:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin -e KEYCLOAK_IMPORT=/tmp/myrealm.json -v "${PWD}:/tmp" --name keycloak quay.io/keycloak/keycloak```

## API Gateway
- Edit _krakend.json_ and replace URLs of API host and Keycloak host.
- Pull image.  
```docker pull devopsfaith/krakend```
- Run Krakend where _krakend.json_ is located.  
```docker run -p 8081:8080 -v "${PWD}:/etc/krakend/" --name krakend devopsfaith/krakend run -d -c /etc/krakend/krakend.json```

## Client
- Install dependencies.  
```npm install```
- Run app.  
```npm run start```

# Test
Go to http://localhost:3000  
Login with the following credentials:

> username: myuser  
> password: password


