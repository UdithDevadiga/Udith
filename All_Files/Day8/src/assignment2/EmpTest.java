package assignment2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpTest {
	@BeforeAll
	public static void upBeat() {
		System.out.println("Before All");
	}
	@BeforeEach
	public void upBeatAll() {
		System.out.println("Before");
	}
	@Test
	void test() {
		Emp obj=new Emp("jeevan",100,19,36000d,"Male","CS",1995);
		assertEquals(100,obj.getId());
		
	}
	@AfterEach
	public void downBeat() {
		System.out.println("After");
	}
	@AfterAll
	public static void downBeatAll() {
		System.out.println("After");
	}

}
