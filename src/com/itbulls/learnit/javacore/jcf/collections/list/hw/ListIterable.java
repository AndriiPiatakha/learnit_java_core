package com.itbulls.learnit.javacore.jcf.collections.list.hw;

/**
 * Implementing this interface allows an object to returns
 * object of ListIterator.
 * 
 * @author Andrii Piatakha
 *
 */

public interface ListIterable {
	
	/**
	 * Returns object of ListIterator.
	 * 
	 * @return object of ListIterator
	 */
	ListIterator listIterator();
}
