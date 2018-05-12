package swaggerTest;

import javax.servlet.ServletContext;

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

@Configuration
@EnableSwagger2
@EnableSpringDataWebSupport
public class SwaggerConfigTest extends WebMvcConfigurerAdapter
{
	@Autowired
	private ServletContext servletContext_;
	
    @Bean
    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2)
        		/*
        		.pathProvider(new RelativePathProvider(servletContext_) 
        		{
        			@Override
        			public String getApplicationBasePath()
        			{
        				utils.log("api", "Using basepath [" + servletContext_.getContextPath() + "]", true);
        				return servletContext_.getContextPath();
        			}
        		})
        		*/
        		.select()
        			.apis(RequestHandlerSelectors.any()) // basePackage("webPages")
        			.paths(PathSelectors.any())
        			.build()
        		// .pathMapping("/") //  + servletContext_.getContextPath())
        		.apiInfo(apiInfo());
    }
    
    private ApiInfo apiInfo()
    {
    	return new ApiInfoBuilder()
    			.title("test")
    			.description("here goes")
    			.version("1.0")
    			.build();
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) 
    {
        String basePath = servletContext_.getContextPath();

		registry
    		.addResourceHandler("/swagger-ui.html")
        	.addResourceLocations("classpath:/META-INF/resources/");
		
       	registry
       		.addResourceHandler("/webjars/**")
       		.addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}