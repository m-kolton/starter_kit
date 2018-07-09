package datatype;

import java.util.List;
import datastructure.list.CustomLinkedList;

/**
 * FIFO queue
 */
public class CustomQueue<T> extends AbstractCustomQueueAdapter<T> {
    //TODO QUESTIONS: Czy zmienna powinna byc prywatna?
	private List<T> storage = new CustomLinkedList<>();
	
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

    //TODO QUESTIONS: Czy można dodawac null?
    /**
     * Inserts object into this queue and returns true if success.
     * @param t
     * @return inserted object
     */
    @Override
    public boolean add(T t) {
    	
        storage.add(t);
        currentSize++;
        
        return true;
    }

    //TODO QUESTIONS: Czy stworzyc nową metodę zwracajaca pierwszy element tak, żeby nie powtarzac kodu?
    /**
     * Retrieves and removes the head of queue, or returns null if this queue is empty.
     * @return first object in queue or null if queue is empty
     */
    @Override
    public T poll() {
        T deletedValue;
        
        if(currentSize == 0) {
        	deletedValue = null;
        }
       
        storage.remove(0);
        deletedValue = storage.get(0);
        
        return deletedValue;
    }

    /**
     * Retrieves, but does not remove, the head of queue, or returns null if this queue is empty.
     * @return first object in queue or null if queue is empty
     */
    @Override
    public T peek() {
    	 T retrievedValue;
         
         if(currentSize == 0) {
         	retrievedValue = null;
         }
        
         retrievedValue = storage.get(0);
         
         return retrievedValue;
    }
}
