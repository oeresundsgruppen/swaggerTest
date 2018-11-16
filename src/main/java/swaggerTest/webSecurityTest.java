package swaggerTest;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@EnableWebMvc
@Configuration
//@EnableWebSecurity
@Import(SwaggerConfigTest.class)
public class webSecurityTest // extends WebSecurityConfigurerAdapter
{
	private static final String[] AUTH_WHITELIST = {
			"/swagger-resources/**",
			"/swagger-resources/configuration/ui",
			"/swagger-resources/configuration/security",
			"/swagger-resource/**",
			"/swagger-ui.html",
			"/v2/api-docs",
			"/webjars/**"
	};

	/*
	@Override
	public void configure(WebSecurity web) throws Exception
	{
		utils.log("webSecurity", "Setting security", false);
		web.ignoring().antMatchers("/v2/api-docs/**", "/configuration/ui/**","/swagger-resources/**", "/configuration/security/**","/swagger-ui.html", "/webjars/**");
	}
	*/
	
	//protected void configure(HttpSecurity http) throws Exception 
	//{
    //	http.authorizeRequests()
	//	.antMatchers(AUTH_WHITELIST).permitAll();
	//	//.antMatchers("/**/*").denyAll();
	//}
}