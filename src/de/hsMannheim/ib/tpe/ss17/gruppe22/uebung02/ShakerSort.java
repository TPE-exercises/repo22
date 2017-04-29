package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung02;

import static gdi.MakeItSimple.*;

public class ShakerSort {

	public static int swap = 0;
	public static int compare = 0;

	static void swap(int[] arrayOfNumbers, int i, int j) {
		// swapping i and j
		int t = arrayOfNumbers[i];
		arrayOfNumbers[i] = arrayOfNumbers[j];
		arrayOfNumbers[j] = t;
	}

	static void shakerSort(int[] arrayOfNumbers) {
		boolean swapped;
		int[] markers = new int[arrayOfNumbers.length];
		do {
			// resets markers
			for (int g = 0; g < arrayOfNumbers.length; g++) {
				markers[g] = 0;
			}
			swapped = false;
			int i;
			for (i = 0; i < arrayOfNumbers.length - 1; i++) {
				if (arrayOfNumbers[i] > arrayOfNumbers[i + 1]) {
					swap(arrayOfNumbers, i, i + 1);
					// marks swapped elements
					markers[i] = 1;
					markers[i + 1] = 1;
					swapped = true;
					swap++;
				}
				compare++;
			}

			// prints the array with markers and resets markers
			for (int g = 0; g < arrayOfNumbers.length; g++) {
				if (markers[g] == 1)
					print(arrayOfNumbers[g] + "*, ");
				else
					print(arrayOfNumbers[g] + ", ");
				markers[g] = 0;
			}
			println();
			if (swapped) {
				swapped = false;
				i--;
				// direction is changing (going back)
				for (; i >= 0; i--) {
					if (arrayOfNumbers[i] > arrayOfNumbers[i + 1]) {
						swap(arrayOfNumbers, i, i + 1);
						// marks swapped elements
						markers[i] = 1;
						markers[i + 1] = 1;
						swapped = true;
						swap++;
					}
					compare++;
				}
				// prints the array with markers
				for (int g = 0; g < arrayOfNumbers.length; g++) {
					if (markers[g] == 1)
						print(arrayOfNumbers[g] + "*, ");
					else
						print(arrayOfNumbers[g] + ", ");
				}
				println();
			}
		} while (swapped);
	}

	public static void main(String[] args) {

		int[] arrayOfNumbers = new int[2];

		for (int i = 0; i < arrayOfNumbers.length; i++) {
			arrayOfNumbers[i] = (int) Math.floor(Math.random() * 100 + 1);
		}
		for (int j = 0; j < arrayOfNumbers.length; j++)
			print(arrayOfNumbers[j] + ", ");
		println();
		shakerSort(arrayOfNumbers);
		println();
		println("Anzahl der Vergleiche: " + compare);
		println("Anzahl der Vertauschungen: " + swap);
	}
}
