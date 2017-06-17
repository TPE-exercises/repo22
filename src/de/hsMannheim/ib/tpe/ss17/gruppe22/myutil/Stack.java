/*
 */
package de.hsMannheim.ib.tpe.ss17.gruppe22.myutil;

import de.hsMannheim.ib.tpe.ss17.gruppe22.exceptions.*;

/**
 *
 * @author Marco
 */
public interface Stack {

    /**
     * Checks whether the stack is empty.
     *
     * @return Is the stack empty?
     */
    public boolean isEmpty();

    /**
     * Returns the amount of elements contained by the stack.
     *
     * @return the amount of elements contained by the stack.
     */
    public int size();

    /**
     * Pushes an element onto the stack.
     *
     * @param el the element to be pushed.
     */
    public void push(Object el);

    /**
     * Empties the stack.
     */
    public void clear();

    /**
     * Removes the very top element from the stack.
     *
     * @return the top element.
     */
    public Object pop();

    /**
     * Shows the very top element on the stack.
     *
     * @return the top element.
     */
    public Object peak();
}
