package soutienDiscord;

public class Attack {

	private int damage;
	private String name;

	public Attack(String name, int damage) {
		this.name = name;
		this.damage = damage;
		
	}

	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Name attack: " + this.name + "\nDamage: " + this.damage + "\n";
	}

}
