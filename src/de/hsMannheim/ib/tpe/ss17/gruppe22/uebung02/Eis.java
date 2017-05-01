package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung02;

public abstract class Eis {

	protected String name, behaeltnis, art;
	protected String[] sorten, extras;

	private double preis;

	public Eis(String name, String behaeltnis, String art, String sorten[], String extras[], double preis) {
		this.name = name;
		this.behaeltnis = behaeltnis;
		this.art = art;
		this.sorten = sorten;
		this.extras = extras;
		this.preis = preis;
	}
	public double getPreis(){
		return preis;
	}
	public String getName(){
		return name;
	}

	public void vorbereiten() {
		System.out.println("Ich nehme " + this.behaeltnis + ".");
	}

	public void fuellen() {
		System.out.print("Ich fülle " + this.behaeltnis + " mit " + this.art + " der Sorte ");
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
		System.out.print("Ich dekoriere das Eis mit ");
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
