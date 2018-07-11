package datatype;

import java.util.List;
import datastructure.list.CustomLinkedList;

/**
 * Stack, LIFO queue
 */
public class CustomStack<T> extends AbstractCustomStackAdapter<T> {

	List<T> storage = new CustomLinkedList<>();

	public CustomStack(List<T> storage) {
		this.storage = storage;
	}

	/**
	 * Pushes object at the top of stack.
	 * 
	 * @param t
	 *            object to be added at the top of stack
	 */
	@Override
	public void push(T t) {
		storage.add(storage.size(), t);
	}

	/**
	 * Removes object at the top of stack and returns it.
	 * 
	 * @return object deleted from stack
	 */
	@Override
	public T pop() {
		T deletedValue = storage.get(storage.size() - 1);
		storage.remove(storage.size() - 1);

		return deletedValue;
	}

	/**
	 * Returns size of queue.
	 * 
	 * @return size of queue
	 */
	@Override
	public int size() {
		return storage.size();
	}

	/**
	 * Check if queue is empty.
	 * 
	 * @return true if empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		return storage.isEmpty();
	}
}
