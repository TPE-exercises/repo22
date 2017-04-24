package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung02;


public class Main {

	  public static void main(String[] args) {
	    // TODO Auto-generated method stub
	    CrypterCaesar myCrypter = new CrypterCaesar((26*3000)*(-1)+1);
	    String myString = "K";
//	    String myString = "Ich, Julius Caesar, sagte den folgenden beruehmten Satz: Veni, vidi, vici.";
	    String myEncryptedString = myCrypter.encrypt(myString);
	    System.out.print("Encrypted Message: ");
	    System.out.println(myEncryptedString);
	    String myDecryptedString = myCrypter.decrypt(myEncryptedString);
	    System.out.print("Decrypted Message: ");
	    System.out.println(myDecryptedString);
	  }

	}
