package tests;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import datastructure.list.CustomArrayList;

public class CustomArrayListTest {

	CustomArrayList<String> arrayList;
	Iterator<String> iterator;
	
	@Before
	public void setUp() {
		arrayList = new CustomArrayList<String>();
		iterator = arrayList.iterator();
	}

	@Test
	public void checkSizeOfList() {
		arrayList.add("Ola");
		arrayList.add("Janek");
		assertEquals(2, arrayList.size());
	}
	
	@Test
	public void checkIfListWhenEmpty() {
		assertTrue(arrayList.isEmpty());
	}
	
	@Test
	public void checkIfListWhenNotEmpty() {
		arrayList.add("Grażyna");
		assertFalse(arrayList.isEmpty());
	}
	
	@Test
	public void checkIfListContainsSpecifiedElement() {
		arrayList.add("Mateusz");
		arrayList.add("Malwina");
		arrayList.add("Marek");
		assertTrue(arrayList.contains("Mateusz"));
		assertFalse(arrayList.contains("Marlena"));
	}
	
	@Test
	public void checkIfListContainsSpecifiedElementNull() {
		arrayList.add("Mateusz");
		arrayList.add(null);
		arrayList.add("Marek");
		assertTrue(arrayList.contains(null));
	}

	@Test
	public void addElement() {
		arrayList.add("Ola");
		arrayList.add("Paweł");
		arrayList.add("Jacek");
		assertEquals("Paweł", arrayList.get(1));
		assertEquals("Jacek", arrayList.get(2));
		assertEquals("Ola", arrayList.get(0));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void addElementOutOfRange() {
		arrayList.add(-1, "Maciek");
	}
	
	@Test
	public void removeObjectFromList() {
		arrayList.add("Mateusz");
		arrayList.add("Marek");
		arrayList.add(null);
		arrayList.add("Malwina");
		arrayList.remove("Mateusz");
		arrayList.remove(null);
		assertEquals("Malwina", arrayList.get(1));
		assertEquals("Marek", arrayList.get(0));
	}
	
	@Test
	public void clearList() {
		arrayList.add("Mateusz");
		arrayList.add("Marek");
		arrayList.add("Monika");
		arrayList.add("Malwina");
		arrayList.clear();
		assertEquals(0, arrayList.size());
	}
	
	@Test
	public void getElementFromListByIndex() {
		arrayList.add("Ola");
		arrayList.add("Paweł");
		arrayList.add("Jacek");
		assertEquals("Jacek", arrayList.get(2));
		assertEquals("Paweł", arrayList.get(1));
		assertEquals("Ola", arrayList.get(0));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void getElementFromListByIndexOutOfRange() {
		arrayList.get(-1);
	}
	
	@Test
	public void setElementOnSpecifiedIndex() {
		arrayList.add("Ola");
		arrayList.add("Paweł");
		arrayList.add("Jacek");
		arrayList.set(0, "Ala");
		arrayList.set(2, "Placek");
		assertEquals("Placek", arrayList.get(2));
		assertEquals("Paweł", arrayList.get(1));
		assertEquals("Ala", arrayList.get(0));
	}
	
	@Test
	public void addElementOnSpecifiedIndex() {
		arrayList.add("Ola");
		arrayList.add("Paweł");
		arrayList.add(0,"Jacek");
		assertEquals("Paweł", arrayList.get(2));
		assertEquals("Jacek", arrayList.get(0));
		assertEquals("Ola", arrayList.get(1));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testIndexOutOfBoundsException() {
		arrayList.add(-1, "Mietek");
		arrayList.add(15, "Iza");
	}
	
	@Test
	public void removeObjectFromListByIndex() {
		arrayList.add("Mateusz");
		arrayList.add("Marek");
		arrayList.add("Monika");
		arrayList.add("Malwina");
		arrayList.remove(0);
		arrayList.remove(1);
		assertEquals("Marek", arrayList.get(0));
		assertEquals("Malwina", arrayList.get(1));
		assertEquals(2, arrayList.size());
	}

	@Test
	public void checkIndex() {
		arrayList.add("Mateusz");
		arrayList.add("Marek");
		arrayList.add("Monika");
		assertEquals(1, arrayList.indexOf("Marek"));
		assertEquals(0, arrayList.indexOf("Mateusz"));
		assertEquals(2, arrayList.indexOf("Monika"));
		assertEquals(-1, arrayList.indexOf("Jacek"));
	}
	
	@Test
	public void checkIndexIfNull() {
		arrayList.add("Mateusz");
		arrayList.add("Marek");
		arrayList.add(null);
		assertEquals(2, arrayList.indexOf(null));
	}
	
	@Test
	public void iteratorHasNext() {
		arrayList.add("Marta");
		arrayList.add("Marek");
		assertTrue(iterator.hasNext());
	}
	
	@Test
	public void iteratorHasNextEmptyList() {
		assertFalse(iterator.hasNext());
	}
	
	@Test
	public void iteratorReturnsValue() {
		arrayList.add("Marta");
		arrayList.add("Marek");
		assertEquals("Marta", iterator.next());
        assertEquals("Marek", iterator.next());
	}
	
	@Test
	public void iteratorMoving() {
		while (iterator.hasNext()) {
            iterator.next();
        }
        assertFalse(iterator.hasNext());
	}
}
