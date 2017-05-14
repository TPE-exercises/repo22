/*
 * This is a pitiful attempt of implementing CaesarFileEncryptor.
 * Failed at trying to check whether a file already exists.
 * Also failed during testing, trying to use a pathfile in form of a String as parameter, by not knowing how to transfer a concrete file
 * as parameter.
 */
package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung03;

import java.io.*;

/**
 *
 * @author Marco
 */
public class CaesarFileEncryptor implements IFileEncryptor {

    private int charShift = 0;

    public CaesarFileEncryptor(int charShift) {
        setCharshift(charShift);
    }

    public void setCharshift(int newCharShift) {
        this.charShift = newCharShift;
    }

    @Override
    public File encrypt(File sourceDirectory) {
        try {
            String pathfile = sourceDirectory.getAbsolutePath() + "_encrypted";

            Writer myWriter = new CaesarWriter(new FileWriter((pathfile)), this.charShift);
            String toBeWritten = "";
            // TODO: Implement a reader that reads from the final pathfile and sets the String toBeWritten to the content of the text file.
            myWriter.write("Hallo allerseits!");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Es ist eine " + e + " aufgetreten.");
        }
        return null;
    }

    @Override
    public File decrypt(File sourceDirecotry) {
        return null;
    }
}
