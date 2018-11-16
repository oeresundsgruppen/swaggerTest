package swaggerTest;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletContext;

@SpringBootApplication
@EnableAutoConfiguration
@EnableCaching
@ComponentScan (basePackages= {"swaggerTest"})
@Component
public class Application extends SpringBootServletInitializer
{
	private static ServletContext context_;

	// Used if launched outside container
	public static void main(String[] args) throws Exception
	{
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) // Runs before SpringBoot
	{
		final SpringApplicationBuilder sab = application.sources(Application.class).bannerMode(Banner.Mode.OFF);
		return sab;
	}
	
	@Override
	public void onStartup(ServletContext servletcontext)
	{
		// Set log-levels
		final Logger context = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
		context.setLevel(Level.INFO);

		// Create the 'root' Spring application context
		final AnnotationConfigWebApplicationContext springRootContext = new AnnotationConfigWebApplicationContext();
		springRootContext.setServletContext(servletcontext);
		springRootContext.setDisplayName("swaggerTest");
		springRootContext.close();
	}

}
