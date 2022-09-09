package com.javaBased.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author Udith Devadiga
 *
 */
public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
		HelloWorld helloWorld=context.getBean(HelloWorld.class);
		helloWorld.setMessage("HeLLo WoRLD :) ");
		System.out.println(helloWorld.getMessage());
		((AbstractApplicationContext) context).close();
	}

}
