package soutienDiscord;

import java.util.ArrayList;

public class Warrior extends Person {

	private ArrayList<Attack> listAttack;

	public Warrior(String name, int hp) {
		super(name, hp);
		listAttack = new ArrayList<Attack>();
		listAttack.add(new Attack(this.catchphrase, 1));
		listAttack.add(new Attack("Punch", 25));

	}

	public ArrayList<Attack> getListAttack() {
		return listAttack;
	}

	public void setListAttack(ArrayList listAttack) {
		this.listAttack = listAttack;
	}

	public void addAttack(Attack attack) {
		listAttack.add(attack);
	}

	public void removeAttack(Attack attack) {
		listAttack.remove(attack);
	}

	public Attack getAttack(int choix) {
		if (choix < listAttack.size()) {
			return listAttack.get(choix);
		} else {
			return listAttack.get(0);
		}
	}
	
	public Attack getAttack(String name) {
		for (Attack attack : listAttack) {
			if (attack.getName().toLowerCase().equals(name.toLowerCase())) {
				return attack;
			}
		}
		return null;
	}
	/*
	public Boolean hasAttack(String nameAttack) {
		for (Attack attack : listAttack) {
			if (attack.getName().toLowerCase().equals(nameAttack.toLowerCase())) {
				return true;
			}
		}
		return false;
	}
	*/
	public void removeAttack(String name) {
		for (int i = 0; i < listAttack.size(); i += 1) {
			if (listAttack.get(i).getName().equals(name)) {
				listAttack.remove(i);
			}
		}
	}

	public void toAttack(Warrior opponent, int choix) {
		if (opponent.getHp() > this.getAttack(choix).getDamage()) {
			opponent.setHp(opponent.getHp() - this.getAttack(choix).getDamage());
		} else {
			opponent.setHp(0);
		}
	}
	
	public void toAttack(Warrior opponent, String name) {
		if (opponent.getHp() > this.getAttack(name).getDamage()) {
			opponent.setHp(opponent.getHp() - this.getAttack(name).getDamage());
		}else {
			opponent.setHp(0);
		}
	}
}
