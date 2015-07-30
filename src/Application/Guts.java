package Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Guts {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String name = "";
		double def = 0;
		double health = 0;
		double mod = 0;
		int i = 1;
		int k = 1;
		int playerCount = 0;
		int enemyCount = 0;

		List<Enemy> enemyArray = new ArrayList<>();

		List<Player> playerArray = new ArrayList<>();

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
				def = input.nextDouble();
				System.out.print("Enter health for Enemy " + k + ":");
				health = input.nextDouble();
				System.out.print("Enter Modifier:");
				mod = input.nextDouble();
				Enemy enemy = new Enemy(name, def, health, mod);
				enemyArray.add(enemy);
				k++;
			}
		} while (i < 7 && name.length() > 1);
		enemyCount = enemyArray.size();

		double power;
		double roll;
		int pTarget = 0;
		int eTarget = 0;

		do {
			double eDef = 0;
			double eHealth = 0;
			String enemyName = "";

			printTable(enemyArray);
			System.out.print("Enter target number:");

			eTarget = input.nextInt();
			if (eTarget > 0) {
				Enemy currentEnemy = enemyArray.get(eTarget - 1);

				eDef = currentEnemy.getDefense();
				eHealth = currentEnemy.getHealth();
				enemyName = currentEnemy.getName();

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
				currentEnemy.setHealth(eHealth);
			}
		} while (eTarget > 0);
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
