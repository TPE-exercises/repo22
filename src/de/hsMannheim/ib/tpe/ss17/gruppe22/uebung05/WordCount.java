package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class WordCount {

    Hashtable hashtable;
    BufferedReader bufferedReader;
    // 4286435 is the length of the Bible.txt, 1178962 is the length of shakespeare.txt

    private Character alphabet[] = new Character[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
        'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'Ä', 'Ö', 'Ü', 'ä', 'ö',
        'ü', 'ß'};

    public WordCount(String fileToBeAnalyzed) throws IOException {
        try {
            this.bufferedReader = new BufferedReader(new FileReader(fileToBeAnalyzed));
            this.hashtable = new Hashtable<String, Integer>();
            extractWords();
            listWordsByFrequencyDescending(100);
            closeReader();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WordCount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Closes the reader which was opened upon initalizing an object of this
     * class WordCount.
     */
    protected void closeReader() {
        try {
            bufferedReader.close();
        } catch (IOException ex) {
            Logger.getLogger(WordCount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Reads a text file and spots each single word in there. Words are Strings,
     * that only consist of letters. These words will be saved into a hashtable.
     *
     * Here, Words are not case sensitive, they will all be treated as if they
     * were written with small letters only.
     */
    public void extractWords() {
        try {
//            System.out.println("bufferedReader.ready() " + bufferedReader.ready());
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
//                System.out.println("bufferedReader.readLine()" + line);
                if (line != null) {
                    extractWordsFromLine(line);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(WordCount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Extracts the words from a text line and saves them into the hashtable of
     * WordCount.
     *
     * Here, Words are not case sensitive, they will all be treated as if they
     * were written with small letters only.
     *
     * @param line the line of text to be analyzed.
     */
    public void extractWordsFromLine(String line) {
        int lineLength = line.length();
        int lineIndex = 0;
        boolean wordInExamination = true;
        String nextWord = "";
        while (lineIndex < lineLength) {

            int alphabetIndex = 0;
            boolean charFound = false;
            // Checks whether the current symbol is a letter from the alphabet.
            while (alphabetIndex < this.alphabet.length && !charFound) {
                if (alphabet[alphabetIndex].equals(line.charAt(lineIndex))) {
                    nextWord += line.charAt(lineIndex);
                    charFound = true;
                }
                alphabetIndex++;
                // The current symbol is none of the alphabet
                if ((alphabetIndex == this.alphabet.length && !charFound) || lineIndex == lineLength - 1) {
                    wordInExamination = false;
                }
            }

            if (nextWord.length() != 0 && !wordInExamination) {
                nextWord = nextWord.toLowerCase();
                if (this.hashtable.get(nextWord) == null) {
                    // inserts a word for its first time
                    this.hashtable.put(nextWord, 1);
                } else {
                    // Increases the count of this word being found in the text
                    Integer number = (Integer) this.hashtable.get(nextWord);
                    number = number + 1;
                    this.hashtable.put(nextWord, number);
                }
                nextWord = "";

            }
            wordInExamination = true;
            lineIndex++;
        }
    }

    /**
     * Lists up to X amount of words currently saved in the hashtable of
     * WordCount sorted by frequency, descending.
     *
     * @param topNumbersShown the amount of elements which shall be shown.
     */
    public void listWordsByFrequencyDescending(int topNumbersShown) {
        sortValuesReverse(hashtable, topNumbersShown);
    }

    /**
     * Sorts a hashtable by values (using an arraylist), then reverses the
     * order. Then prints the first X elements (which is specified by the second
     * parametre) on the console.
     *
     * @param t the hashtable which contains the elements which shall be listed.
     * @param topNumbersShown the amount of elements which shall be shown.
     */
    private void sortValuesReverse(Hashtable<?, Integer> t, int topNumbersShown) {
        // Previously used code
//        SortedSet<KeyValuePair> sortedSet = new TreeSet<KeyValuePair>();
//        ArrayList<Map.Entry<?, Integer>> list = new ArrayList(t.entrySet());
//        Collections.sort(list, new Comparator<Map.Entry<?, Integer>>() {
//            @Override
//            public int compare(Map.Entry<?, Integer> o1, Map.Entry<?, Integer> o2) {
//                return o1.getValue().compareTo(o2.getValue());
//            }
//        });
//        System.out.println("Schema: <Wort>=<Anzahl seines Vorkommens>");
//        Collections.reverse(list);
//        Iterator it;
//        it = list.listIterator();
//        while (it.hasNext() && topNumbersShown > 0) {
//            System.out.println(it.next());
//            topNumbersShown--;
//        }
        SortedSet<KeyValuePair> sortedSet = new TreeSet<KeyValuePair>();
        Enumeration values = hashtable.elements();
        Enumeration keys = hashtable.keys();
        while (values.hasMoreElements() && keys.hasMoreElements()) {
            sortedSet.add(new KeyValuePair((String) keys.nextElement(), (Integer) values.nextElement()));
        }
        Iterator it = sortedSet.iterator();
        int i = 0;
        while (it.hasNext() && i < topNumbersShown) {
            System.out.println(it.next());
            topNumbersShown--;
        }
        System.out.println();
    }

    private static class KeyValuePair implements Comparable<KeyValuePair> {

        String key;
        Integer value;

        public KeyValuePair(String key, Integer value) {
            super();
            this.key = key;
            this.value = value;
        }

        /**
         * This method was specially designed for WordCount. The Integer value
         * has highest priority, thus is compared first. Pairs shall also be
         * sorted descending by values, thus returning 1 if a Pair has a smaller
         * value than another one, respectively -1 if it has a greater value 
         * than another one.
         * As normally, pairs shall be sorted ascending by key value.
         * @param o the Pair to be made a comparison with.
         * @return The answer to whether to rank this pair higher, as of 1, or
         * lower, as of -1, than the one compared with.
         */
        @Override
        public int compareTo(KeyValuePair o) {
            if (this.value.compareTo(o.value) < 0) {
                return 1;
            } else if (this.value.compareTo(o.value) > 0) {
                return -1;
            } else { // values are equal
                if (this.key.compareToIgnoreCase(o.key) < 0) {
                    return -1;
                } else if (this.key.compareToIgnoreCase(o.key) > 0) {
                    return 1;
                } else { // keys are equal, too
                    return 0;
                }
            }
        }

        @Override
        public String toString() {
            return this.key + "=" + this.value;
        }
    }
        public static void main(String[] args) {
        long time = System.currentTimeMillis();
        try {
            WordCount wordcountExample = new WordCount("C:\\Users\\Marco\\Desktop\\Hochschule Mannheim\\TPE\\Übung 5 - Collections\\Bibel.txt");
            wordcountExample = new WordCount("C:\\Users\\Marco\\Desktop\\Hochschule Mannheim\\TPE\\Übung 5 - Collections\\testfile.txt");
            wordcountExample = new WordCount("C:\\Users\\Marco\\Desktop\\Hochschule Mannheim\\TPE\\Übung 5 - Collections\\shakespeare.txt");
        } catch (IOException ex) {
            Logger.getLogger(WordCount.class.getName()).log(Level.SEVERE, null, ex);
        }
        time = System.currentTimeMillis() - time;
        System.out.println("Benötigte Zeit (in ms): " + time);
    }
}
