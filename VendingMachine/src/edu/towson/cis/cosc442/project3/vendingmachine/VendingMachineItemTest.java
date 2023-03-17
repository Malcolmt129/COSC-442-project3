package edu.towson.cis.cosc442.project3.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineItemTest {
	
	
	/*
	 *  Test class for the vending machine Item.
	 */
	
	VendingMachineItem vmi;
	VendingMachineItem vmi2;
	
	
	@Before
	public void setUp() throws Exception {
		vmi = new VendingMachineItem("Doritos", 2.50);
	}

	@After
	public void tearDown() throws Exception {
		vmi = null;
		vmi2 = null;
	}
	
	/*
	 * Testing the constructor. Should be equal to the 
	 * parameters in set up.
	 */
	@Test
	public void testVendingMachineItem() {
		assertEquals("Doritos",vmi.getName());
		assertEquals(2.50,vmi.getPrice(), 0.001);
	}
	
	/*
	 * Testing the VendingMachine exception
	 */
	@Test(expected= VendingMachineException.class)
	public void testVendingMachineItemEx() {
		vmi2 = new VendingMachineItem("Water", -2.00);
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
