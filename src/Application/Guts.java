package Application;

import java.util.Scanner;

public class Guts {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Modifier:");
		double mod = input.nextDouble();
		double[] enemyArray = new double[7];
		double def = 0;

		for (int i = 1; def > -1; i++) {
			System.out.print("Enter defense for Enemy " + i + ":");
			def = input.nextDouble();
			enemyArray[i] = def;
		}
		double power;
		double roll;
		int target = 0;
		do {
			double eDef = 0;
			System.out.print("Enter target number:");
			target = input.nextInt();
			eDef = enemyArray[target];
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
						+ " points of damage to enemy " + target + "!");
			}
		} while (target > 0);
		input.close();

	}
}