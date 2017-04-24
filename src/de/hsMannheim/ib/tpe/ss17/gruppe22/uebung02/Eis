package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung02;

public class Eis {
	// TODO: In Eisdiele den richtigen Artikel und die richtige gramm. Form für
	// die Methoden unten verwenden.
	//
	private String name, behaeltnis, art;
	private String[] sorten, extras;

	private double preis;

	public Eis(String name, String behaletnis, String art, String sorten[], String extras[], double preis) {
		this.name = name;
		this.behaeltnis = name;
		this.art = art;
		this.sorten = sorten;
		this.extras = extras;
		this.preis = preis;
	}
	public double getPreis(){
		return preis;
	}

	public void vorbereiten() {
		System.out.println("Ich nehme " + this.behaeltnis + ".");
	}

	public void fuellen() {
		System.out.print("Ich fülle " + this.behaeltnis + " mit " + this.art + " der Sorte ");
		int i = 0;
		while (sorten.length > i) {
			if (sorten.length - 1 > i)
				System.out.print(this.sorten[i] + ", ");
			else
				System.out.println(this.sorten[i] + ".");
			i++;
		}
	}

	public void dekorieren() {
		System.out.print("Ich dekoriere das Eis mit ");
		int i = 0;
		while(this.extras.length > i){
			if (extras.length - 1 > i)
				System.out.print(this.extras[i] + ", ");
			else
				System.out.println(this.extras[i] + ".");
			i++;
		}

	}

}
