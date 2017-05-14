package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung03;

import de.hsMannheim.ib.tpe.ss17.gruppe22.uebung02.CrypterCaesar;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class CaesarReader extends FilterReader {

	public char[] alphabet = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'Ä', 'Ö', 'Ü', 'ä', 'ö',
			'ü' };
	public CrypterCaesar cryptEngine = new CrypterCaesar();
	protected Reader in;

	public CaesarReader(Reader in) {
		super(in);
		this.in = in;
		this.cryptEngine.setAlphabet(this.alphabet);
	}

	public CaesarReader(Reader in, int charShift) {
		this(in);
		this.cryptEngine.setCharShift(charShift);
	}
	/*
	 * Reads and decrypts the Array cbuf from off to len
	 * @see java.io.FilterReader#read(char[], int, int)
	 */
	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		int charsToRead = in.read(cbuf, off, len);
		if (len < off)
			throw new IOException();
		
		for (int i = off; len > 0; i++){
			String tempString = "";
			tempString += cbuf[i];
			cbuf[i] = this.cryptEngine.decrypt(tempString).charAt(0);
			len--;
		}
		return charsToRead;
	}
	/*
	 * Reads and decrypts the entire Array cbuf
	 * decrypts in read(char, int, int)
	 * @see java.io.Reader#read(char[])
	 */
	@Override
	public int read(char[] cbuf) throws IOException {
		return read(cbuf, 0, cbuf.length);
	}
	/*
	 * Reads and decrypts a single char
	 * @see java.io.FilterReader#read()
	 */
	@Override
	public int read() throws IOException {
		String tempString = "";
		int lastRead;
		lastRead = in.read();
		if (lastRead == -1)
			return -1;
		tempString += (char) lastRead;
		tempString = cryptEngine.decrypt(tempString);
		return (int) tempString.charAt(0);

	}
}
