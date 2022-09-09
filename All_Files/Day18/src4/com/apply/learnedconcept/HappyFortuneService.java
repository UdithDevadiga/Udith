package com.apply.learnedconcept;

public class HappyFortuneService implements FortuneService {
	
	HappyFortuneService(){
		System.out.println("Inside Happy Fortune Service Constructor");
	}

	@Override
	public String getFortune() {
		return "Today is your lucky day!";
	}

}