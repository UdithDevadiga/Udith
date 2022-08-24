package assignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

class Test {
	@BeforeAll
	public static void setUpBeforeClass() throws Exception{
		System.out.println("Before Class");
	}
	@BeforeEach
	public void setUp() throws Exception{
		System.out.println("Before");
	}
	@org.junit.jupiter.api.Test
	void test() {
		Member m=new Member("Manoj",19,"1234","Bangalore",30000d);
		assertEquals(3000,m.printSalary());
	}
	@AfterEach
	
	public void after() throws Exception{
		System.out.println("After");
	}
	@AfterAll
	public static void afterClass() throws Exception{
		System.out.println("After Class");
	}

}
