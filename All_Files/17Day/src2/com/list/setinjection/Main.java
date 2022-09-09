package com.list.setinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		Question ques=context.getBean("myQuestion",Question.class);
		ques.display();
		((AbstractApplicationContext) context).close();
		

	}

}
