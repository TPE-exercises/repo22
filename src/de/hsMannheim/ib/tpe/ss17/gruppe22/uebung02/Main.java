package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung02;


public class Main {

	  public static void main(String[] args) {
	    // TODO Auto-generated method stub
		CrypterCaesar myCaesarCrypter = new CrypterCaesar(1);
		CrypterReverse myCrypterReverse = new CrypterReverse();
	    Crypter myCrypter = myCaesarCrypter;
//	    String myString = "aBc";
	    String myString = "Ich, Julius Caesar, sagte den folgenden beruehmten Satz: Veni, vidi, vici.";
	    
	    // Task 1b)
	    System.out.println("Caesar-Verschlüsselung:");
	    System.out.println();
	    String myEncryptedString = myCrypter.encrypt(myString);
	    System.out.print("Encrypted Message: ");
	    System.out.println(myEncryptedString);
	    String myDecryptedString = myCrypter.decrypt(myEncryptedString);
	    System.out.print("Decrypted Message: ");
	    System.out.println(myDecryptedString);
	    System.out.println();
	    System.out.println();
	    
	    // Task 1c)
	    myCrypter = myCrypterReverse;
	    System.out.println("Reverse-Verschlüsselung:");
	    System.out.println();
	    myEncryptedString = myCrypter.encrypt(myString);
	    System.out.print("Encrypted Message: ");
	    System.out.println(myEncryptedString);
	    myDecryptedString = myCrypter.decrypt(myEncryptedString);
	    System.out.print("Decrypted Message: ");
	    System.out.println(myDecryptedString);
	    System.out.println();
	    System.out.println();
	    
	    // Task 1d)
	    myString = "XHMSNYYXYJQQJS";
	    myString = myCrypterReverse.decrypt(myString);
	    myCaesarCrypter.setCharShift(5);
	    myString = myCaesarCrypter.decrypt(myString);
	    myString = myCrypterReverse.decrypt(myString);
	    System.out.println(myString);
	  }

	}
