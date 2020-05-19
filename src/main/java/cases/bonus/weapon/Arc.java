package cases.bonus.weapon;

import cases.Cases;
import warriors.characters.Characters;
import warriors.characters.Warrior;


public class Arc implements Cases{

	private String name;
	private int addPA;

	public Arc() {
		this.name = "Arc";
		this.addPA = 1;
	}

	@Override
	public void event(Characters hero) {
		// TODO Auto-generated method stub
		if(hero instanceof Warrior) {
			hero.equipHero(addPA);
		} else {
			System.out.println("ce bonus ne s'applique pas sur votre hero");
		}
	}

	@Override
	public String toString() {
		return "un arcqui augmente votre attaque de "+ addPA;
	}

	
}
