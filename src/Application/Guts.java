package Application;

import java.util.Scanner;

public class Guts {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Modifier:");
		double mod = input.nextDouble();
		Enemy[] enemyArray = new Enemy[7];
		double def = 0;
		double health = 0;
		String name = "";
		int i = 1;

		do {
			System.out.print("Enter name for Enemy " + i + ":");
			name = input.next();
			if (name.length() > 1) {
				System.out.print("Enter defense for Enemy " + i + ":");
				def = input.nextDouble();
				System.out.print("Enter health for Enemy " + i + ":");
				health = input.nextDouble();
				Enemy enemy = new Enemy(name, def, health);
				enemyArray[i] = enemy;
				i++;
			}
		} while (i < 7 && name.length() > 1);

		double power;
		double roll;
		int target = 0;

		do {
			double eDef = 0;
			double eHealth = 0;
			String enemyName = "";
			System.out.print("Enter target number:");
			target = input.nextInt();
			eDef = enemyArray[target].getDefense();
			eHealth = enemyArray[target].getHealth();
			enemyName = enemyArray[target].getName();

			if (target > 0) {
				System.out.print("Enter Power:");
				power = input.nextDouble();
				System.out.print("Enter Roll:");
				roll = input.nextDouble();
				double roll2 = roll / 10;
				double power2 = power - eDef;
				double mod2 = mod + roll2;
				double damage = power2 * mod2;
				System.out.println("You did " + damage
						+ " points of damage to enemy " + enemyName + "!");
				eHealth -= damage;
				enemyArray[target].setHealth(eHealth);
				System.out.println("Enemy " + enemyName + " has " + eHealth
						+ " health remaining.");
			}
		} while (target > 0);
		input.close();

	}
}