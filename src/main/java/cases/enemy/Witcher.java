package cases.enemy;

import cases.Cases;
import warriors.characters.Characters;

public class Witcher implements Cases {

	private String name;
	private int pv;
	private int pa;
	
	public Witcher() {
		this.name = "Witcher";
		this.pv = 9;
		this.pa = 2;
	}

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
