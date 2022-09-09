package com.config.javabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TextEditorConfig {
	@Bean
	public TextEditor textEditor() {
		return new TextEditor(spellCheckerl());
	}
	@Bean
	public SpellChecker spellCheckerl() {
		return new SpellChecker();
	}
}
