package datastructure.list;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

/**
 * Filter iterator
 */
public class FilterIterator<T> implements Iterator<T> {
    private List<T> list;
    private Predicate<T> predicate;
    private Iterator<T> iterator;

    public FilterIterator(List<T> list, Predicate<T> predicate) {
         this.iterator = list.iterator();
         this.predicate = predicate;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public T next() {
        if(!hasNext()) {
        	throw new NoSuchElementException("Illegal operation");
        }
        T next = iterator.next();
        if(predicate.test(next)) {
        	return next;
        }
        return null;
    }

    @Override
    public void remove() {
        iterator.remove();
    }
}
