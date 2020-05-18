package cases.enemy;

import cases.Cases;
import warriors.characters.Characters;

public class Goblin implements Cases{

	private int pv=6;
	private int pa=1;
	

	@Override
	public void event(Characters hero) {
		// TODO Auto-generated method stub
		hero.fight(pv,pa);
	}


	@Override
	public String toString() {
		return "Goblin qui a "+pv+" pv et "+pa+" pa";
	}

	
}
