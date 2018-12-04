package com.tutorial.web.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { 
				ServletContextConfig.class, 
				ServiceContextConfig.class, 
				SecurityContextConfig.class 
		};
	}

	@Override
	protected String[] getServletMappings() {
/*1.	<servlet-mapping>
			<servlet-name>dispatcher</servlet-name>
			<url-pattern>/</url-pattern>
		</servlet-mapping>*/
		return new String[] {"/"};
	}
	
	//filter 설정
	@Override
	protected Filter[] getServletFilters() {
		
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		
		return new Filter[] {
				characterEncodingFilter
		};
	}
	
}