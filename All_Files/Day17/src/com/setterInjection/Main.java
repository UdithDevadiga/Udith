package com.setterInjection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		Employee emp=context.getBean("myEmployee",Employee.class);
		emp.display();
		((AbstractApplicationContext) context).close();

	}

}
