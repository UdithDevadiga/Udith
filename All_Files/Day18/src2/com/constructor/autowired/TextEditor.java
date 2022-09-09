package com.constructor.autowired;

import org.springframework.beans.factory.annotation.Autowired;

import com.autowired.setter.SpellChecker;

public class TextEditor {
	
	private SpelChecker spellChecker;
	@Autowired
	TextEditor(SpelChecker spellChecker){
		System.out.println("Inside text editor constructor");
		this.spellChecker=spellChecker;
	}
	
	SpelChecker getSpellChecker() {
		return spellChecker;
	}
	void checkSpell() {
		spellChecker.checkSpelling();
	}
}

