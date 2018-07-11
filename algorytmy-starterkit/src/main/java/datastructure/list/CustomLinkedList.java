package datastructure.list;

import java.util.Iterator; 
import java.util.NoSuchElementException;

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
	 * Returns number of elements in list
	 * 
	 * @return number of elements in list
	 */
	@Override
	public int size() {
		return currentSize;
	}

	/**
	 * Check if CustomArrayList is empty. CustomLinkedList is empty when
	 * currentSize equals 0.
	 * 
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
	 * 
	 * @param o
	 *            element to be checked
	 * @return true if list contains element
	 */
	@Override
	public boolean contains(Object o) {
		return indexOf(o) != -1;
	}

	/**
	 * Iterator for CustomLinkedList
	 */
	@Override
	public Iterator<T> iterator() {
		return new CustomLinkedListIterator<>();
	}

	/**
	 * Inserts element at the end of list.
	 * 
	 * @param t
	 *            element to be added at the end of list
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
	 * 
	 * @param o
	 *            object to be removed from list
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
		if (index == 0) {
			head = head.getNext();
			currentSize--;
		} else {
			removedNode = currentNode;
			previousNode = search(index - 1);
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
	 * 
	 * @return node specified by index
	 */
	private Node search(int index) {
		//Node previousNode = null;
		Node currentNode = head;
		int currentIndex = index;

		while (currentIndex > 0) {
			//previousNode = currentNode;
			currentNode = currentNode.getNext();
			currentIndex--;
		}

		return currentNode;
	}

	/**
	 * Checks range of index.
	 * 
	 * @param index
	 *            index to check
	 * @throws IndexOutOfBoundsException
	 *             when index is out of range (index < 0 || index >= size())
	 */
	private void checkBoundaries(int index) {
		if (index < 0 || index >= currentSize) {
			throw new IndexOutOfBoundsException("Index out of range!");
		}
	}

	/**
	 * Returns element at specified index.
	 * 
	 * @param index
	 *            index of element to return
	 * @return returns element at specified index
	 * @throws IndexOutOfBoundsException
	 *             if index is out of range (index < 0 || index >= size())
	 */
	@Override
	@SuppressWarnings("unchecked")
	public T get(int index) {
		checkBoundaries(index);

		Node searchedNode = search(index);

		return (T) searchedNode.getData();
	}

	/**
	 * Replaces element at specified index.
	 * 
	 * @param index
	 *            index of element to replace
	 * @param element
	 *            element to be stored at specified index
	 * @return element previously stored at specified index
	 * @throws IndexOutOfBoundsException
	 *             if index is out of range (index < 0 || index >= size())
	 */
	@Override
	@SuppressWarnings("unchecked")
	public T set(int index, T element) {
		Node settedNode;
		T oldElement;

		checkBoundaries(index);

		settedNode = search(index);
		oldElement = (T) settedNode.getData();

		settedNode.setData(element);

		return oldElement;
	}

	/**
	 * Inserts element at the specified index of list
	 * 
	 * @param index
	 *            index at which element is to be stored
	 * @param element
	 *            element to be added at specified index
	 * @throws IndexOutOfBoundsException
	 *             if index is out of range (index < 0 || index > size())
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
			currentSize++;
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
	 * 
	 * @param index
	 *            index at which element is to be removed
	 * @return returns element removed from list
	 * @throws IndexOutOfBoundsException
	 *             if index is out of range (index < 0 || index >= size())
	 */
	@Override
	@SuppressWarnings("unchecked")
	public T remove(int index) {
		Node previousNode;
		Node removedNode;
		Node nextNode;

		checkBoundaries(index);

		if (index == 0) {
			removedNode = head;
			head = head.getNext();
			currentSize--;
		} else {
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
	 * 
	 * @param o
	 *            element to search for
	 * @return index of specified element
	 */
	@Override
	public int indexOf(Object o) {
		Node currentNode = head;
		//Node searchedNode;
		int index = 0;

		if (o != null) {
			while (!currentNode.getData().equals(o)) {
				currentNode = currentNode.getNext();
				index++;

				if (currentNode == null) {
					return -1;
				}
			}
		} else {
			while(currentNode.getData() != null) {
				currentNode = currentNode.getNext();
				index++;
			}
		}

		return index;
	}

	/**
	 * Iterator for CustomLinkedList
	 */
	private class CustomLinkedListIterator<E> implements Iterator<E> {

		/**
		 * Position of iterator
		 */
		int currentPosition = 0;
		
		/**
		 * Flag to check if iterator removed element
		 */
		boolean flag = false;

		/**
		 * Check if iteration has more elements
		 * 
		 * @return true if there are more elements in iteration
		 */
		@Override
		public boolean hasNext() {
			return currentPosition < size();
		}

		/**
		 * Return next element in iteration
		 * 
		 * @return next element in iteration
		 * @throws NoSuchElementException
		 *             if there are no next elements in iteration
		 */
		@Override
		@SuppressWarnings("unchecked")
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			} else {
				return (E) get(currentPosition++);
			}
		}

		/**
		 * Removes last element returned by iterator
		 * 
		 * @throws IllegalStateException
		 *             if remove() method has already by called after last call
		 *             of next() method
		 */
		@Override
		public void remove() {
			if (flag) {
				CustomLinkedList.this.remove(currentPosition--);
				flag = false;
			} else {
				throw new IllegalStateException();
			}
		}
	}
}
