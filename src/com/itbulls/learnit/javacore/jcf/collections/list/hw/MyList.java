package com.itbulls.learnit.javacore.jcf.collections.list.hw;

public interface MyList extends Iterable<Object> {
	
    /**
     * Appends the specified element to the end of this list (optional
     * operation).
     *
     * @param e element to be appended to this list
     */
	 void add(Object e);
	 
	/**
	 * Removes all of the elements from this list.
	 * The list will be empty after this call returns.
	 */
	 void clear();
	 
	 
	/**
	 * Removes the first occurrence of the specified element from this list,
	 * if it is present.  If this list does not contain
	 * the element, it is unchanged. 
	 *
	 * @param o element to be removed from this list, if present
	 * @return true if this list contained the specified element
	 * @throws NullPointerException if the specified element is null and this
	 *         list does not permit null elements
	 */
	 boolean remove(Object o); 
	
	 
	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence (from first to last element).
	 * 
	 * This method acts as bridge between array-based and collection-based
	 * APIs.
	 *
	 * @return an array containing all of the elements in this list in proper
	 *         sequence
	 */
	 
	 Object[] toArray(); 
	
	 
	/**
	 * Returns the number of elements in this list.  If this list contains
	 * more than Integer.MAX_VALUE elements, returns
	 * Integer.MAX_VALUE.
	 *
	 * @return the number of elements in this list
	 */
	 int size();
	 
	/**
	 * Returns true if this list contains the specified element.
	 * More formally, returns true if and only if this list contains
	 * at least one element e such that.
	 *
	 * @param o element whose presence in this list is to be tested
	 * @return true if this list contains the specified element
	 * @throws NullPointerException if the specified element is null and this
	 *         list does not permit null elements
	 */
	 boolean contains(Object o); // returns true if this list contains the specified element.
	
	/**
	 * Returns true if this list contains all of the elements of the
	 * specified collection.
	 *
	 * @param  c object that implements MyList to be checked for containment in this list
	 * @return true if this list contains all of the elements of the
	 *         specified collection
	 * @throws NullPointerException if the specified collection contains one
	 *         or more null elements and this list does not permit null
	 *         elements
	 */
	 
	 boolean containsAll(MyList c); // returns true if this list contains all of the elements of the specified list
	}
