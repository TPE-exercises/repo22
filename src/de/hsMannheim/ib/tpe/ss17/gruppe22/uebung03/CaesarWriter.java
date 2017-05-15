package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung03;

import de.hsMannheim.ib.tpe.ss17.gruppe22.uebung02.CrypterCaesar;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

// import de.hsMannheim.ib.tpe.ss17.gruppe22.uebung02.CrypterCaesar;
public class CaesarWriter extends FilterWriter {

    public char[] alphabet = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
        'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'Ä', 'Ö', 'Ü', 'ä', 'ö',
        'ü'};
    public CrypterCaesar cryptEngine = new CrypterCaesar();
    protected Writer out;

    /**
     * Opens a new writer
     *
     * @param out the writer to be opened.
     */
    public CaesarWriter(Writer out) {
        super(out);
        this.out = out;
        this.cryptEngine.setAlphabet(this.alphabet);
    }

    public CaesarWriter(Writer out, int charShift) {
        this(out);
        this.cryptEngine.setCharShift(charShift);
    }

    /**
     * Encrypts a portion (off, len) of an array (cbuf) of characters and writes
     * it. The encryption takes place in write(String).
     *
     * @throws java.io.IOException
     */
    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        char[] temp = new char[len];
        int counter = 0;
        for (int i = off; len > 0; i++) {
            if (i >= cbuf.length) {
                throw new IOException();
            }
            temp[counter] = cbuf[i];
            counter++;
            len--;
        }
        write(temp);
    }

    /**
     * Encrypts a char array and writes it. The encryption takes place in
     * write(String).
     *
     * @param cbuf the chars to be encrypted
     * @throws IOException
     */
    @Override
    public void write(char[] cbuf) throws IOException {
        for (int i = 0; i < cbuf.length; i++) {
            write((int) cbuf[i]);
        }
    }

    /**
     * Encrypts a single character and writes it. The encryption takes place in
     * write(String).
     *
     * @param c the char to be encrypted
     * @throws java.io.IOException
     */
    @Override
    public void write(int c) throws IOException {
        char temp = (char) c;
        String tempString = "" + temp;
        write(tempString);
    }

    /**
     * Encrypts a portion of a string and writes it. The encryption takes place
     * in write(String).
     *
     * @param str the string to be encrypted
     * @param off the offset point
     * @throws java.io.IOException
     */
    @Override
    public void write(String str, int off, int len) throws IOException {
        String tempString = "";
        for (int i = off; len > 0; i++) {
            if (i > str.length()) {
                throw new IOException();
            }
            tempString = tempString + str.charAt(i);
            len--;
        }
        write(tempString);
    }

    /**
     * Encrypts a string using Caesar encryption and writes it.
     *
     * @param str The string to be encrypted
     * @throws IOException
     */
    @Override
    public void write(String str) throws IOException {
        str = cryptEngine.encrypt(str);
        out.write(str);
//        System.out.println(str + "\n wurde in die Datei geschrieben.");
    }
}
