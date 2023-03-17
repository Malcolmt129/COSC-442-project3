package edu.towson.cis.cosc442.project3.vendingmachine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {

    private VendingMachine vendingMachine;
    private VendingMachineItem item1;
    private VendingMachineItem item2;
    private VendingMachineItem item3;
    private VendingMachineItem item4;
    private VendingMachineItem invalidItem;
    
    @Before
    public void setUp() throws VendingMachineException {
        vendingMachine = new VendingMachine();
        item1 = new VendingMachineItem("Candy", 1.50);
        item2 = new VendingMachineItem("Chips", 1.75);
        item3 = new VendingMachineItem("Soda", 2.25);
        item4 = new VendingMachineItem("Gum", 0.75);
    }

    @Test
    public void testAddItem() throws VendingMachineException {
        vendingMachine.addItem(item1, "A");
        vendingMachine.addItem(item2, "B");
        vendingMachine.addItem(item3, "C");
        vendingMachine.addItem(item4, "D");
        assertEquals(item1, vendingMachine.getItem("A"));
        assertEquals(item2, vendingMachine.getItem("B"));
        assertEquals(item3, vendingMachine.getItem("C"));
        assertEquals(item4, vendingMachine.getItem("D"));
    }
    
    @Test(expected = VendingMachineException.class)
    public void testAddItemToOccupiedSlot() throws VendingMachineException {
        vendingMachine.addItem(item1, "A");
        vendingMachine.addItem(item2, "A");
    }
    
    @Test(expected = VendingMachineException.class)
    public void testAddItemWithInvalidCode() throws VendingMachineException {
        vendingMachine.addItem(item1, "E");
    }
    
    @Test(expected = VendingMachineException.class)
    public void testAddItemWithInvalidPrice() throws VendingMachineException {
    	invalidItem = new VendingMachineItem("Invalid Item", -1.0);
    	vendingMachine.addItem(invalidItem, "A");
    }
    
    @Test
    public void testRemoveItem() throws VendingMachineException {
        vendingMachine.addItem(item1, "A");
        VendingMachineItem removedItem = vendingMachine.removeItem("A");
        assertEquals(item1, removedItem);
        assertNull(vendingMachine.getItem("A"));
    }
    
    @Test(expected = VendingMachineException.class)
    public void testRemoveItemFromEmptySlot() throws VendingMachineException {
        vendingMachine.removeItem("A");
    }
    
    @Test(expected = VendingMachineException.class)
    public void testRemoveItemWithInvalidCode() throws VendingMachineException {
        vendingMachine.removeItem("E");
    }
    
    @Test
    public void testGetBalance() {
        assertEquals(0.0, vendingMachine.getBalance(), 0.001);
    }
    
    @Test
    public void testInsertMoney() {
        vendingMachine.insertMoney(1.0);
        vendingMachine.insertMoney(0.5);
        assertEquals(1.5, vendingMachine.getBalance(), 0.001);
    }
    
    @Test (expected = VendingMachineException.class)
    public void testInsertMoney2() throws VendingMachineException {
        vendingMachine.insertMoney(-1.0); 
    }
    

    @Test
    public void testMakePurchase() throws VendingMachineException {
        
        vendingMachine.addItem(item1, "A");

        // Purchase an item with exact change
        vendingMachine.insertMoney(1.5);
        vendingMachine.makePurchase("A");
        assertNull(vendingMachine.getItem("A"));
        assertEquals(0.0, vendingMachine.getBalance(), 0.001);

        // Purchase an item with change
        vendingMachine.addItem(item1, "A");
        vendingMachine.insertMoney(2.0);
        vendingMachine.makePurchase("A");
        assertNull(vendingMachine.getItem("A"));
        assertEquals(0.5, vendingMachine.getBalance(), 0.001);
    }

    @Test
    public void testReturnChange() {
        vendingMachine.insertMoney(3.25);
        assertEquals(3.25, vendingMachine.returnChange(), 0.01);
    }

}
