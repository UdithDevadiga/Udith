package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTest {
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
		Order o=new Order();
		assertEquals(4950f,o.calcTotal(5000f, 50));
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
