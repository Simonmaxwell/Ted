package Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Guts {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String name = "";
		double defense = 0;
		double health = 0;
		double playerModifier = 0;
		// int i = 1;
		int k = 1;
		List<Enemy> enemyArray = new ArrayList<>();

		// List<Player> playerArray = new ArrayList<>();
		// do {
		// String promptType = "Player";
		// System.out.print("Enter name for " + promptType + " " + i + ":");
		// name = input.next();
		// if (name.length() > 1) {
		// System.out.print("Enter defense for " + promptType + " " + i
		// + ":");
		// def = input.nextDouble();
		// System.out.print("Enter health for " + promptType + " " + i
		// + ":");
		// health = input.nextDouble();
		// System.out.print("Enter Modifier:");
		// mod = input.nextDouble();
		// Player player = new Player(name, def, health, mod);
		// playerCount++;
		//
		// i++;
		// }
		// } while (i < 7 && name.length() > 1);
		// playerCount = playerArray.size();

		do {
			System.out.print("Enter name for Enemy " + k + ":");
			name = input.next();
			if (name.length() > 1) {
				System.out.print("Enter defense for Enemy " + k + ":");
				defense = input.nextDouble();
				System.out.print("Enter health for Enemy " + k + ":");
				health = input.nextDouble();
				System.out.print("Enter Modifier:");
				playerModifier = input.nextDouble();
				Enemy enemy = new Enemy(name, defense, health, playerModifier);
				enemyArray.add(enemy);
				k++;
			}
		} while (k < 7 && name.length() > 1);

		int targetEnemy = 0;

		do {
			String enemyName = "";

			printTable(enemyArray);

			System.out.print("Enter target number:");
			targetEnemy = input.nextInt();

			if (targetEnemy > 0) {
				Enemy currentEnemy = enemyArray.get(targetEnemy - 1);

				double enemyDefense = currentEnemy.getDefense();
				double enemyHealth = currentEnemy.getHealth();

				System.out.print("Enter Power:");
				double playerPower = input.nextDouble();
				System.out.print("Enter Roll:");
				double roll = input.nextDouble();
				double rollDividedByTen = roll / 10;
				double powerMinusDefense = playerPower - enemyDefense;
				double adjustedMod = playerModifier + rollDividedByTen;
				double damage = powerMinusDefense * adjustedMod;

				enemyName = currentEnemy.getName();
				System.out.println("You did " + damage
						+ " points of damage to enemy " + enemyName + "!");
				enemyHealth -= damage;
				currentEnemy.setHealth(enemyHealth);
				if (enemyHealth < 1) {
					enemyArray.remove(currentEnemy);
					System.out.println("Enemy " + enemyName + " was defeated!");
				}
			}
		} while (targetEnemy > 0);
		input.close();
	}

	private static void printTable(List<Enemy> enemyArray) {
		String table = "";
		table = "Target\tName\tHealth\n";
		table += "======\t======\t======\n";
		for (int j = 0; j < enemyArray.size(); j++) {
			table += (j + 1) + "\t" + enemyArray.get(j).getName() + "\t"
					+ enemyArray.get(j).getHealth() + "\n";
		}
		System.out.print(table);
	}
}
