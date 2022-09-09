package com.config.javabased;

public class TextEditor {
	
	private SpellChecker spellChecker;
	
	TextEditor(SpellChecker spellChecker){
		System.out.println("Inside Text Editor Constructor");
		this.spellChecker=spellChecker;
	}
	
	void spell() {
		spellChecker.checkSpelling();
	}
	
}
