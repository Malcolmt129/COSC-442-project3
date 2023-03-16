package game;
import java.awt.Color;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventoryTest {
	
	Inventory inv;

	@Before
	public void setUp() throws Exception {
		inv = new Inventory(2);
		Item nItem = new Item('a',new Color(255,255,255),"testObj",null);
		Item nItem2 = new Item('b',new Color(255,255,255),"testObj2",null);
		inv.add(nItem);
		inv.add(nItem2);
	}

	@After
	public void tearDown() throws Exception {
		inv = null;
	}

	
	/*
	 * Testing getItems() method. Seeing if the glyphs 
	 * are the same.
	 */
	@Test
	public void testGetItems() {
		
		assertEquals('a',inv.getItems()[0].glyph()); 
		
	}
	
	/*
	 * Testing get() method by seeing if the glyphs
	 * are the same as expected
	 */
	@Test
	public void testGet() {
		assertEquals('a',inv.get(0).glyph());
	}
	
	/*
	 * Testing the add() method by seeing if the 
	 * glyphs are the same as expected. The add()
	 * method was implemented in the setUp() function
	 */
	@Test
	public void testAdd() {
		assertEquals('a',inv.get(0).glyph());
	}
	
	/*
	 * Trying to add more than the max that was provided
	 * which was 2
	 */
	@Test(expected= java.lang.ArrayIndexOutOfBoundsException.class)
	public void testAdd2() {
		Item nItem3 = new Item('c',new Color(255,255,255),"testObj3",null);
		inv.add(nItem3);
		assertEquals('c',inv.get(2));
	}
	
	
	
	/*
	 * Testing the remove() method. Expecting null as the
	 * result of removal.
	 */
	@Test
	public void testRemove() {
		inv.remove(inv.get(0));
		assertEquals(null, inv.get(0));
	}
	
	
	/*
	 * Using this test to get 100% coverage of the code.
	 */
	@Test
	public void testRemove2() {
		inv.remove(inv.get(1));
		assertEquals(null, inv.get(1));
	}
	
	/*
	 * Using test to get 100% covereage of code.
	 */
	@Test(expected=java.lang.ArrayIndexOutOfBoundsException.class)
	public void testRemove3() {
		
		Inventory inv = new Inventory(0);
		inv.remove(null);
		assertEquals(null, inv.get(0));
		
	}

	/*
	 * Testing the isFull() method. Based on the setUp()
	 * method this should be true.
	 */
	@Test
	public void testIsFull() {
		assertEquals(true,inv.isFull());
	}
	
	
	/*
	 * Have to remove an element to make it false so that
	 * there is 100% code coverage.
	 */
	@Test
	public void testIsFull2() {
		inv.remove(inv.get(1));
		assertEquals(false, inv.isFull());
	}

	
	/*
	 * Testing the contains() function.
	 */
	@Test
	public void testContains() {
		Item nItem = inv.get(0);
		assertEquals(true, inv.contains(nItem));
	}
	
	
	/*
	 * Testing other decision branch.
	 * 
	 */
	@Test
	public void testContains2 () {
		Item nItem = inv.get(0);
		inv.remove(nItem);
		assertEquals(false, inv.contains(nItem));
	}

}
