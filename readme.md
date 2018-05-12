<B>SwaggerTest example to show the useal unable to infer base url bug, which is reported by several developers.</B>

Using SpringFox Swagger.

Tiny springboot 2.0 spring-mvc example with single JSP.

<B>http://localhost:8080/swaggerTest/webAPI gives:</B>

OK

<B>http://localhost:8080/swaggerTest/swagger-ui.html gives:</B>

Unable to infer base url. This is common when using dynamic servlet registration or when the API is behind an API Gateway. The base url is the root of where all the swagger resources are served. For e.g. if the api is available at http://example.org/api/v2/api-docs then the base url is http://example.org/api/. Please enter the location manually: 

<B>http://localhost:8080/swaggerTest/api/v2/api-docs gives:</B>

HTTP Status 404 – Not Found
Type Status Report
Message /swaggerTest/api/v2/api-docs
Description The origin server did not find a current representation for the target resource or is not willing to disclose that one exists.

Apache Tomcat/8.5.23
