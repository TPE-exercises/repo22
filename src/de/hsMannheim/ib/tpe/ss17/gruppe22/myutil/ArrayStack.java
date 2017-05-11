/*
 */
package de.hsMannheim.ib.tpe.ss17.gruppe22.myutil;

import de.hsMannheim.ib.tpe.ss17.gruppe22.exceptions.*;

/**
 *
 * @author Marco
 */
public class ArrayStack implements Stack {

    int pointer = -1;
    boolean expandable = true;
    Object array[];

    private int getPointer() {
        return this.pointer;
    }

    private void printStack() {
        for (int i = 0; i < this.array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(this.array[this.array.length]);
    }

    private void showInformation() {

    }

    public ArrayStack() {
        this.array = new Object[128];
    }

    public ArrayStack(int size) {
        this.array = new Object[size];
    }

    @Override
    public boolean isEmpty() {
        return this.pointer == -1;
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void expand() {

    }

    @Override
    public void push(Object el) {
        try {
            if ((this.pointer + 1) == this.array.length) {
                if (expandable) {
                    expand();
                } else {
                    throw new OverflowException();
                }
            }
            this.pointer++;
            this.array[pointer] = el;
        } catch (OverflowException e) {
            System.out.println("**" + e + ": Es wird versucht auf einen vollen Stack zu pushen!");
        }
    }

    @Override
    public void clear() {
        this.pointer = -1;
    }

    @Override
    public Object pop() {
        try {
            Object temp = givePeakElement();
            this.pointer--;
            showInformation();
            return temp;
        } catch (UnderflowException e) {
            System.out.println("**" + e + ": Ein leerer Stack kann nicht gepoppt werden!**");
            showInformation();
            return null;
        }
    }

    private Object givePeakElement() throws UnderflowException {
        if (!isEmpty()) {
            return array[this.pointer];
        } else {
            throw new UnderflowException();
        }
    }

    @Override
    public Object peak() {
        try {
            return givePeakElement();
        } catch (UnderflowException e) {
            System.out.println("**" + e + ": Es liegen keine Elemente auf dem Stack!**");
            return null;
        }
    }
}
