package cases.bonus.potion;

import cases.Cases;
import warriors.characters.Characters;

public class BigLifePotion implements Cases{

	private int addPv = 5;
	
	@Override
	public void event(Characters hero) {
		// TODO Auto-generated method stub
		hero.addPvToHero(addPv);
	}

	@Override
	public String toString() {
		return "une potion qui vous fait recuperer 5 point de vie";
	}
	
	

}
