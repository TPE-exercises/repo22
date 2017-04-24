package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung02;

public class CrypterCaesar implements Crypter {
	// What's the matter with small and Capital letters in this scenario?
	private char[] smallAlphabet = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
			'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	private char[] alphabet = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private int charShift = 0;

	public CrypterCaesar() {

	}

	public CrypterCaesar(int charShift) {
		setCharShift(charShift);
	}

	public CrypterCaesar(int charShift, String message) {
		this(charShift);
		System.out.println(encrypt(message));
	}

	public boolean isInAlphabet(char sign) {
		for (int i = 0; i < this.alphabet.length; i++) {
			if (sign == this.alphabet[i]) {
				return true;
			}
			if (sign == this.smallAlphabet[i]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Encrypts a letter by the ways of Caesar Encryption.
	 * 
	 * @param letter
	 *            The letter to be encrypted.
	 * @return The cypher letter.
	 */
	private char shiftedLetter(char letter) {
		char returnValue = ' ';
		int letterIndex;
		int i = 0;
		while (i < this.alphabet.length) {
			if (letter == this.alphabet[i] || letter == this.smallAlphabet[i]) {
				letterIndex = i + this.charShift;
				// Here, the implementation of setCharShift(int i) is crucial.
				if (letterIndex >= this.alphabet.length) {
					letterIndex = letterIndex - this.alphabet.length;
				}
				returnValue = this.alphabet[letterIndex];
			}
			i++;
		}
		return returnValue;
	}

	/**
	 * Encrypts a string by Caesar standard and the key charShift.
	 * 
	 * 
	 */
	public String encrypt(String message) {
		int messageLength = message.length();
		String cypherText = "";
		for (int i = 0; i < messageLength; i++) {
			if (isInAlphabet(message.charAt(i))) {
				cypherText = cypherText + shiftedLetter(message.charAt(i));
			} else {
				cypherText = cypherText + message.charAt(i);
			}
		}
		return cypherText;
	}

	/**
	 * Decrypts a string by Caesar standard and the key charShift.
	 * 
	 * @param cypherText: the message to be decrypted
	 */
	public String decrypt(String cypherText) {
		int textLength = cypherText.length();
		String decryptedText = "";
		setCharShift(26 - charShift);
		for (int i = 0; i < textLength; i++) {
			if (isInAlphabet(cypherText.charAt(i))) {
				decryptedText = decryptedText + shiftedLetter(cypherText.charAt(i));
			} else {
				decryptedText = decryptedText + cypherText.charAt(i);
			}
		}
		setCharShift(26 - charShift);
		return decryptedText;
	}

	/**
	 * The number below shall have an end value which lies inbetween 0 and our
	 * alphabet length (by standard: 26). It is the same story as with Modulo in
	 * mathematics. 1 mod 2 equals 3 mod 2 equals -1 mod 2 and so on.
	 * 
	 * @param i:
	 *            The amounts of digits a letter in the alphabet shall be
	 *            shifted
	 */
	public void setCharShift(int i) {
		while (i < 0) {
			i = i + this.alphabet.length;
		}
		while (i > this.alphabet.length) {
			i = i - this.alphabet.length;
		}
		this.charShift = i;
	}

	public int getCharShift() {
		return this.charShift;
	}
}
