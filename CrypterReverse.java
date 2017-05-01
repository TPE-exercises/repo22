package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung02;

public class CrypterReverse implements Crypter {
/**
 * Mirrors a String's output. E.g.: "abc" becomes "cba".
 * 
 * @param message: The message to be encrypted.
 * @return the encrypted message.
 */
	public String encrypt(String message) {
		String reverseString = "";
		for (int i = message.length(); i > 0; i--) {
			reverseString += message.charAt(i-1);
		}
		return reverseString;
	}
/**
 * @param cypherText: The message to be decrypted.
 * @return the decrypted text.
 */
	public String decrypt(String cypherText) {
		return encrypt(cypherText);
	}
}
