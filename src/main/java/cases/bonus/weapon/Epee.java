package cases.bonus.weapon;

import cases.Cases;
import warriors.characters.Characters;
import warriors.characters.Warrior;

public class Epee implements Cases{

	private int addPA=5;

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
		return "une épée qui augmente votre attaque de "+ addPA;
	}

	
}
