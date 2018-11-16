<B>SwaggerTest example to show the useal unable to infer base url bug, which is reported by several developers. Now its working in tomcat.</B>

<B>dispatcher-servlet is configured for tomcat and end-points are working</B>

http://localhost:8080/swaggerTest/swagger-ui.html
http://localhost:8080/swaggerTest/v2/api-docs

Deployed to Tomcat8/9.

To run the sample

```bash
mvn clean install spring-boot:run
```

Using SpringFox Swagger.

Logging is set to Trace, to show:

- Found resource handler mapping: URL pattern="/swagger-ui.html"
- Mapped URL path [/v2/api-docs] onto method

Tiny springboot 2.0 spring-mvc example with single JSP.

<B>http://localhost:8080/webAPI __SHOULD__ give:</B>

OK

NOTE: This requires setting the webContent in a location that springboot knows to serve jsps

<B>http://localhost:8080/swagger-ui.html gives:</B>

The API documentation in swagger

<B>http://localhost:8080/v2/api-docs gives:</B>

The service description
