package com.config.javabased;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
/**
 * @author Udith Devadiga
 *
 */
public class Main {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(TextEditorConfig.class);
		TextEditor textEditor=context.getBean(TextEditor.class);
		textEditor.spell();
		((AbstractApplicationContext) context).close();

	}

}
