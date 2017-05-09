package de.hsMannheim.ib.tpe.ss17.gruppe22.myutil;

public class ArrayQueue implements Queue {

    Object[] q;
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

    @Override
    public void clear() {
        this.front = 0;
        this.end = 0;
        this.count = 0;
    }

    /**
     * @param el: The element that joins the queue.
     */
    @Override
    public void enter(Object el) {
        if (!isFull()) {
            this.q[this.end] = el;
            this.count++;

            if (this.end == (this.q.length - 1)) {
                this.end = 0;
            } else {
                this.end++;
            }

        }

        if (!expandable) { // Queue is full if this is asked
            System.out.println("Queue is full. We are sorry.");
        } else {
            expand();
        }
    }

    public void expand() {
        Object temp[] = new Object[this.q.length * 2];
        if (this.front != 0) {
            for (int i = this.front; i != 0; i++) {
                temp[this.q.length - this.front] = leave();
            }
        } else {
            for (int i = 0; !isEmpty(); i++) {
                temp[i] = leave();
            }
        }
        this.q = temp;
        expandable = false;
        System.out.println("Die Queue wurde erfolgreich vergrößert.");
    }

    /**
     * Returns an element and makes it exit the queue.
     *
     * @return the element at the front of the queue.
     */
    @Override
    public Object leave() throws NullPointerException {
        try {
            if (!isEmpty()) {
                this.count--;
                if (this.end != (this.front)) {
                    this.front += 1;
                    if (this.front >= this.q.length) {
                        this.front = 0;
                    }
                }
                return this.q[this.front];
            } else {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("leave() kann nicht auf eine leere Queue angewandt werden!");
            return null;
        }
    }

    @Override
    public Object peak() {
        return this.q[this.front];
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
