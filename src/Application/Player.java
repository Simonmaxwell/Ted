package Application;

public class Player {

	String name = "";
	double defense = 0;
	double health = 0;
	double modifier = 0;

	public Player(String pName, double pDefense, double pHealth, double pMod) {
		name = pName;
		defense = pDefense;
		health = pHealth;
		modifier = pMod;
	}

	public double getModifier() {
		return modifier;
	}

	public void setModifier(double modifier) {
		this.modifier = modifier;
	}

	public double getDefense() {
		return defense;
	}

	public void setDefense(double def) {
		this.defense = def;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

}