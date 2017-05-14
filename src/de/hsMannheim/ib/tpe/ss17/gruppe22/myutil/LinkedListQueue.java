package de.hsMannheim.ib.tpe.ss17.gruppe22.myutil;

import de.hsMannheim.ib.tpe.ss17.gruppe22.exceptions.OverflowException;
import de.hsMannheim.ib.tpe.ss17.gruppe22.exceptions.UnderflowException;

public class LinkedListQueue implements Queue{
	
	LinkedList queue;
	Node read;
	Node write;
	
	public LinkedListQueue(){
		this.queue = new LinkedList();
		for (int i = 0; i < 20; i++){
			queue.addLast (null);
		}
		Node last = queue.getLast();
		last.setNext(queue.head);
		read = queue.head;
		write = queue.head;
	}

	@Override
	public boolean isEmpty() {
		return read == write;
	}

	@Override
	public int size() {
		int size = 0;
		Node readCopy = read;
		while (write != readCopy){
			readCopy = readCopy.getNext();
			size++;
		}
			
		return size;
	}

	@Override
	public void enter(Object el) {
		if (write.getNext() != read){
			write.setNode(el);
			write = write.getNext();
		}
		else
			throw new OverflowException();
		
	}

	@Override
	public void clear() {
		read = queue.head;
		write = queue.head;
		
	}

	@Override
	public Object leave() {
		Object el;
		if (read != write){
			el = read.getNode();
			read = read.getNext();
		}
		else
			throw new UnderflowException();
		return el;
	}

	@Override
	public Object peak() {
		if (read != write)
			return read.getNode();
		else
			throw new UnderflowException();
	}

}
