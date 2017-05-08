package de.hsMannheim.ib.tpe.ss17.gruppe22.myutil;

public interface Queue {
	public boolean isEmpty();
	public int size();
	public void enter(Object el);
	public void clear();
	public Object leave();
	public Object peak();
}
