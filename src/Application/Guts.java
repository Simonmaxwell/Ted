package Application;

import java.util.Scanner;

public class Guts {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Modifier:");
		double mod = input.nextDouble();
		System.out.print("Enter Defense:");
		double def = input.nextDouble();
		double power;
		double roll;
		do {
			System.out.print("Enter Power:");
			power = input.nextDouble();
			System.out.print("Enter Roll:");
			roll = input.nextDouble();
			double roll2 = roll / 10;
			double power2 = power - def;
			double mod2 = mod + roll2;
			double damage = power2 * mod2;
			System.out.println("Damage:" + damage);
		} while (roll > 0 || power > 0);
		input.close();
	}
}
