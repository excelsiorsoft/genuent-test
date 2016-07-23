/**
 * 
 */
package com.iter;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author sleyzerzon
 *
 */
public class FilteringIterator<T> implements Iterator<T> {

	private Iterator<T> iterator;
	private IObjectTest predicate;
	
	private boolean hasNextCached;
	private boolean hasNext;
	
	private T cached;
	
	public FilteringIterator(Iterator<T> iterator, IObjectTest myTest) {
		this.iterator = iterator;
		this.predicate = myTest;
	}
	
	@Override
	public boolean hasNext() {
		
		if (hasNextCached) {
	        return hasNext;
	    } else {
	        return findNextMatch();
	    }
	}
	
	private boolean findNextMatch() {
	    
		boolean match = false;
	    
	    while(!match && iterator.hasNext()) {
	        cached = iterator.next();
	        match = predicate.test(cached);
	    }
	    
	    hasNextCached = true;
	    hasNext = match;
	    return match;
	}

	@Override
	public T next() {
		
		if (hasNext()) {
	        hasNextCached = false;
	        return cached;
	    } else {
	        throw new NoSuchElementException();
	    }
	}

	@Override
	public void remove() {
		iterator.remove();
	}

}
