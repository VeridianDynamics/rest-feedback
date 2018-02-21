# Feedback "microservice"

This is just a small demo project I've created as part of an interview task.

## Getting Started

Simply clone the project to your system and execute the following Maven goal:
```
mvn spring-boot:run
```
### Prerequisites

Naturally, you will need Maven and an internet connection to download the dependencies.

### Installing

If you speify the following maven goals, the project will be built as a standalone JAR file:
```
mvn clean package
```

You can then run it as follows:
```
java -jar rest-feedback-0.0.1-SNAPSHOT.jar
```

## Tests

There are just a couple of tests which show the basics - one set of unit tests and one set of integration tests (sort of).
Additional tests would be very similar to the ones already there.
There is **always** room fo improvement when it comes to tests.

### Debugging

I have included a user interface to make it dead simple to tinker with the endpoints.
It can be found on [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
Due to bloating of the application, this should be disabled in production environment.
I am keeping it for now because it is very useful for staging and/or demo purposes.

### Talking to the Feedback "microservice"

I have leveraged the power of SpringFox to dynamically create an API definition based on the Spring Boot project.

This API conforms to the OpenAPI 2.0 specification and can be found at [http://localhost:8080/v2/api-docs](http://localhost:8080/v2/api-docs)

All you need to do is plug it into the OpenAPI processor of your choice and you can generate the appropriate objects in your preferred language.
I have found Swagger to be a very good choice in this regard.

## Built With

* [SpringFox](http://springfox.github.io/springfox/) - Automated JSON API documentation for API's built with Spring.
* [Maven](https://maven.apache.org/) - Dependency Management
* [Swagger](https://swagger.io/swagger-ui/) - Visualize and interact with the API’s resources without having any of the implementation logic in place.

## Authors

* **Jan Hron** - Developer-generalist and a geek from Brno

## License

This project is licensed under the CC-0 license - do whatever you want with it.

## Acknowledgments

* The many people on Stack Exchange who have created the best resource for curious people online

