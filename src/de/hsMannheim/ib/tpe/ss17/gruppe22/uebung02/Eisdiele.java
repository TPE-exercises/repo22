package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung02;
import java.math.*;
public class Eisdiele {
/**
 * Serves ice cream
 */
	Eis karte[] = new Eis[4];
	
	public void bestellen(String typ) {
		
	}
	public void begruessen() {
		int x = (int) Math.random()*3;
		switch (x) {
		case 1:
			System.out.println("Hallo!");
			break;
		case 2:
			System.out.println("Guten Tag!");
			break;
		case 3:
			System.out.println("Ciao!");
			break;
		}
	}
	public void kassieren(Eis eis) {
		System.out.println("Das macht dann " + eis.getPreis() + "€.");
	}
	public void verabschieden() {
		int x = (int) Math.random()*3;
		switch (x) {
		case 1:
			System.out.println("Lassen sie sich ihr Eis schmecken!");
			break;
		case 2:
			System.out.println("Einen schönen Tag noch!");
			break;
		case 3:
			System.out.println("Beehren sie uns bald wieder!");
			break;
		}
	}
	public void entschuldigen() {
		System.out.print("Leider ist dieses Gericht nicht in unserem Sortiment.");
	}
}
