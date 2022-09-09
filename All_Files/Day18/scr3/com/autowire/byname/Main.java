package com.autowire.byname;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
      TextEditor te = (TextEditor) context.getBean("textEditor");
      te.spellCheck();
      ((AbstractApplicationContext) context).close();
   }
}