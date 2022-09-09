package com.dependencyIngestion.primitive;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {

	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		Employee e=context.getBean("myEmployee",Employee.class);
		e.show();
		((AbstractApplicationContext) context).close();

	}

}
