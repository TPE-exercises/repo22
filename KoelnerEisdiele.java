package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung02;

public class KoelnerEisdiele extends Eisdiele{
	KoelnerEisdiele(){
		this.karte[0] = new KoelnerEis("Himbeer Becher", "Glas", "Baellchen",
				new String[] { "Himbeereis", "Vanilleeis", "Erdbeereis" },
				new String[] { "Himbeeren", "Sahne", "Erdbeersauce" }, 6.70);
		this.karte[1] = new KoelnerEis("Bananasplit", "Schale", "Kugeln", new String[] { "Vanilleeis", "Bananeneis" },
				new String[] { "einer Banane", "Sahne", "Schokoladen-Kokos-Sosse","Bierteigwaffeln" }, 7.10);
		this.karte[2] = new KoelnerEis("Spaghettieis", "Becher", "Spaghetti", new String[] { "Vanilleeis" },
				new String[] { "Erdbeersauce", "Schokoraspeln","Sahne" }, 5.90);
		this.karte[3] = new KoelnerEis("Schokotraum", "Teller", "Kleckse",
				new String[] { "Vanilleeis", "Haselnusseis", "Schokoeis" },
				new String[] { "Schokosauce", "Sahne", "Schokolade" }, 7.40);
	}
	public Eis erstellen(String typ){
		return bestellen(typ);
	}
	protected void begruessen() {
		int x = (int) (Math.random() * 3 + 1);
		switch (x) {
		case 1:
			System.out.println("Hallo!");
			break;
		case 2:
			System.out.println("Jode Dach!");
			break;
		case 3:
			System.out.println("Ciao!");
			break;
		}
	}

	protected void kassieren(Eis eis) {
		System.out.println("Dat moeaet dann " + eis.getPreis() + "0€‚¬.");
	}

	protected void verabschieden() {
		int x = (int) (Math.random() * 3 + 1);
		switch (x) {
		case 1:
			System.out.println("Losse Se sich ehr Ies schmecke!");
			break;
		case 2:
			System.out.println("Ein schoene Dach noch!");
			break;
		case 3:
			System.out.println("Beehren Sem'r bald widder!");
			break;
		}
	}

	protected void entschuldigen() {
		System.out.println("Leider es dieses Jereech nit op unserer Kaat.");
	}
}
