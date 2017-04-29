package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung02;

import static gdi.MakeItSimple.*;

public class InsertionSort {

	// counters of standard sequence search
	public static int swapSeq = 0;
	public static int compareSeq = 0;
	// counters of binary sequence search
	public static int swapBinary = 0;
	public static int compareBinary = 0;

	// Insertion Sort with seqSearch
	static void insertionSort(int[] arrayOfNumbers) {
		// goes through the whole array
		for (int i = 1; i < arrayOfNumbers.length; i++) {
			int j = i;
			int marker = arrayOfNumbers[i];
			while (j > 0 && arrayOfNumbers[j - 1] > marker) {
				arrayOfNumbers[j] = arrayOfNumbers[j - 1];
				j--;
				compareSeq++;
				swapSeq++;
			}
			arrayOfNumbers[j] = marker;
			// add only if swapped
			if (j != i)
				swapSeq++;
		}
	}

	static int binarySearchIt(int[] arrayOfNumbers, int key, int end) {
		int start = 0;
		while (start <= end) {
			int mid = (start + end) / 2;
			// If key is already in the middle
			if (arrayOfNumbers[mid] == key) {
				compareBinary++;
				return mid;
			} else if (key < arrayOfNumbers[mid])
				// Search before the middle
				end = mid - 1;
			else
				// Search after the middle
				start = mid + 1;
			// add 2 because comparison is made every time
			compareBinary += 2;
		}
		return start;
	}

	static void insertionSortBinary(int[] arrayOfNumbers) {
		for (int i = 1; i < arrayOfNumbers.length; i++) {
			int j = i;
			int marker = arrayOfNumbers[i];
			// searches the index through binary search method
			int insertAt = binarySearchIt(arrayOfNumbers, marker, j);
			while (j > insertAt) {
				arrayOfNumbers[j] = arrayOfNumbers[j - 1];
				swapBinary++;
				j--;
			}
			arrayOfNumbers[j] = marker;
			swapBinary++;
		}
	}

	public static void main(String[] args) {
		int arraySize = 1;

		// 3 times -> 1024, 2048, 4096 (duplicates each time)
		for (int f = 0; f < 3; f++) {
			int[] arrayOfNumbers = new int[arraySize];
			for (int i = 0; i < arraySize; i++) {
				arrayOfNumbers[i] = (int) Math.floor(Math.random() * arraySize + 1);
			}
			int[] arrayOfNumbers2 = new int[arraySize];
			for (int i = 0; i < arraySize; i++) {
				arrayOfNumbers2[i] = arrayOfNumbers[i];
			}
			insertionSortBinary(arrayOfNumbers);
			insertionSort(arrayOfNumbers2);

			println("Anzahl der Vertauschungen in InsertionSort (standard) im Array der Länge " + arraySize + ": "
					+ swapSeq);
			println("Anzahl der Vertauschungen in InsertionSort (binäre Suche) im Array der Länge " + arraySize + ": "
					+ swapBinary);
			println("Anzahl der Vergleiche in InsertionSort (standard) im Array der Länge " + arraySize + ": "
					+ compareSeq);
			println("Anzahl der Vergleiche in InsertionSort (binäre Suche) im Array der Länge " + arraySize + ": "
					+ compareBinary);
			println();
			arraySize = 2 * arraySize;
			// reseting all the values because of repeating
			swapSeq = 0;
			swapBinary = 0;
			compareSeq = 0;
			compareBinary = 0;
		}

	}
}