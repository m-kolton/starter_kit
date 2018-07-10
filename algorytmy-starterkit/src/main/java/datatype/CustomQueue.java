package datatype;

import java.util.List;
import datastructure.list.CustomLinkedList;

/**
 * FIFO queue
 */
public class CustomQueue<T> extends AbstractCustomQueueAdapter<T> {
    
	private List<T> storage = new CustomLinkedList<T>();
	
	/**
	 * Number of elements in queue.
	 */
	private int currentSize;
    
    public CustomQueue(List<T> storage) {
        this.storage = storage;
    }

    /**
     * Returns size of queue.
     * @return size of queue
     */
    @Override
    public int size() {
        return storage.size();
    }

    /**
     * Check if queue is empty.
     * @return true if empty, false if not
     */
    @Override
    public boolean isEmpty() {
        return storage.isEmpty();
    }

    /**
     * Inserts object into this queue and returns true if success.
     * @return true if success
     */
    @Override
    public boolean add(T t) {	
        storage.add(t);
        return true;
    }

    /**
     * Retrieves and removes the head of queue, or returns null if this queue is empty.
     * @return first object in queue or null if queue is empty
     */
    @Override
    public T poll() {
        T deletedValue = null;
        
        if(!isEmpty()) {
        	deletedValue = storage.get(0);
        	storage.remove(0);
        }
        
        return deletedValue;
    }

    /**
     * Retrieves, but does not remove, the head of queue, or returns null if this queue is empty.
     * @return first object in queue or null if queue is empty
     */
    @Override
    public T peek() {
    	 T retrievedValue = null;
         
         if(!isEmpty()) {
        	 retrievedValue = storage.get(0);
         }
         
         return retrievedValue;
    }
}
