package soutienDiscord;

public class Person {

	protected String name;
	protected int hp;
	protected String catchphrase;

	public Person(String name, int hp) {
		this.name = name;
		this.hp = hp;
		switch (name) {
		case "Mario":
			catchphrase = "It's me Mario!";
			break;
		case "Luigi":
			catchphrase = "Mama-mia";
			break;
		default:
			catchphrase = "Here we go!";
		}
	}

	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public String getName() {
		return name;
	}

	public String getCatchphrase() {
		return catchphrase;
	}

	public void setCatchphrase(String oyeoye) {
		catchphrase = oyeoye;
	}

	public String toString() {
		return "***Stats***\nName : " + name + "\nHP : " + hp + "\n";
	}

}