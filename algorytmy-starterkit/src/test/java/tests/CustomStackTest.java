package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import datastructure.list.CustomLinkedList;
import datatype.CustomStack;

public class CustomStackTest {

	List<String> list = new CustomLinkedList<>();
	CustomStack<String> stack;
	
	@Before
	public void setUp() {
		stack = new CustomStack<>(list);
	}

	@Test
	public void checkSizeOfList() {
		stack.push("Ola");
		stack.push("Janek");
		assertEquals(2, stack.size());
	}
	
	@Test
	public void checkIfListIsEmpty() {
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void listPop() {
		stack.push("Mateusz");
		stack.push("Malwina");
		assertEquals("Malwina", stack.pop());
	}

}
