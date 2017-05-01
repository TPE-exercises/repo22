package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung02;

public class KoelnerEis extends Eis{
	public KoelnerEis(String name, String behaeltnis, String art, String sorten[], String extras[], double preis){
		super (name,behaeltnis,art, sorten, extras, preis);
	}

	public void fuellen() {
		System.out.print("Ich fuell " + this.behaeltnis + " met " + this.art + "d'r Sorte ");
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
		System.out.print("Ich dekoriere dat Ies met ");
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
