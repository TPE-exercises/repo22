/*
 */
package de.hsMannheim.ib.tpe.ss17.gruppe22.myutil;

import de.hsMannheim.ib.tpe.ss17.gruppe22.exceptions.*;

/**
 *
 * @author Marco
 */
public class ArrayStack implements Stack {

    // Pointer shows on the currently highest element on the stack.
    int pointer = -1;
    boolean expandable = true;
    Object array[];

    public ArrayStack() {
        this.array = new Object[128];
    }

    public ArrayStack(int size) {
        this.array = new Object[size];
    }

    private int getPointer() {
        return this.pointer;
    }

    private void printStack() {
        for (int i = 0; i < this.array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(this.array[this.array.length - 1]);
    }

    private void showInformation() {
        System.out.println("Pointer: " + getPointer() + "; Expandable: " + this.expandable);
        printStack();
    }

    @Override
    public boolean isEmpty() {
        return this.pointer == -1;
    }

    @Override
    public int size() {
        return this.pointer + 1;
    }

    private void expand() {
        Object tempArray[] = new Object[this.array.length*2];
        for (int i = 0; i < this.array.length; i++) {
            tempArray[i] = this.array[i];
        }
        System.out.println("Die Größe des Stacks wurde verdoppelt.");
        this.array = tempArray;
        this.expandable = false;
    }

    @Override
    public void push(Object el) {
        try {
            if ((this.pointer + 1) == this.array.length) {
                if (expandable) {
                    expand();
                    showInformation();
                } else {
                    throw new OverflowException();
                }
            }
            this.pointer++;
            this.array[pointer] = el;
//            showInformation();
        } catch (OverflowException e) {
            System.out.println("**" + e + ": Es wird versucht auf einen vollen Stack zu pushen!");
//            showInformation();
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
            return temp;
        } catch (UnderflowException e) {
            System.out.println("**" + e + ": Ein leerer Stack kann nicht gepoppt werden!**");
            return null;
        } finally {
//            showInformation();
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
