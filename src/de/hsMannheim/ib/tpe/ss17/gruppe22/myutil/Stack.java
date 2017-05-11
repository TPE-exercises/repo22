/*
 */
package de.hsMannheim.ib.tpe.ss17.gruppe22.myutil;

import de.hsMannheim.ib.tpe.ss17.gruppe22.exceptions.*;

/**
 *
 * @author Marco
 */
public interface Stack {

    public boolean isEmpty();

    public int size();

    public void push(Object el);

    public void clear();

    public Object pop();

    public Object peak();
}
