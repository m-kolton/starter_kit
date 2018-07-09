package datastructure.list;

import java.util.Iterator;

/**
 * List based on recursively related objects
 *
 * @param <T>
 */
public class CustomLinkedList<T> extends AbstractCustomListAdapter<T> {

	/**
	 * First node
	 */
	private Node head;
	
	/**
	 * Last node
	 */
	private Node tail;

	/**
	 * Number of elements in CustomLinkedList
	 */
	private int currentSize;

	/**
	 * Constructs an empty list and sets head and tail as null.
	 */
	public CustomLinkedList() {
		head = null;
		tail = null;
		currentSize = 0;
	}

	/**
	 * Returns size of list.
	 * @return size of list
	 */
	@Override
	public int size() {
		return currentSize;
	}

	/**
	 * Check if CustomArrayList is empty. CustomArrayList is empty when currentSize equals 0.
	 * @return true if list is empty
	 */
	@Override
	public boolean isEmpty() {
		if (currentSize == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Returns true if list contains specified element.
	 * @return true if list contains element
	 */
	@Override
	public boolean contains(Object o) {
		return indexOf(o) != -1;
	}

	@Override
	public Iterator<T> iterator() {
		return new CustomLinkedListIterator<>();
	}

	/**
	 * Inserts element at the end of list
	 * @return returns true if success
	 */
	@Override
	public boolean add(T t) {
		Node currentNode = new Node(t);

		if (head == null) {
			head = currentNode;
			tail = currentNode;
			currentSize++;
		} else {
			tail.setNext(currentNode);
			tail = currentNode;
			currentSize++;
		}
		return true;
	}

	/**
	 * Removes object from list.
	 * @return returns true if success
	 */
	@Override
	public boolean remove(Object o) {

		Node currentNode = head;
		Node removedNode;
		Node previousNode;
		Node nextNode;
		int index = 0;

		while (currentNode.getData() != o) {
			currentNode = currentNode.getNext();
			index++;
		}
		if(index == 0) {
			head = head.getNext();
			currentSize--;
		}else {
		removedNode = currentNode;
		previousNode = search(index-1);
		nextNode = removedNode.getNext();

		previousNode.setNext(nextNode);
		currentSize--;
		}
		
		return true;
	}

	/**
	 * Removes all the elements from list and sets size as 0.
	 */
	@Override
	public void clear() {
		head = null;
		currentSize = 0;
	}

	/**
	 * Returns node specified by index.
	 * @return node specified by index
	 */
	private Node search(int index) {
		Node previousNode = null;
		Node currentNode = head;
		int currentIndex = index;

		while (currentIndex > 0) {
			previousNode = currentNode;
			currentNode = currentNode.getNext();
			currentIndex--;
		}

		return currentNode;
	}

	/**
	 * Returms element at specified index.
	 * @return returns element at specified index
	 * @throws IndexOutOfBoundsException when index is out of range
	 */
	@Override
	public T get(int index) {
		if (index < 0 || index > currentSize) {
			throw new IndexOutOfBoundsException("Index out of range!");
		}
		
		Node searchedNode = search(index);

		return (T) searchedNode.getData();
	}

	/**
	 * Replaces element at specified index.
	 * @return element previously stored at specified index
	 * @throws IndexOutOfBoundsException when index is out of range
	 */
	@Override
	public T set(int index, T element) {
		Node settedNode;
		T oldElement;

		settedNode = search(index);
		oldElement = (T) settedNode.getData();

		settedNode.setData(element);

		return oldElement;
	}

	/**
	 * Inserts element at the specified index of list
	 * @throws IndexOutOfBoundsException when index is out of range
	 */
	@Override
	public void add(int index, T element) {
		Node previousNode;
		Node removedNode;
		Node insertedNode = new Node(element);

		if (index < 0 || index > currentSize) {
			throw new IndexOutOfBoundsException("Index out of range!");
		}

		if (index == 0) {
			insertedNode.setNext(head);
			head = insertedNode;
		} else {
			previousNode = search(index - 1);
			removedNode = search(index);
			insertedNode.setNext(removedNode);
			previousNode.setNext(insertedNode);
			currentSize++;
		}
	}

	/**
	 * Removes element at specified index from list.
	 * @return returns element removed from list
	 */
	@Override
	public T remove(int index) {
		Node previousNode;
		Node removedNode;
		Node nextNode;

		if(index == 0) {
			removedNode = head;
			head = head.getNext();
			currentSize--;
		}else {
		previousNode = search(index - 1);
		removedNode = search(index);
		nextNode = removedNode.getNext();

		previousNode.setNext(nextNode);
		currentSize--;
		}
		
		return (T) removedNode;
		
	}

	/**
	 * Returns index of first specified element or -1 if element doesn't exist
	 * @return index of specified element
	 */
	
	//TODO Dopisac dla null-a
	@Override
	public int indexOf(Object o) {
		Node currentNode = head;
		Node searchedNode;
		int index = 0;

		while (!currentNode.getData().equals(o)) {
			currentNode = currentNode.getNext();
			index++;

			if (currentNode == null) {
				return -1;
			}
		}

		return index;
	}

	/**
	 * Iterator for CustomLinkedList
	 */
	private class CustomLinkedListIterator<E> implements Iterator<E> {

		Node currentNode = head;

		@Override
		public boolean hasNext() {

			return currentNode != null;
		}

		@Override
		public E next() {
			if (hasNext()) {
				E data = (E) currentNode.getData();
				currentNode = currentNode.getNext();
				return data;
			}
			return null;
		}

		@Override
		public void remove() {

		}
	}
}
