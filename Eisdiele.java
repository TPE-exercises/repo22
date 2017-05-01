package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung02;

public abstract class Eisdiele {
	/**
	 * Serves ice cream
	 */

	protected Eis karte[] = new Eis[4];

	public Eisdiele() {
		this.karte[0] = new NormalesEis("Himbeer Becher", "Glas", "Kugeln",
				new String[] { "Himbeereis", "Vanilleeis", "Erdbeereis" },
				new String[] { "Himbeeren", "Sahne", "Erdbeersauce" }, 6.60);
		this.karte[1] = new NormalesEis("Bananasplit", "Schale", "Kugeln", new String[] { "Vanilleeis", "Bananeneis" },
				new String[] { "einer Banane", "Sahne", "Schokosauce" }, 6.90);
		this.karte[2] = new NormalesEis("Spaghettieis", "Becher", "Spaghetti", new String[] { "Vanilleeis" },
				new String[] { "Erdbeersauce", "weiße Schokoraspeln" }, 5.70);
		this.karte[3] = new NormalesEis("Schokotraum", "Teller", "Kleckse",
				new String[] { "Vanilleeis", "Nusseis", "Schokoeis" },
				new String[] { "Schokosauce", "Sahne", "Schokolade" }, 7.20);
	}

	public abstract Eis erstellen(String typ);

	/**
	 * Checks if requested dish is on the menu and goes threw the ordering
	 * process
	 * 
	 * @param typ
	 *            Name of the requested dish
	 */
	public Eis bestellen(String typ) {
		System.out.println("Hallo, ich hätte gerne " + typ + ".");
		boolean iceFound = false;
		int i = 0;
		String currentIce;
		while (!iceFound) {
			currentIce = this.karte[i].getName();
			if (typ.equals(currentIce))
				iceFound = true;
			else {
				if (i < 3)
					i++;
				else {
					//requested dish is not on menu
					this.begruessen();
					this.entschuldigen();
					this.verabschieden();
					return null;
				}
			}
		}
		this.begruessen();
		this.karte[i].vorbereiten();
		this.karte[i].fuellen();
		this.karte[i].dekorieren();
		this.kassieren(this.karte[i]);
		this.verabschieden();
		return this.karte[i];

	}

	protected void begruessen() {
		int x = (int) (Math.random() * 3 + 1);
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

	protected void kassieren(Eis eis) {
		System.out.println("Das macht dann " + eis.getPreis() + "0€.");
	}

	protected void verabschieden() {
		int x = (int) (Math.random() * 3 + 1);
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

	protected void entschuldigen() {
		System.out.println("Leider ist dieses Gericht nicht in unserem Sortiment.");
	}
}
