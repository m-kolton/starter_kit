package datatype;

import java.util.List;
import datastructure.list.CustomLinkedList;

/**
 * Stack, LIFO queue
 */
public class CustomStack<T> extends AbstractCustomStackAdapter<T> {
    List<T> storage = new CustomLinkedList<>();
    
    /**
	 * Number of elements in stack.
	 */
    private int currentSize;
    
    public CustomStack(List<T> storage) {
        this.storage = storage;
    }

    /**
     * Pushes object at the top of stack.
     */
    @Override
    public void push(T t) {
        storage.add(currentSize, t);
        currentSize++;
    }

    /**
     * Removes object at the top of stack and returns it.
     * @return object deleted from stack
     */
    @Override
    public T pop() {
        T deletedValue = storage.get(currentSize);
        storage.remove(currentSize);
        
        return deletedValue;
    }

    /**
     * Returns size of queue.
     * @return size of queue
     */
    @Override
    public int size() {
        return currentSize;
    }

    /**
     * Check if queue is empty.
     * @return true if empty, false if not
     */
    @Override
    public boolean isEmpty() {
        if(currentSize == 0) {
        	return true;
        }
        return false;
    }
}
