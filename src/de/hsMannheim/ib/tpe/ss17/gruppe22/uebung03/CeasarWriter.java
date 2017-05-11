package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung03;

import de.hsMannheim.ib.tpe.ss17.gruppe22.uebung02.CrypterCaesar;
import java.io.FilterWriter;
import java.io.Writer;

// import de.hsMannheim.ib.tpe.ss17.gruppe22.uebung02.CrypterCaesar;
public class CaesarWriter extends FilterWriter {
	private char[] alphabet = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'Ä', 'Ö', 'Ü', 'ä', 'ö',
			'ü' };
	private CrypterCaesar cryptEngine;
	private String message;

	public CaesarWriter(Writer writer, int charShift) {
		super(null);
		this.cryptEngine.setAlphabet(this.alphabet);
		this.cryptEngine.setCharShift(charShift);
	}

	/**
	 * Closes the stream, flushing it first.
	 */

	public void close() {
	}

	/**
	 * Flushes the stream.
	 */
	public void flush() {
	}

	/**
	 * Writes a portion of an array of characters.
	 */
	public void write(char[] cbuf, int off, int len) {
	}

	/**
	 * Writes a single character.
	 */
	public void write(int c) {
		char temp = (char) c;
		String tempString = "" + temp;
		cryptEngine.encrypt(tempString);
	}

	/**
	 * Writes a portion of a string.
	 */
	public void write(String str, int off, int len) {
		String tempString;
		char tempArray[];
	}
}
