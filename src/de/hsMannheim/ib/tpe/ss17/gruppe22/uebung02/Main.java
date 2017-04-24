package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung02;

public class Main {

	  public static void main(String[] args) {
	    // TODO Auto-generated method stub
	    CrypterCaesar myCrypter = new CrypterCaesar(3);
	    String myString = "ich, julius caesar, sagte den folgenden beruehmten satz: veni, vidi, vici.";
	    String myEncryptedString = myCrypter.encrypt(myString);
	    System.out.println(myEncryptedString);
	  }

	}
