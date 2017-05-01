package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung02;

public interface Sortable {
	public static void sortArray(Sortable sortierverfahren, Comparable[] array) {
		sortierverfahren.sortArray(array);
	}
	public void sortArray(Comparable[] array);
}
