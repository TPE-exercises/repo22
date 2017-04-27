package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung02;


public class Main {

	  public static void main(String[] args) {
	    // TODO Auto-generated method stub
	    Crypter myCrypter = new CrypterCaesar((26*3000)*(-1)+1);
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
	    myCrypter = new CrypterReverse();
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
	  }

	}
