package edu.towson.cis.cosc442.project2.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineItemTest {
	
	
	/*
	 *  Test class for the vending machine Item.
	 */
	
	VendingMachineItem vmi;
	
	
	@Before
	public void setUp() throws Exception {
		vmi = new VendingMachineItem("Doritos", 2.50);
	}

	@After
	public void tearDown() throws Exception {
		vmi = null;
	}
	
	
	/*
	 * Testing the getName() method.
	 */
	@Test
	public void testGetName() {
		assertEquals("Doritos",vmi.getName());
	}
	
	
	/*
	 * Testing the getPrice() method.
	 */
	@Test
	public void testGetPrice() {
		assertEquals(2.50,vmi.getPrice(),0.001);
	}

}
