package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung04;

public class QuickSortPar extends QuickSort implements Runnable {
	public static int numberOfThreads = 1;
	int upperBorder;
	int lowerBorder;
	Comparable[] array;
	
	public QuickSortPar (Comparable[] array, int lowerBorder, int upperBorder){
		this.array = array;
		this.lowerBorder = lowerBorder;
		this.upperBorder = upperBorder;
	}

	@Override
	public void run() {
		quickSort(array, lowerBorder, upperBorder);

	}

	/**
         * Sorts an array part using the quick sort algorithm aswell as threads to 
         * sort partial arrays.
         * @param array the array which contains the part that shall be sorted.
         * @param lowerBorder defines the array part together with upperBorder.
         * @param upperBorder defines the array part together with lowerBorder.
         */
	@Override
	public void quickSort(Comparable[] array, int lowerBorder, int upperBorder) {
		synchronized (this) {recursionSteps++;}
		if (lowerBorder < upperBorder) {
			int index = divide(array, lowerBorder, upperBorder);
			//printArray(array);
			Thread leftThread = new Thread(new QuickSortPar(array, lowerBorder, index - 1));
			leftThread.start();
			synchronized (this) {numberOfThreads++;}
			Thread rightThread = new Thread(new QuickSortPar(array, index + 1, upperBorder));
			rightThread.start();
			synchronized (this) {numberOfThreads++;}
			
			try{
			rightThread.join();
			}catch (InterruptedException e){
				throw new IllegalStateException("Parallel quicksort threw an InterruptedException.");
			}
			try{
			leftThread.join();
			}catch (InterruptedException e){
				throw new IllegalStateException("Parallel quicksort threw an InterruptedException.");
			}
		}
	}
	/**
	 * Sorts an array using quicksort.
	 * @param array the array to be sorted
	 */
	@Override
	public void sort(Comparable[] array) {
		quickSort(array, 0, array.length - 1);

	}

}

