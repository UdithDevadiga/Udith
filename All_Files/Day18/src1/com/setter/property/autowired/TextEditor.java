package com.setter.property.autowired;

import org.springframework.beans.factory.annotation.Autowired;

import com.autowired.setter.SpellChecker;

public class TextEditor {
	
	@Autowired
	private SpelChecker spellChecker;
	
	TextEditor(){
		System.out.println("Inside text editor constructor");
	}
	
	SpelChecker getSpellChecker() {
		return spellChecker;
	}
	void checkSpell() {
		spellChecker.checkSpelling();
	}
}

