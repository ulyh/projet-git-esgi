package soutienDiscord;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {

	public static void game(Warrior person1, Warrior person2) {
		while (person1.getHp() != 0 & person2.getHp() != 0) {
			if (round(person1, person2) == 0) {
				break;
			}
			round(person2, person1);

		}
		System.out.println("Fin de la partie");
		if (person2.getHp() == 0) {
			System.out.println(person1.getName() + " a gagné !\n");
		} else {
			System.out.println(person2.getName() + " a gagné !\n");
		}

		System.out.println(person1);
		System.out.println(person2);

	}

	public static int round(Warrior character, Warrior opponent) {
		System.out.println(character);
		System.out.println(opponent);
		String input;
		ArrayList<String> options = new ArrayList<String>();
		options.add("Analyser");
		options.add("Attaquer");
		options.add("Fuir");
		options.add("Quitter");

		do {

			do {
				System.out.println(
						"-------------Tour de " + character.getName() + "-------------\nChoix d'actions possibles :");
				for (String option : options) {
					System.out.println("-> " + option);
				}
				Scanner sc = new Scanner(System.in);
				input = sc.nextLine();
				input = input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
			} while (!options.contains(input));

			if (input.equals("Fuir")) {
				escape(character, opponent);
				return 0;
			}

			if (input.equals("Quitter")) {
				return 0;
			}

			if (input.equals("Analyser")) {
				System.out.println(input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase());
				analyse(opponent);
			}
		} while (input.equals("Analyser"));

		if (input.equals("Attaquer")) {
			Scanner sc1 = new Scanner(System.in);
			String attaque;
			do {
				showListAttack(character);
				attaque = sc1.nextLine();
				attaque = attaque.toLowerCase();
			} while (character.getAttack(attaque) == null);
			attack(character, opponent, attaque);
			System.out.println(character.getName() + " attacks " + opponent.getName() + " with the attack "
					+ character.getAttack(attaque).getName());
			System.out.println("It deals " + character.getAttack(attaque).getDamage() + " damages !\n\n");
			if (opponent.getHp() == 0) {
				System.out.println(opponent.name + " was killed");
			}
		}

		if (input.equals("Fuir")) {
			escape(character, opponent);
			return 0;
		}
		return opponent.getHp();
	}

	public static void analyse(Warrior opponent) {
		System.out.println(opponent);
	}

	public static void attack(Warrior character, Warrior opponent, String nameAttack) {
		character.toAttack(opponent, nameAttack);
	}

	public static void escape(Warrior character, Warrior opponent) {
		System.out.println(character.name + " abandonne le combat.\n");
	}

	public static void showListAttack(Warrior character) {
		System.out.println(character.name + "\nChoisis ton attaque :");
		for (Attack attack : character.getListAttack()) {
			System.out.println("\t- " + attack.getName());
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {
		Warrior mario = new Warrior("Mario", 100);
		Warrior luigi = new Warrior("Luigi", 100);
		Attack tickle = new Attack("Tickle", 2);
		luigi.addAttack(tickle);
		game(mario, luigi);
	}
}
