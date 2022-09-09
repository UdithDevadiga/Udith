package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderDetailTest {
	@BeforeAll
	public static void upBeat() {
		System.out.println("Before All");
	}
	@BeforeEach
	public void upBeatAll() {
		System.out.println("Before");
	}
	@Test
	void testTax() {
		OrderDetail od=new OrderDetail();
		assertEquals(50,od.calcTax());
	}
	void testWeight() {
		OrderDetail od=new OrderDetail();
		assertEquals(50f,od.calcWeight(50f));
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
