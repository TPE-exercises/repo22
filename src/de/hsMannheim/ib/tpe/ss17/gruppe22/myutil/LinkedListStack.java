package de.hsMannheim.ib.tpe.ss17.gruppe22.myutil;

import de.hsMannheim.ib.tpe.ss17.gruppe22.exceptions.OverflowException;
import de.hsMannheim.ib.tpe.ss17.gruppe22.exceptions.UnderflowException;

public class LinkedListStack implements Stack{
	
	LinkedList stack;
	Node top;
	
	public LinkedListStack(){
		this.stack = new LinkedList();
		for (int i = 0; i < 20; i++){
			stack.addLast (null);
		}
		top = stack.head;
	}

	@Override
	public boolean isEmpty() {
		if (top == stack.head)
			return true;
		else
			return false;
	}

	@Override
	public int size() {
		Node counter = stack.head;
		int size = 0;
		while (counter != top){
			size++;
			counter = counter.getNext();
		}
		return size;
	}

	@Override
	public void push(Object el) {
		if (top.getNext() != null){
			top = top.getNext();
			top.setNode(el);
		}
		else
			throw new OverflowException();
	}

	@Override
	public void clear() {
		top = stack.head;
		
	}

	@Override
	public Object pop() {
		Object el;
		if (top != stack.head){
			el = top.getNode();
			top = stack.getPreviorNode(top);
		}
		else
			throw new UnderflowException();
		return el;
	}

	@Override
	public Object peak() {
		if (top != stack.head)
			return top.getNode();
		else
			throw new UnderflowException();
	}

}
