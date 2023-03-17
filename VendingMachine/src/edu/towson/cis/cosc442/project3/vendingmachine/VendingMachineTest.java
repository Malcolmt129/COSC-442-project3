 package edu.towson.cis.cosc442.project3.vendingmachine;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
	
	VendingMachine vm;
	
	
	@Before
	public void setUp() throws Exception {
		vm = new VendingMachine();
	}

	@After
	public void tearDown() throws Exception {
		vm = null;
	}
	
	
	/*
	 * 
	 * Testing Add Item method. With good entry
	 * 
	 */
	@Test
	public void testAddItem() {
		vm.addItem(new VendingMachineItem("Sour Patch Kids: Watermelon", 2.00), "A" );
		assertEquals("Sour Patch Kids: Watermelon", vm.getItem("A").getName() );
	}
	
	/*
	 * Testing to get 100% on the getSlotIndex method by inducing
	 * the error.
	 */
	@Test(expected= VendingMachineException.class)
	public void testAddItemF() {
		vm.addItem(new VendingMachineItem("Sour Patch Kids: Watermelon", 2.00), "F" );
	}
	
	
	/*
	 * Testing to see if the exception is passed when you put two items in
	 * the same slot.
	 */
	@Test(expected= VendingMachineException.class)
	public void testAddItemException() {
		vm.addItem(new VendingMachineItem("Sour Patch Kids: Watermelon", 2.00), "C" );
		vm.addItem(new VendingMachineItem("Chesters", 2.00), "C" );
		
	}	
	
	/*
	 * Testing getItem() method.
	 */
	@Test
	public void testGetItem() {
		vm.addItem(new VendingMachineItem("Chesters", 2.00), "B" );
		assertEquals("Chesters",vm.getItem("B").getName());
	}
	
	
	/*
	 * Testing getItem() to see if produces the exception if trying to 
	 * get an item from a slot that is empty. 
	 */
	@Test(expected= VendingMachineException.class)
	public void testGetItemException() {
		vm.getItem("D");
	}
	
	
	/*
	 * Test to remove item. This should produce
	 * an exception because we would pull from an empty slot.
	 * Also the assertEquals should expect a null.
	 */
	@Test(expected= VendingMachineException.class)
	public void testRemoveItem() {
		vm.addItem(new VendingMachineItem("Chesters", 2.00), "D" );
		vm.removeItem("D");
		assertEquals(null,vm.getItem("D"));
	}
	
	/*
	 * This is to test if the exception pops up for 
	 * trying to remove an Item that doesn't exist.
	 */
	
	@Test(expected= VendingMachineException.class)
	public void testRemoveItemThatDoesntExist() {
		vm.removeItem("B");
	}
	
	
	/*
	 * Test for insertMoney() method.
	 */
	@Test
	public void testInsertMoney() {
		vm.insertMoney(1000.00);
		assertEquals(1000.00,vm.getBalance(),0.001);
	}
	
	/*
	 * Test for insertMoney() method's exception,
	 * if the amount is less than 0.
	 */
	@Test(expected= VendingMachineException.class)
	public void testInsertMoneyException() {
		vm.insertMoney(-1000.00);
	}
	
	
	/*
	 * Test for getBalance() method
	 */
	@Test
	public void testGetBalance() {
		assertEquals(0.0,vm.getBalance(),0.001);
	}
	
	
	/*
	 * Testing makePurchase() method.
	 */
	@Test
	public void testMakePurchase() {
		vm.addItem(new VendingMachineItem("Chester's", 2.00), "A");
		vm.insertMoney(3.00);
		
		assertEquals(true,vm.makePurchase("A"));
	}
	
	
	/*
	 * Trying to get 100% for makePurchase() method. Testing
	 * if you dont have enough money.
	 */
	
	@Test
	public void testMakePurchse1() {
		vm.addItem(new VendingMachineItem("Chips",200.00), "A");
		vm.insertMoney(2.00);
		assertEquals(false, vm.makePurchase("A"));
	}
	
	/*
	 * Trying to get 100% for makePurchase() method. Testing
	 * if the item is null. This part of the code can't be reached
	 * so it is good to go...
	 */
	
	@Test(expected = VendingMachineException.class)
	public void testMakePurchse2() {
		vm.insertMoney(2.00);
		assertEquals(false, vm.makePurchase("A"));
	}
	
	/*
	 * Testing the makePurchase() method's item empty.
	 * Should return an exception. Also the boolean
	 * value should return false 
	 */
	@Test(expected= VendingMachineException.class)
	public void testMakePurchaseException() {
		assertEquals(false,vm.makePurchase("A"));
	}
	
	
	
	@Test
	public void testReturnChange() {
		vm.addItem(new VendingMachineItem("Chester's", 2.00), "D");
		vm.insertMoney(3.00);
		
		assertEquals(1.00, vm.returnChange("D"), 0.001);
		
	}

}
