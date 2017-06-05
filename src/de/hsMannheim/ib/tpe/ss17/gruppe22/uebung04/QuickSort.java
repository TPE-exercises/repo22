package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung04;

public abstract class QuickSort implements SortAlgorithm {

    public static int swap = 0;
    public static int compare = 0;
    public static int recursionSteps = -1;

    /**
     * TODO: Update Comment Splits the given range of the array in two parts
     *
     * @param array
     * @param lowerBorder
     * @param upperBorder
     * @return
     */
    public int divide(Comparable[] array, int lowerBorder, int upperBorder) {
        int pivotPos = upperBorder;
        int index = lowerBorder;
        //looks for pivots final position by putting everything smaller (or even) than pivot on the left side
        //index remembers up to which point everything is smaller (or even) than pivot
        for (int pointer = index; pointer < upperBorder; pointer++) {
            if (array[pointer].compareTo(array[pivotPos]) <= 0) {
                swap(array, index, pointer);
                if (index != pointer) {
                    synchronized (this) {
                        swap++;
                    }
                }
                index++;
            }
            synchronized (this) {
                compare++;
            }
        }
        //puts pivot on its final position
        swap(array, index, pivotPos);
        if (index != pivotPos) {
            synchronized (this) {
                swap++;
            }
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
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[array.length - 1]);
        System.out.println();
    }

    /**
     * Applies quick sort on a partial array, thus sorting it.
     *
     * @param array the array which contains the array part which shall be
     * sorted
     * @param lowerBorder defines the partial array together with upperBorder
     * @param upperBorder defines the partial array together with lowerBorder
     */
    public void quickSort(Comparable[] array, int lowerBorder, int upperBorder) {
        recursionSteps++;
        if (lowerBorder < upperBorder) {
            int index = divide(array, lowerBorder, upperBorder);
            //printArray(array);
            quickSort(array, lowerBorder, index - 1);
            quickSort(array, index + 1, upperBorder);

        }
    }

    /**
     * Sorts an array using quick-sort.
     *
     * @param array the array to be sorted
     */
    @Override
    abstract public void sort(Comparable[] array);

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

    /**
     * resets stats for observation purposes.
     */
    public void resetStats() {
        recursionSteps = -1;
        swap = 0;
        compare = 0;
    }

    public static void main(String[] args) {
        System.out.println("Parallel:");
        Integer[] arrayOfNumbers = new Integer[]{20, 16, 30, 12, 5, 80, 45, 1, 48, 75, 46, 78, 95, 125, 100, 99};

        QuickSort mySorter = new QuickSortPar(arrayOfNumbers, 0, arrayOfNumbers.length - 1);
        mySorter.printArray(arrayOfNumbers);
        double startTime = System.currentTimeMillis();
        mySorter.sort(arrayOfNumbers);
        double endTime = System.currentTimeMillis();
        mySorter.printArray(arrayOfNumbers);

        //System.out.println("Anzahl der Rekursionsschritte: " + recursionSteps);
        System.out.println("Anzahl der Vertauschungen: " + swap);
        System.out.println("Anzahl der Schlüsselvergleiche: " + compare);
        System.out.println("Anzahl der Threads: " + QuickSortPar.numberOfThreads);
        System.out.println("Vergangene Zeit: " + (endTime - startTime));
        System.out.println("");

        mySorter.resetStats();

        System.out.println("Sequentiell:");
        arrayOfNumbers = new Integer[]{20, 16, 30, 12, 5, 80, 45, 1, 48, 75, 46, 78, 95, 125, 100, 99};
        mySorter = new QuickSortSeq();
        mySorter.printArray(arrayOfNumbers);
        startTime = System.currentTimeMillis();
        mySorter.sort(arrayOfNumbers);
        endTime = System.currentTimeMillis();
        mySorter.printArray(arrayOfNumbers);

        System.out.println("Anzahl der Rekursionsschritte: " + recursionSteps);
        System.out.println("Anzahl der Vertauschungen: " + swap);
        System.out.println("Anzahl der Schlüsselvergleiche: " + compare);
        System.out.println("Vergangene Zeit: " + (endTime - startTime));
    }

}
