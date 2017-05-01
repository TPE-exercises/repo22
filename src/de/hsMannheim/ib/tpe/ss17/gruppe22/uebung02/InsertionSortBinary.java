package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung02;

/**
 *
 * @author Marc, Marco
 */
public class InsertionSortBinary implements Sortable {
    private static int swap = 0;
    private static int compare = 0;
    static int binarySearchIt(Comparable[] arrayOfNumbers, Comparable key, int end) {
        int start = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            // If key is already in the middle
            if (arrayOfNumbers[mid].compareTo(key) == 0) {
                compare++;
                return mid;
            } else if (key.compareTo(arrayOfNumbers[mid]) == -1) // Search before the middle
            {
                end = mid - 1;
            } else // Search after the middle
            {
                start = mid + 1;
            }
            // add 2 because comparison is made every time
            compare += 2;
        }
        return start;
    }

    @Override
    public void sortArray(Comparable[] array) {
        compare = 0;
        swap = 0;
        for (int i = 1; i < array.length; i++) {
            int j = i;
            Comparable marker = array[i];
            // searches the index through binary search method
            int insertAt = binarySearchIt(array, marker, j);
            while (j > insertAt) {
                array[j] = array[j - 1];
                swap++;
                j--;
            }
            array[j] = marker;
            swap++;
            for (Comparable array1 : array) {
                System.out.print(array1 + ", ");
            }
            System.out.println();
        }
        System.out.println("Anzahl der Vergleiche in InsertionSort (binäre Suche) im Array der Länge " + array.length + ": "
                + compare);
        System.out.println("Anzahl der Vertauschungen in InsertionSort (binäre Suche) im Array der Länge " + array.length + ": "
                + swap);

    }

    public static void main(String[] args) {
        Comparable[] array = new Comparable[9];
        array[0] = new MyString("Quacker");
        array[1] = new MyInt(72);
        array[2] = new MyInt(-1);
        array[3] = new MyString("Duck");
        array[4] = new MyString("Ben");
        array[5] = new MyString("zielgerichtet");
        array[6] = new MyString("Zutaten");
        array[7] = new MyInt(20);
        array[8] = new MyString("yopta");
        (new InsertionSortBinary()).sortArray(array);

        System.out.println();
        // reseting all the values because of repeating

    }

}
