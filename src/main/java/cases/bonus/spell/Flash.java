package cases.bonus.spell;

import cases.Cases;
import warriors.characters.Characters;
import warriors.characters.Wizard;

public class Flash implements Cases{

	private int addPA=2;
	

	@Override
	public void event(Characters hero) {
		// TODO Auto-generated method stub
		if(hero instanceof Wizard) {
			hero.equipHero(addPA);
		} else {
			System.out.println("ce bonus ne s'applique pas sur votre hero");
		}
	}


	@Override
	public String toString() {
		return "un éclair qui augmente votre attaque de "+ addPA;
	}

	
}
