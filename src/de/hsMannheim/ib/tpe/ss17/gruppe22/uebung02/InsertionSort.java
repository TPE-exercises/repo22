package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung02;

/**
 *
 * @author Marc, Marco
 */

public class InsertionSort implements Sortable {

    // counters of search
    private static int swap = 0;
    private static int compare = 0;

    // Insertion Sort with seqSearch
    @Override
    public void sortArray(Comparable[] array) {
        swap = 0;
        compare = 0;

        // goes through the whole array
        for (int i = 1; i < array.length; i++) {
            int j = i;
            Comparable marker = array[i];
            while (j > 0 && array[j - 1].compareTo(marker) == 1) {
                array[j] = array[j - 1];
                j--;
                compare++;
                swap++;
            }

            array[j] = marker;
            // add only if swapped
            if (j != i) {
                swap++;
            }
            for (Comparable array1 : array) {
                System.out.print(array1 + ", ");
            }
            System.out.println();
        }
        System.out.println("Anzahl der Vergleiche in InsertionSort (standard) im Array der Länge " + array.length + ": "
                + compare);
        System.out.println("Anzahl der Vertauschungen in InsertionSort (standard) im Array der Länge " + array.length + ": "
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
        (new InsertionSort()).sortArray(array);

        System.out.println();
        // reseting all the values because of repeating

    }

}
