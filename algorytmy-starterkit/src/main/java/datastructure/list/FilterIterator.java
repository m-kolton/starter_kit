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
    //TODO QUESTIONS: Czy można użyc iteratora list?
    private Iterator<T> iterator;

    public FilterIterator(List<T> list, Predicate<T> predicate) {
         this.list = list;
         this.predicate = predicate;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    //TODO QUESTIONS: Jak sprawdzic czy predykat jest spełniony?
    //TODO QUESTIONS: Co zwracac jeśli predykat nie jest spełniony?
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

    //TODO QUESTIONS: Czy to dobre podejście?
    @Override
    public void remove() {
        iterator.remove();
    }
}
