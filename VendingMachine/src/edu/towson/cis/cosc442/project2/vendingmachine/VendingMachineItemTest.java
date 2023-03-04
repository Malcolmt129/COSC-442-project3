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

	@Test
	public void getName() {
		assertEquals("Doritos",vmi.getName());
	}
	
	
	
	@Test
	public void getPrice() {
		assertEquals(2.50,vmi.getPrice(),0.001);
	}

}
