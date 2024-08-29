package J_SpringMvcCurdApp.J_SpringMvcCurdApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="J_SpringMvcCurdApp.J_SpringMvcCurdApp")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

@Bean(name="dataSource")
public DriverManagerDataSource getDataSource() {
	
	DriverManagerDataSource d=new DriverManagerDataSource();
	d.setDriverClassName("com.mysql.cj.jdbc.Driver");
	d.setUrl("jdbc:mysql://localhost:3306/mysql");
	d.setUsername("root");
	d.setPassword("Shantanu");
	return d;
	
}

@Bean(name="template")

public JdbcTemplate getTemplate() {
	JdbcTemplate j=new JdbcTemplate(getDataSource());
	return j;
}

	
}
