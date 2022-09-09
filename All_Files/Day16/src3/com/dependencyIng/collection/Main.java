package com.dependencyIng.collection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		Question que=context.getBean("myQuestions",Question.class);
		que.display();
		((AbstractApplicationContext) context).close();
	}

}
