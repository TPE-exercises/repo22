package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung02;

public class MonnemerEisdiele extends Eisdiele{
	MonnemerEisdiele(){
		this.karte[0] = new MonnemerEis("Himbeer Becher", "Glas", "Baelle",
				new String[] { "Himbeereis", "Vanilleeis", "Erdbeereis" },
				new String[] { "Himbeeren", "Sahne", "Erdbeersauce" }, 5.70);
		this.karte[1] = new MonnemerEis("Bananasplit", "Schale", "Kugeln", new String[] { "Vanilleeis", "Bananeneis" },
				new String[] { "einer Banane", "Sahne", "Schokoladensosse" }, 6.10);
		this.karte[2] = new MonnemerEis("Spaghettieis", "Becher", "Spaghetti", new String[] { "Vanilleeis" },
				new String[] { "Erdbeersauce", "Schokoraspeln","Sahne","Monnemer Dreck" }, 4.90);
		this.karte[3] = new MonnemerEis("Schokotraum", "Teller", "Kleckse",
				new String[] { "Vanilleeis", "Nutellaeis", "Schokoeis" },
				new String[] { "Schokosauce", "Sahne", "Schokolade" }, 6.40);
	}
	public Eis erstellen(String typ){
		return bestellen(typ);
	}
	protected void begruessen() {
		int x = (int) (Math.random() * 3 + 1);
		switch (x) {
		case 1:
			System.out.println("Mosche!");
		case 2:
			System.out.println("Tach!");
			break;
		case 3:
			System.out.println("Ciao!");
			break;
		}
	}

	protected void kassieren(Eis eis) {
		System.out.println("Des macht dann " + eis.getPreis() + "0€‚¬.");
	}

	protected void verabschieden() {
		int x = (int) (Math.random() * 3 + 1);
		switch (x) {
		case 1:
			System.out.println("Gudae Abaedid!");
			break;
		case 2:
			System.out.println("Alla, bis ball!");
			break;
		case 3:
			System.out.println("Uff Widdesehn!");
			break;
		}
	}

	protected void entschuldigen() {
		System.out.println("Des homma laeder ned.");
	}
}
