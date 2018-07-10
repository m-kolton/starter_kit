package datastructure.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * List based on the table
 *
 * @param <T>
 */
public class CustomArrayList<T> extends AbstractCustomListAdapter<T> {
	
	/**
	 * Default capacity of CustomArrayList  
	 */
	private static final int DEFAULT_CAPACITY = 10;
	
	/**
	 * Maximum fill rate of CustomArrayList. After reaching this level, size of CustomArrayList must be increased.  
	 */
	private static final double MAX_FILL_RATE = 0.9;
	
	/**
	 * Default capacity of CustomArrayList. After reaching this level, size of CustomArrayList must be decreased.   
	 */
	private static final double MIN_FILL_RATE = 0.6;
	
	/**
	 * Number of elements in CustomArrayList
	 */
	private int currentSize;
	
	/**
	 * Space where CustomArrayList objects are stored
	 */
	private Object[] dataStructure;

	/**
	 * Default constructor which creates CustomArrayList with default capacity
	 */
    public CustomArrayList() {
    	dataStructure = new Object[10];
    }

    /**
     * Parameterized constructor which creates CustomArrayList with initial capacity
     * @param initialCapacity
     */
    public CustomArrayList(int initialCapacity) {
    	if(initialCapacity < 0 || initialCapacity == 0) {
    		throw new IllegalArgumentException("Illegall capacity of CustomArrayList: " + " Capacity must be grater or equal 0!");
    	} else {
    		dataStructure = new Object[initialCapacity];
    	}
    }

    /**
     * Returns number of elements in list
     * @return number of elements in list
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
    	if(currentSize == 0) {
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
        return new CustomArrayListIterator<>();
    }

    /**
     * Increase capacity of CustomArrayList when list is more than 90% full
     */
    private void increaseCapacity() {
    	int newCapacity;
    	newCapacity = (int)(1.25*(dataStructure.length));
    	
    	Object[] newIncreasedDataStructure = new Object[newCapacity];
    	for(int i=0; i<currentSize; i++) {
    		newIncreasedDataStructure[i] = dataStructure[i];
    	}
    	
    	dataStructure = newIncreasedDataStructure;
    }
    
    /**
     * Decrease capacity of CustomArrayList when list is less then 60% full
     */
    private void decreaseCapacity() {
    	
    	int newCapacity;
    	newCapacity = (int)(0.75*(dataStructure.length));
    	
    	Object[] newDecreasedDataStructure = new Object[newCapacity];
    	for(int i=0; i<currentSize; i++) {
    		newDecreasedDataStructure[i] = dataStructure[i];
    	}
    	
    	dataStructure = newDecreasedDataStructure;
    }
    
    /**
     * Checks range of index.
     * @throws IndexOutOfBoundsException
     */
    private void checkBoundaries(int index) {
    	if(index < 0 || index > currentSize) {
    		throw new IndexOutOfBoundsException("Index out of range!");
    	}
    }
    
    /**
	 * Inserts element at the end of list.
	 * @return returns true if success
	 */
    @Override
    public boolean add(T t) {
       	if(currentSize >= dataStructure.length * MAX_FILL_RATE){
       		increaseCapacity();
       	}
       	dataStructure[currentSize] = t;
    	currentSize += 1;
    	
        return true;
    }

    /**
	 * Removes object from list.
	 * @return returns true if success
	 */
    @Override
    public boolean remove(Object o) {
        if((currentSize <= dataStructure.length * MIN_FILL_RATE) && (dataStructure.length > DEFAULT_CAPACITY)) {
        	decreaseCapacity();
        }
        for(int i=0; i<currentSize; i++) {
        	if(o.equals(dataStructure[i])) {
        		
        		for(int j=i+1; j<currentSize; j++) {
        			dataStructure[j-1] = dataStructure[j];
        		}
        		
        		dataStructure[--currentSize] = null;
        	}
        }
        return false;
    }

    /**
	 * Removes all the elements from list and sets size as 0.
	 */
    @Override
    public void clear() {
    	for(int i=0; i<currentSize; i++) {
    		dataStructure[i] = null;
    	}
    	currentSize = 0;
    }

    /**
	 * Returns element at specified index.
	 * @return returns element at specified index
	 */
    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
    	checkBoundaries(index);
    	
    	T searchedValue = (T) dataStructure[index];
        return searchedValue;
    }

    /**
	 * Replaces element at specified index.
	 * @return element previously stored at specified index
	 */
    @Override
    @SuppressWarnings("unchecked")
    public T set(int index, T element) {
    	checkBoundaries(index);
    	
    	T changedValue = (T) dataStructure[index];
    	dataStructure[index] = element;
        return changedValue;
    }

    /**
	 * Inserts element at the specified index of list
	 */
    @Override
    public void add(int index, T element) {
    	if(currentSize >= dataStructure.length * MAX_FILL_RATE){
       		increaseCapacity();
       	}
    	
    	checkBoundaries(index);
    	for(int i=currentSize-1; i>=index; i--){
    		dataStructure[i+1] = dataStructure[i];
    	}
    	
    	dataStructure[index] = element;
    	currentSize += 1;
    	
    }

    /**
	 * Removes element at specified index from list.
	 * @return returns element removed from list
	 */
    @Override
    @SuppressWarnings("unchecked")
    public T remove(int index) {
    	if((currentSize <= dataStructure.length * MIN_FILL_RATE) && (dataStructure.length > DEFAULT_CAPACITY)) {
        	decreaseCapacity();
        }
    	T deletedValue = (T) dataStructure[index];
    	
    	checkBoundaries(index);
    	for(int j=index+1; j<currentSize; j++) {
			dataStructure[j-1] = dataStructure[j];
		}
		
		dataStructure[--currentSize] = null;
		
        return deletedValue;
    }

    /**
	 * Returns index of first specified element or -1 if element doesn't exist
	 * @return index of specified element
	 */
    @Override
    public int indexOf(Object o) {
        
    	if(o == null) {
    		throw new NullPointerException("You are trying to find index of null!");
    	}
    	for(int i=0; i<currentSize; i++) {
    		if(o.equals(dataStructure[i])) {
    			return i;
    		}
    	}
        return -1;
    }

    /**
     * Iterator for CustomArrayList
     */
    private class CustomArrayListIterator<E> implements Iterator<E> {

    	int currentPosition = 0;
    	
        @Override
        public boolean hasNext() {
            
            if(currentPosition < currentSize) {
            	return true;
            }
            return false;
        }

        @Override
        public E next() {
            if(!hasNext()){
            	throw new NoSuchElementException();
            }else {
            	return (E) dataStructure[currentPosition++];
            }
        }

        @Override
        public void remove() {
        	
        }
    }
}
