package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung04;

import static gdi.MakeItSimple.*;

public abstract class QuickSort implements SortAlgorithm {

    public static int swap = 0;
    public static int compare = 0;
    public static int recursionSteps = -1;

    public int divide(Comparable[] array, int lowerBorder, int upperBorder) {
        int pivot = upperBorder;
        int index = lowerBorder;
        //looks for pivots final position by putting everything smaller (or even) than pivot on the left side
        //index remembers up to which point everything is smaller (or even) than pivot
        for (int pointer = index; pointer < upperBorder; pointer++) {
            if (array[pointer].compareTo(pivot) <= 0) {
                swap(array, index, pointer);
                if (index != pointer) {
                    swap++;
                }
                index++;
            }
            compare++;
        }
        //puts pivot on its final position
        swap(array, index, pivot);
        if (index != pivot) {
            swap++;
        }
        return index;
    }

    /**
     * Prints a complete array at a given point of time.
     *
     * @param array the array to be printed
     */
    public void printArray(Comparable[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            print(array[i] + ", ");
        }
        print(array[array.length - 1]);
        println();
    }

    @Override
    abstract public void sort(Comparable[]);
    
    /**
     * Swaps two elements from two given indices within an array.
     *
     * @param array the array whose elements shall be swapped
     * @param i index of the first element
     * @param j index of the second element
     */
    public void swap(Comparable[] array, int i, int j) {
        // swapping i and j
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void quickSort(Comparable[] array, int lowerBorder, int upperBorder) {
        recursionSteps++;
        if (lowerBorder < upperBorder) {
            int index = divide(array, lowerBorder, upperBorder);
            printArray(array);
            quickSort(array, lowerBorder, index - 1);
            quickSort(array, index + 1, upperBorder);

        }
    }

    public static void main(String[] args) {
        Integer[] arrayOfNumbers = new Integer[]{20, 16, 30, 12, 5};
//		int[] arrayOfNumbers = new int[5];
//		for (int i = 0; i < arrayOfNumbers.length; i++) {
//			arrayOfNumbers[i] = (int) Math.floor(Math.random() * 100 + 1);
//		}
        QuickSort mySorter = new QuickSortSeq();
        mySorter.printArray(arrayOfNumbers);
        mySorter.quickSort(arrayOfNumbers, 0, arrayOfNumbers.length - 1);

        println("Anzahl der Rekursionsschritte: " + recursionSteps);
        println("Anzahl der Vertauschungen: " + swap);
        println("Anzahl der Schlüsselvergleiche: " + compare);
    }

}
