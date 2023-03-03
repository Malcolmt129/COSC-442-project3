package edu.towson.cis.cosc442.project2.vendingmachine;

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

	@Test
	public void testVendingMachine() {
		assertEquals(vm.getBalance(),0.0,0.001);
		assertEquals(vm.getItem("B"), null);
	}

	@Test
	public void testAddItem() {
		vm.addItem(new VendingMachineItem("Sour Patch Kids: Watermelon", 2.00), "A" );
		assertEquals("Sour Patch Kids: Watermelon", vm.getItem("A").getName() );
	}

	@Test
	public void testGetItem() {
		vm.addItem(new VendingMachineItem("Chesters", 2.00), "B" );
		assertEquals("Chesters",vm.getItem("B").getName());
	}

	@Test
	public void testRemoveItem() {
		vm.addItem(new VendingMachineItem("Chesters", 2.00), "B" );
		vm.removeItem("B");
		assertEquals(null,vm.getItem("B"));
	}

	@Test
	public void testInsertMoney() {
		vm.insertMoney(1000.00);
		assertEquals(1000.00,vm.getBalance(),0.001);
	}

	@Test
	public void testGetBalance() {
		assertEquals(0.0,vm.getBalance(),0.001);
	}

	@Test
	public void testMakePurchase() {
		vm.addItem(new VendingMachineItem("Chester's", 2.00), "A");
		vm.insertMoney(3.00);
		
		assertEquals(true,vm.makePurchase("A"));
	}

	@Test
	public void testReturnChange() {
		vm.addItem(new VendingMachineItem("Chester's", 2.00), "A");
		vm.insertMoney(3.00);
		
		assertEquals(1.00, vm.returnChange("A"), 0.001);
		
	}

}
