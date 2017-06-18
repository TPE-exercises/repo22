package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WordCount {

    HashMap wordMap;
    BufferedReader fileReader;
    // 4286435 is the length of the Bible.txt, 1178962 is the lenght of shakespeare.txt
    char[] textCharacters = new char[4286435];

    public WordCount(String fileToBeAnalyzed) throws IOException {
        this.wordMap = new HashMap<String, Integer>(65536);
        try {
            this.fileReader = new BufferedReader(new FileReader(fileToBeAnalyzed));
            fileReader.read(this.textCharacters);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WordCount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeReader() {
        try {
            fileReader.close();
        } catch (IOException ex) {
            Logger.getLogger(WordCount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Gets the length of the currently inserted textfile.
     *
     * @return returns the length of the textfile
     */
    public BigInteger getTextLength() {
        BigInteger sum = BigInteger.valueOf(0);

        try {
            this.fileReader.mark(0);
            // Calculates the file length.
            while (fileReader.read() != -1) {
                sum = sum.add(BigInteger.valueOf(1));
            }

            this.fileReader.reset();
        } catch (IOException ex) {
            Logger.getLogger(WordCount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sum;
    }

//    public void extractWords(char[] textCharacters) {
//        int index = 0;
//        String placeHolder = "";
//        while (index < textCharacters.length) {
//
//            // if the next sign of the textCharacters cannot be part of a word, it must recognize that the end of the word has been reached
//            if (textCharacters[index] == ' ' || textCharacters[index] == '.' || textCharacters[index] == ';' || textCharacters[index] == ':' || textCharacters[index] == '!' || textCharacters[index] == '?') {
//                wordMap.put(placeHolder);
//            }
//            //if (textCharacters[index] == '-')
//            placeHolder += textCharacters[index];
//            index++;
//        }
//    }
}
