package tests;

import static org.junit.Assert.*;  

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import datastructure.list.FilterIterator;

public class FilterIteratorTest {

	List<Integer> list = new ArrayList<>();
	
	@Before
	public void setUp() {
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(4);
	}

	@Test
	public void testFilter() {
		FilterIterator<Integer> filter = new FilterIterator<>(list, i -> i%2 == 0);
		assertTrue(filter.hasNext());
	}
	
	@Test
	public void testFilterNextEven() {
		FilterIterator<Integer> filter = new FilterIterator<>(list, i -> i%2 == 0);
		assertSame(2, filter.next());
		assertSame(2, filter.next());
		assertSame(4, filter.next());
	}
	
	@Test
	public void testFilterNextNotEven() {
		FilterIterator<Integer> filter = new FilterIterator<>(list, i -> i%2 == 1);
		assertSame(1, filter.next());
		assertSame(3, filter.next());
		assertSame(5, filter.next());
	}
	
//	@Test(expected = NoSuchElementException.class)
//	public void testFilterNext() {
//		FilterIterator<Integer> filter = new FilterIterator<>(list, i -> i%2 == 5);
//		filter.next();
//	}

}
