package cases.bonus.potion;

import cases.Cases;

import warriors.characters.Characters;

public class LifePotion implements Cases {

	private int addPv = 2;

	
	@Override
	public void event(Characters hero) {
		// TODO Auto-generated method stub
		hero.addPvToHero(addPv);
	}


	@Override
	public String toString() {
		return "une potion qui vous rend 2 point de vie";
	}
	

}
