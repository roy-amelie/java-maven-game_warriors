package cases.bonus.spell;

import cases.Cases;
import warriors.characters.Characters;
import warriors.characters.Wizard;

public class FireBall implements Cases{

	private String name;
	private int addPA;
	
	public FireBall() {
		this.name = "FireBall";
		this.addPA =7;
	}
	
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
		return "une boule de feu qui augmente votre attaque de "+ addPA;
	}

}
