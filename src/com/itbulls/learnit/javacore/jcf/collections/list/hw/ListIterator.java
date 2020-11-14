package com.itbulls.learnit.javacore.jcf.collections.list.hw;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An iterator for lists that allows the programmer
 * to traverse the list in either direction, modify
 * the list during iteration, and obtain the iterator's
 * current position in the list. A ListIteratorImpl
 * has no current element; its cursor position always
 * lies between the element that would be returned by a call
 * to {@code previous()} and the element that would be
 * returned by a call to {@code next()}.
 * 
 * @author Andrii Piatakha
 */

public interface ListIterator extends Iterator<Object> { 
	
	/**
     * Returns true if this list iterator has more elements when
     * traversing the list in the reverse direction.  (In other words,
     * returns true if previous would return an element
     * rather than throwing an exception.)
     *
     * @return true if the list iterator has more elements when
     *         traversing the list in the reverse direction
     */
	boolean hasPrevious(); 
	
	
	/**
     * Returns the previous element in the list and moves the cursor
     * position backwards.  This method may be called repeatedly to
     * iterate through the list backwards, or intermixed with calls to
     * next() to go back and forth.  (Note that alternating calls
     * to next() and previous() will return the same
     * element repeatedly.)
     *
     * @return the previous element in the list
     * @throws NoSuchElementException if the iteration has no previous
     *         element
     */
	
	Object previous();
	
	 /**
     * Replaces the last element returned by next() or
     * previous() with the specified element.
     *
     * @param e the element with which to replace the last element returned by
     *          next(} or previous()
     * @throws IllegalStateException if neither {@code next} nor
     *         {@code previous} have been called, or {@code remove} or
     *         {@code add} have been called after the last call to
     *         {@code next} or {@code previous}
     */
	void set(Object e); 
	
	
	 /**
     * Removes from the list the last element that was returned by link
     * next() or previous().  This call can
     * only be made once per call to next() or previous().
     * @throws IllegalStateException if neither next() nor
     *        previous() have been called, or remove() has been 
     *        called after the last call to next() or previous().
     */
	
	@Override
	void remove();
}