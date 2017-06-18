package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung05;

import java.util.*;

import de.hsMannheim.ib.tpe.ss17.gruppe22.myutil.ArrayStack;

public class BTreeIterator implements Iterator {
	
	BTree tree;
	Comparable[] elements;
	int pos;
	
	public BTreeIterator (BTree tree){
		this.tree = tree;
		pos = -1;
		elements = tree.getRoot().getAll();
	}


	@Override
	public boolean hasNext() {
		return pos < elements.length - 1;
	}

	@Override
	public Object next() {
		pos++;
		return elements[pos];
	}
	
	@Override
	public void remove(){
		tree.removeElement(elements[pos]);
	}

}
