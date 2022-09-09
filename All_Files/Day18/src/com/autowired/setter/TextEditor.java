package com.autowired.setter;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {
	private SpellChecker spellChecker;
	
	TextEditor(){
		System.out.println("Inside text editor constructor");
	}
	@Autowired
	void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker=spellChecker;
	}
	
	SpellChecker getSpellChecker() {
		return spellChecker;
	}
	void checkSpell() {
		spellChecker.checkSpelling();
	}
}

