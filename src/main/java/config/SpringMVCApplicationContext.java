package config;

import java.util.List;
import ml.rugal.sshcommon.springmvc.method.annotation.FormModelMethodArgumentResolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.AbstractHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import rugal.sample.springmvc.controller.ExceptionController;

/**
 * Java based Web context configuration class.
 * <p>
 * Including argument resolution, message converter, view resolution etc.,
 *
 * @author Rugal Bernstein
 * @since 0.7
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = ExceptionController.class)
public class SpringMVCApplicationContext extends WebMvcConfigurerAdapter {

	private static final Logger _log = LoggerFactory.getLogger(SpringMVCApplicationContext.class);

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		ResourceHandlerRegistration resourceRegistration = registry.addResourceHandler("/resources/**");
		resourceRegistration.addResourceLocations("/resources/");
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new FormModelMethodArgumentResolver());
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		_log.debug("adding controllers");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/student").setViewName("student");
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Bean
	public HandlerAdapter annotationMethodHandlerAdapter() {
		return new RequestMappingHandlerAdapter();
	}

	@Bean
	public AbstractHandlerMapping defaultAnnotationHandlerMapping() {
		RequestMappingHandlerMapping mapping = new RequestMappingHandlerMapping();
		mapping.setUseSuffixPatternMatch(false);
		return mapping;
	}



}
