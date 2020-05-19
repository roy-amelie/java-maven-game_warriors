package cases.enemy;

import cases.Cases;
import warriors.characters.Characters;


public class Dragon implements Cases {

	private String name;
	private int pv;
	private int pa;
	
	public Dragon() {
		this.name = "Dragon";
		this.pv = 15;
		this.pa = 4;
	}

	@Override
	public void event(Characters hero) {
		// TODO Auto-generated method stub
		hero.fight(pv,pa);
	}

	@Override
	public String toString() {
		return "un Dragon qui a "+pv+" pv et "+pa+" pa";
	}
	
	
}
