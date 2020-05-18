package cases.enemy;

import cases.Cases;
import warriors.characters.Characters;

public class Witcher implements Cases {

	private int pv=9;
	private int pa=2;

	@Override
	public void event(Characters hero) {
		// TODO Auto-generated method stub
		hero.fight(pv,pa);
	}

	@Override
	public String toString() {
		return "un Sorcier qui a "+pv+" pv et "+pa+" pa";
	}
	

}
