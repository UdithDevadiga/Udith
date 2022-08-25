package practice3;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class Ques4Test {

	@Test
	void test() {
		assertEquals("Strings are same",Ques4.compare("Suraj", "Suraj", 5, 5));
		System.out.println("inside test");
	}

}

