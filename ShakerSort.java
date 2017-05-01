package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung02;

import static gdi.MakeItSimple.*;

public class ShakerSort implements Sortable {

	private static int swap = 0;
	private static int compare = 0;

	static void swap(Comparable[] array, int i, int j) {
		// swapping i and j
		Comparable t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
	private void resetSwaps() {
		this.swap = 0;
	}
	private void resetComparisons() {
		this.compare = 0;
	}
	public int getSwaps() {
		return this.swap;
	}
	public int getComparisons() {
		return this.compare;
	}
	public void sortArray(Comparable[] array) {
		resetSwaps();
		resetComparisons();
		boolean swapped;
		int[] markers = new int[array.length];
		do {
			// resets markers
			for (int g = 0; g < array.length; g++) {
				markers[g] = 0;
			}
			swapped = false;
			int i;
			for (i = 0; i < array.length - 1; i++) {
				if (array[i].compareTo(array[i + 1]) == 1) {
					swap(array, i, i + 1);
					// marks swapped elements
					markers[i] = 1;
					markers[i + 1] = 1;
					swapped = true;
					swap++;
				}
				compare++;
			}

			// prints the array with markers and resets markers
			for (int g = 0; g < array.length; g++) {
				if (markers[g] == 1)
					print(array[g] + "*, ");
				else
					print(array[g] + ", ");
				markers[g] = 0;
			}
			println();
			if (swapped) {
				swapped = false;
				i--;
				// direction is changing (going back)
				for (; i >= 0; i--) {
					if (array[i].compareTo(array[i + 1]) == 1) {
						swap(array, i, i + 1);
						// marks swapped elements
						markers[i] = 1;
						markers[i + 1] = 1;
						swapped = true;
						swap++;
					}
					compare++;
				}
				// prints the array with markers
				for (int g = 0; g < array.length; g++) {
					if (markers[g] == 1)
						print(array[g] + "*, ");
					else
						print(array[g] + ", ");
				}
				println();
			}
		} while (swapped);
		println("Anzahl der Vergleiche: " + compare);
		println("Anzahl der Vertauschungen: " + swap);
	}

	public static void main(String[] args) {

		Comparable[] array = new Comparable[9];
		//Only MyInts
//		array[0] = new MyInt(5);
//		array[1] = new MyInt(2);
		
		// Only MyStrings
//		array[0] = new MyString("Paulus");
//		array[1] = new MyString("Anna");

		array[0] = new MyString("Quacker");
		array[1] = new MyInt(72);
		array[2] = new MyInt(-1);
		array[3] = new MyString("Duck");
		array[4] = new MyString("Ben");
		array[5] = new MyString("zielgerichtet");
		array[6] = new MyString("Zutaten");
		array[7] = new MyInt(20);
		array[8] = new MyString("yopta");
		for (int j = 0; j < array.length; j++)
			print(array[j] + ", ");
		println();
		(new ShakerSort()).sortArray(array);
		println();
	}
}
