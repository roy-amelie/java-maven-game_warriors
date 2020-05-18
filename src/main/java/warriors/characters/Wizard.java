package warriors.characters;

public class Wizard extends Characters{
	
	private String name= "Magicien";
	private String image= "https://i.pinimg.com/originals/29/f0/31/29f031dcc97eb956bdab6884e49263d2.jpg" ;
	private int life= 10;
	private int attackLevel=5;

	public Wizard() {
		this.getName();
		this.getImage();
		this.getLife();
		this.getAttackLevel();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getImage() {
		// TODO Auto-generated method stub
		return image;
	}

	@Override
	public int getLife() {
		// TODO Auto-generated method stub
		return life;
	}
	
	public int setLife(int life) {
		return this.life=life;
	}

	@Override
	public int getAttackLevel() {
		// TODO Auto-generated method stub
		return attackLevel;
	}
	
	public int setAttackLevel(int attack) {
		return this.attackLevel=attack;
	}

}
