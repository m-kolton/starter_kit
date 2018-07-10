package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import datastructure.list.CustomLinkedList;

public class CustomLinkedListTest {

	private CustomLinkedList linkedList;
	
	@Before
	public void setUp() {
		linkedList = new CustomLinkedList<String>();
	}

//	@Test
//	public void checkSizeOfList() {
//		linkedList.add("Ola");
//		linkedList.add("Janek");
//		assertEquals(2, linkedList.size());
//	}
//	
//	@Test
//	public void checkIfListIsEmpty() {
//		assertTrue(linkedList.isEmpty());
//	}
//	
//	@Test
//	public void checkIfListContainsSpecifiedElement() {
//		linkedList.add("Mateusz");
//		linkedList.add("Malwina");
//		linkedList.add("Marek");
//		assertTrue(linkedList.contains("Mateusz"));
//		assertFalse(linkedList.contains("Marlena"));
//	}
//	
	@Test
	public void addElement() {
		linkedList.add("Ola");
		linkedList.add("Paweł");
		linkedList.add("Jacek");
		assertEquals("Paweł", linkedList.get(1));
		assertEquals("Jacek", linkedList.get(2));
		assertEquals("Ola", linkedList.get(0));
		assertEquals(3, linkedList.size());
	}
//	
//	@Test
//	public void removeObjectFromList() {
//		linkedList.add("Mateusz");
//		linkedList.add("Marek");
//		linkedList.add("Monika");
//		linkedList.add("Malwina");
//		linkedList.remove("Mateusz");
//		linkedList.remove("Monika");
//		assertEquals("Malwina", linkedList.get(1));
//		assertEquals("Marek", linkedList.get(0));
//	}
//	
//	@Test
//	public void clearList() {
//		linkedList.add("Mateusz");
//		linkedList.add("Marek");
//		linkedList.add("Monika");
//		linkedList.add("Malwina");
//		linkedList.clear();
//		assertEquals(0, linkedList.size());
//	}
//	
//	@Test
//	public void getElementFromListByIndex() {
//		linkedList.add("Ola");
//		linkedList.add("Paweł");
//		linkedList.add("Jacek");
//		assertEquals("Jacek", linkedList.get(2));
//		assertEquals("Paweł", linkedList.get(1));
//		assertEquals("Ola", linkedList.get(0));
//	}
//	
//	@Test
//	public void setElementOnSpecifiedIndex() {
//		linkedList.add("Ola");
//		linkedList.add("Paweł");
//		linkedList.add("Jacek");
//		linkedList.set(0, "Ala");
//		linkedList.set(2, "Placek");
//		assertEquals("Placek", linkedList.get(2));
//		assertEquals("Paweł", linkedList.get(1));
//		assertEquals("Ala", linkedList.get(0));
//	}
//	
//	@Test
//	public void addElementOnSpecifiedIndex() {
//		linkedList.add("Ola");
//		linkedList.add("Paweł");
//		linkedList.add(0,"Jacek");
//		assertEquals("Paweł", linkedList.get(2));
//		assertEquals("Jacek", linkedList.get(0));
//		assertEquals("Ola", linkedList.get(1));
//	}
//	
//	@Test(expected = IndexOutOfBoundsException.class)
//	public void testIndexOutOfBoundsException() {
//		linkedList.add(-1, "Mietek");
//		linkedList.add(15, "Iza");
//	}
//	
//	@Test
//	public void removeObjectFromListByIndex() {
//		linkedList.add("Mateusz");
//		linkedList.add("Marek");
//		linkedList.add("Monika");
//		linkedList.add("Malwina");
//		linkedList.remove(0);
//		linkedList.remove(1);
//		assertEquals("Marek", linkedList.get(0));
//		assertEquals("Malwina", linkedList.get(1));
//		assertEquals(2, linkedList.size());
//	}
//
//	@Test
//	public void checkIndex() {
//		linkedList.add("Mateusz");
//		linkedList.add("Marek");
//		linkedList.add("Monika");
//		assertEquals(1, linkedList.indexOf("Marek"));
//		assertEquals(0, linkedList.indexOf("Mateusz"));
//		assertEquals(2, linkedList.indexOf("Monika"));
//		assertEquals(-1, linkedList.indexOf("Jacek"));
//	}
}
