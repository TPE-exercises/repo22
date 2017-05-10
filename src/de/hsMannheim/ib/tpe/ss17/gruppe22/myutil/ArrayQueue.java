package de.hsMannheim.ib.tpe.ss17.gruppe22.myutil;

public class ArrayQueue implements Queue {

    private Object[] q;
    private int front = 0;
    private int end = 0;
    private int count = 0;
    private boolean expandable = true;

    public int getFront() {
        return this.front;
    }

    public int getEnd() {
        return this.end;
    }

    public int getCount() {
        return this.count;
    }

    public void showInformation() {
        System.out.println("Front: " + getFront() + "; End: " + getEnd() + "; Count: " + getCount());
    }

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
            System.out.println("Queue is full. We are sorry.");
        }
    }

    public void expand() {
        Object temp[] = new Object[this.q.length * 2];
        int tempCount = this.count;
        int tempFront = this.front;
        if (this.front != 0) {
            /**
             * TODO: Implement Correctly / Correct this
             */
            for (int i = this.front; i <= this.q.length; i++) {
                temp[temp.length - this.q.length + this.front] = leave();
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
            temp = GiveFront();
        } catch (NullPointerException e) {
            System.out.println("**Fehler: leave() kann nicht auf eine leere Queue angewandt werden!**");
            return null;
        }
        if (!isEmpty()) {

            this.front += 1;
            if (this.front >= this.q.length) {
                this.front = 0;
            }
            this.count--;
        }
        return temp;
    }

    public Object GiveFront() throws NullPointerException {
        if (!isEmpty()) {
            return this.q[this.front];
        } else {
            throw new NullPointerException();
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

