package de.hsMannheim.ib.tpe.ss17.gruppe23.uebung05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class WordCount {

    Hashtable hashtable;
    BufferedReader bufferedReader;
    // 4286435 is the length of the Bible.txt, 1178962 is the lenght of shakespeare.txt

    private Character alphabet[] = new Character[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
        'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'Ä', 'Ö', 'Ü', 'ä', 'ö',
        'ü'};

    public WordCount(String fileToBeAnalyzed) throws IOException {
        try {
            this.bufferedReader = new BufferedReader(new FileReader(fileToBeAnalyzed));
            this.hashtable = new Hashtable<String, Integer>();
            extractWords();
            listWordsByFrequencyDescending();
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
            // System.out's for observation purposes
            System.out.println("bufferedReader.ready() " + bufferedReader.ready());
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                System.out.println("bufferedReader.readLine()" + line);
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
        while (lineIndex < lineLength && wordInExamination) {

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
                if (alphabetIndex == this.alphabet.length) {
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
                wordInExamination = true;
            }
            lineIndex++;
        }
    }

    /**
     * Lists all the words currently saved in the hashtable of WordCount sorted
     * by frequency, descending.
     */
    //TODO: Implement
    public void listWordsByFrequencyDescending() {
        Enumeration e = hashtable.keys();
        Enumeration f = hashtable.elements();
        Integer maxValue = 0;
        SortedDictionary<String, Integer> dict = new SortedDictionary<String, Integer>();
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement() + " " + f.nextElement());
        }
    }

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        try {
            WordCount wordcountExample = new WordCount("C:\\Users\\Marco\\Desktop\\Hochschule Mannheim\\TPE\\Übung 5 - Collections\\Bibel.txt");
        } catch (IOException ex) {
            Logger.getLogger(WordCount.class.getName()).log(Level.SEVERE, null, ex);
        }
        time = System.currentTimeMillis() - time;
        System.out.println("Benötigte Zeit (in ms): " + time);
    }
}
