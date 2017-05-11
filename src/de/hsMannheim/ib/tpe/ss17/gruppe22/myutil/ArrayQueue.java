package de.hsMannheim.ib.tpe.ss17.gruppe22.myutil;

import de.hsMannheim.ib.tpe.ss17.gruppe22.exceptions.*;

public class ArrayQueue implements Queue {

    private Object[] q;
    private int front = 0;
    private int end = 0;
    private int count = 0;
    private boolean expandable = true;

    public ArrayQueue() {
        this.q = new Object[16384];
    }

    public ArrayQueue(int length) {
        this.q = new Object[length];
    }

    public int getFront() {
        return this.front;
    }

    public int getEnd() {
        return this.end;
    }

    public int getCount() {
        return this.count;
    }

    /**
     * Shows valuable information for programmers and testers in the console if
     * called in the right moments.
     */
    private void printQueue() {
        for (int i = 0; i < this.q.length - 1; i++) {
            System.out.print(this.q[i] + ", ");
        }
        System.out.println(this.q[this.q.length - 1]);
    }

    /**
     * Shows valuable information for programmers and testers in the console if
     * called in the right moments.
     */
    private void showInformation() {
        System.out.println("Front: " + getFront() + "; End: " + getEnd() + "; Count: " + getCount());
        printQueue();
    }

    @Override
    public void clear() {
        this.front = 0;
        this.end = 0;
        this.count = 0;
    }

    /**
     * Adds an object at the end of the queue.
     *
     * @param el: The element that joins the queue.
     */
    @Override
    public void enter(Object el) {
        try {
            if (!isFull()) {
                if (this.end == (this.q.length)) {
                    this.end = 0;
                }
                this.q[this.end] = el;
                this.count++;

                this.end++;

            } else if (expandable) {
                expand();
                enter(el);
            } else {
                throw new OverflowException();
            }
        } catch (OverflowException e) {
            System.out.println("**" + e + ": Enter wird auf eine volle Queue angewandt!**");

        }
        showInformation();
    }

    /**
     * Expands the size of the queue by doubling its array size. This can only
     * occur once.
     */
    private void expand() {
        Object temp[] = new Object[this.q.length * 2];
        int tempCount = this.count;
        int tempFront = this.front;
        if (this.front != 0) {
            while (this.front >= this.end) {
                temp[this.q.length + this.front] = leave();
            }
            for (int i = 0; i < this.end; i++) {
                temp[i] = leave();
            }
            this.front = tempFront + this.q.length;
        } else {
            for (int i = 0; !isEmpty(); i++) {
                temp[i] = leave();
            }
            this.front = 0;
        }
        this.count = tempCount;

        this.q = temp;
        this.expandable = false;
        System.out.println("Die Queue wurde expandiert.");
    }

    /**
     * Returns an element and makes it exit the queue.
     *
     * @return the element at the front of the queue.
     */
    @Override
    public Object leave() {
        Object temp;
        try {
            temp = givePeakElement();
        } catch (UnderflowException e) {
            System.out.println("**" + e + ": leave() kann nicht auf eine leere Queue angewandt werden!**");
            showInformation();
            return null;
        }
        if (!isEmpty()) {

            this.front += 1;
            if (this.front == this.q.length) {
                this.front = 0;
            }
            this.count--;
        }
        showInformation();
        return temp;
    }

    private Object givePeakElement() throws UnderflowException {
        if (!isEmpty()) {
            return this.q[this.front];
        } else {
            throw new UnderflowException();
        }
    }

    @Override
    public Object peak() {
        try {
            return givePeakElement();
        } catch(UnderflowException e) {
            System.out.println("**" + e + ": Es sind keine Elemente in der Queue!**");
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    public boolean isFull() {
        return this.count == this.q.length;
    }

    /**
     *
     * @return The amount of elements currently in the queue
     */
    @Override
    public int size() {
        return this.count;
    }
}
