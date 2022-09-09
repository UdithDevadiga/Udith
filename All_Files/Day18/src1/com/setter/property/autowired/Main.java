package com.setter.property.autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TextEditor te=context.getBean("TextEditor",TextEditor.class);
		te.checkSpell();
		((AbstractApplicationContext) context).close();
	}

}
