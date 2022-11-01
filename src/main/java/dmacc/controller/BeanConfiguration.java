package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Class;

/**
 * @author alexh - aheinrichs
 * CIS175 - Fall 2022
 * Oct 29, 2022
 */
@Configuration
public class BeanConfiguration {
	
	@Bean
	public Class recipe() {
		Class bean = new Class();
		return bean;
	}
	
}
