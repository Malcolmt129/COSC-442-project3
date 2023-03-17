package edu.towson.cis.cosc442.project3.vendingmachine;

import org.junit.Test;
import static org.junit.Assert.*;

public class VendingMachineItemTest {

    @Test
    public void testConstructor() throws VendingMachineException {
        VendingMachineItem item = new VendingMachineItem("Soda", 1.5);
        assertEquals("Soda", item.getName());
        assertEquals(1.5, item.getPrice(), 0.001);
    }
    
    @Test(expected = VendingMachineException.class)
    public void testConstructorWithNegativePrice() throws VendingMachineException {
        VendingMachineItem item = new VendingMachineItem("Chips", -0.5);
    }
    
    @Test
    public void testGetName() throws VendingMachineException {
        VendingMachineItem item = new VendingMachineItem("Candy", 0.75);
        assertEquals("Candy", item.getName());
    }
    
    @Test
    public void testGetPrice() throws VendingMachineException {
        VendingMachineItem item = new VendingMachineItem("Juice", 2.25);
        assertEquals(2.25, item.getPrice(), 0.001);
    }
    
}






