package cases.bonus.potion;

import cases.Cases;
import warriors.characters.Characters;

public class LittleLifePotion implements Cases{
	
	private int addPv = 1;
	

	@Override
	public void event(Characters hero) {
		hero.addPvToHero(addPv);
	}


	@Override
	public String toString() {
		return "une potion qui vous rend 1 pv";
	}

	
}
