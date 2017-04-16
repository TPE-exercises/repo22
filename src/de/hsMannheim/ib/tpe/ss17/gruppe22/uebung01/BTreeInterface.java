package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung01;

public interface BTreeInterface {
	boolean insert(Integer o);

	boolean insert(String filename);

	boolean contains(Integer o);

	int size();

	int height();

	Integer getMax();

	Integer getMin();

	boolean isEmpty();

	boolean addAll(BTree otherTree);

	void printInorder();

	void printPostorder();

	void printPreorder();

	void printLevelorder();
}