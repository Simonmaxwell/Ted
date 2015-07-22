package Application;

import java.util.Scanner;

public class Guts {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Modifier:");
		double mod = input.nextDouble();
		System.out.print("Enter Defense:");
		double def = input.nextDouble();

		String continueYN = "y";
		while (continueYN.equalsIgnoreCase("y")) {
			System.out.print("Enter Power:");
			double power = input.nextDouble();
			System.out.print("Enter Roll:");
			double roll = input.nextDouble();
			double roll2 = roll / 10;
			double power2 = power - def;
			double mod2 = mod + roll2;
			double damage = power2 * mod2;
			System.out.println("Damage:" + damage);
			System.out.print("Continue Y/N:");
			continueYN = input.next();
		}
		input.close();
	}
}
