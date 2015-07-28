package Application;

public class Enemy {

	String name = "";
	double defense = 0;
	double health = 0;

	public Enemy(String eName, double eDefense, double eHealth) {
		name = eName;
		defense = eDefense;
		health = eHealth;
		// You were right. It wasn't being saved!
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
