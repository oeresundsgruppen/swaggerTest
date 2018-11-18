package swaggerTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.stereotype.Component;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import javax.servlet.ServletContext;

@Component
@Order(1)
@EnableSwagger2
@PropertySource({"classpath:swagger.properties"})
@ConditionalOnResource(resources = {"classpath:swagger.properties"})
@Configuration
public class SwaggerConfigTest // extends WebMvcConfigurerAdapter
{
	@Autowired(required=false)
	private ServletContext servletContext_;
	
	@Value("${springfox.documentation.swagger.v2.path}")
	private String swagger2Endpoint;

    @Bean
    public Docket api()
    {
	System.out.println("docket created for end-point [" + swagger2Endpoint + "]");
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(apiInfo())
           		.pathMapping(swagger2Endpoint)
				.select()
       			.apis(RequestHandlerSelectors.any())
       			.paths(PathSelectors.any())
       			.build();
    }
    
    private ApiInfo apiInfo()
    {
    	return new ApiInfoBuilder()
    			.title("swaggertest")
    			.description("here goes desc")
    			.version("1.0")
    			.build();
    }
	
    @Bean
    public DispatcherServlet dispatcherServlet()
    {
	System.out.println("dispatcherServlet started");
    	return new DispatcherServlet();
    }	
    
    //@Override
    //public void addResourceHandlers(ResourceHandlerRegistry registry) 
    //{
    //    String basePath = servletContext_.getContextPath();
    //	  registry
    //		.addResourceHandler("/swagger-ui.html")
    //   	.addResourceLocations("classpath:/META-INF/resources/");
    //    registry
    //   	.addResourceHandler("/webjars/**")
    //   	.addResourceLocations("classpath:/META-INF/resources/webjars/");
    //}
}