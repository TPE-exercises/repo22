/*
 */
package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung04;

public class QuickSortSeq extends QuickSort {

    /**
     * Sorts an array using quick sort.
     *
     * @param array the array to be sorted.
     */
    @Override
    public void sort(Comparable[] array) {
        quickSort(array, 0, array.length - 1);

    }
}
