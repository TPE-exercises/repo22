package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung02;

public class MonnemerEis extends Eis{
	public MonnemerEis(String name, String behaeltnis, String art, String sorten[], String extras[], double preis){
		super (name,behaeltnis,art, sorten, extras, preis);
	}
	
	public void vorbereiten() {
		System.out.println("Isch nehm'n " + this.behaeltnis + ".");
	}
	
	public void fuellen() {
		System.out.print("Isch fuell " + this.behaeltnis + " mit " + this.art + "da Sort ");
		int i = 0;
		while (this.sorten.length > i) {
			if (this.sorten.length - 1 > i)
				System.out.print(this.sorten[i] + ", ");
			else
				System.out.println(this.sorten[i] + ".");
			i++;
		}
	}

	public void dekorieren() {
		System.out.print("Isch dekorier des Ees mit ");
		int i = 0;
		while(this.extras.length > i){
			if (this.extras.length - 1 > i)
				System.out.print(this.extras[i] + ", ");
			else
				System.out.println(this.extras[i] + ".");
			i++;
		}

	}
}
