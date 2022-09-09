package com.apply.learnedconcept;

import org.springframework.beans.factory.annotation.Autowired;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;

	@Autowired
	TrackCoach(FortuneService fortuneService) {
		System.out.println("Inside TrackCoach Constructor");
		this.fortuneService=fortuneService;
	}
	
//	void setFortuneService(FortuneService fortuneService) {
//		this.fortuneService=fortuneService;
//	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just Do It: " + fortuneService.getFortune();
	}

}