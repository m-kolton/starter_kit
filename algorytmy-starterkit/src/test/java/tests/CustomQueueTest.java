package tests;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Before;
import org.junit.Test;

import datastructure.list.CustomLinkedList;
import datatype.CustomQueue;

public class CustomQueueTest {
	
	List<String> list = new CustomLinkedList<>();
	CustomQueue<String> queue;
	
	@Before
	public void setUp() {
		queue = new CustomQueue<>(list);
	}

	@Test
	public void checkSizeOfList() {
		queue.add("Ola");
		queue.add("Janek");
		queue.add(null);
		assertEquals(3, queue.size());
	}
	
	@Test
	public void checkIfListIsEmpty() {
		assertTrue(queue.isEmpty());
	}
	
	@Test
	public void listPeekNullAtHead() {
		queue.add(null);
		queue.add("Mateusz");
		queue.add("Janusz");
		assertEquals(null, queue.peek());
	}
	
	@Test
	public void listPeek() {
		queue.add("Mateusz");
		queue.add("Janusz");
		assertEquals("Mateusz", queue.peek());
	}
	
	@Test
	public void listPeekEmptyList() {
		assertEquals(null, queue.peek());
	}
	
	@Test
	public void listPoll() {
		queue.add("Mateusz");
		queue.add("Malwina");
		assertEquals("Mateusz", queue.poll());
	}
	
	@Test
	public void listPollListEmpty() {
		assertEquals(null, queue.poll());
	}
	
	@Test
	public void listPollNullAtHead() {
		queue.add(null);
		assertEquals(null, queue.poll());
	}
}
