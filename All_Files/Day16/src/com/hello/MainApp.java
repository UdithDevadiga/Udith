package com.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
      HelloWorld obj =context.getBean("helloWorld",HelloWorld.class);
      obj.getMessage();
      ((AbstractApplicationContext) context).close();
   }
}
