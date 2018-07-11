package datastructure.list;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

/**
 * Filter iterator
 */
public class FilterIterator<T> implements Iterator<T> {
	private Predicate<T> predicate;
	private Iterator<T> iterator;

	/**
	 * Creates new FilterIterator with list and predicate.
	 * 
	 * @param list
	 * @param predicate
	 */
	public FilterIterator(List<T> list, Predicate<T> predicate) {
		this.iterator = list.iterator();
		this.predicate = predicate;
	}

	/**
	 * Check if iteration has more elements
	 * 
	 * @return true if there are more elements in iteration
	 */
	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

	/**
	 * Return next element in iteration
	 * 
	 * @return next element in iteration which fulfill predicate
	 * @throws NoSuchElementException
	 *             if there are no next elements which fulfill predicate in iteration
	 */
	@Override
	public T next() {
		T next = iterator.next();
		
		if(hasNext()) {
			while (!predicate.test(next))
				next = iterator.next();
		} else {
			throw new NoSuchElementException();
		}
		
		return next;
	}

	/**
	 * Always throws UnsupportedOperationException.
	 * 
	 * @throws UnsupportedOperationException
	 */
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
