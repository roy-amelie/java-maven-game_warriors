package warriors.characters;


public class Warrior extends Characters {

	private String name= "Guerrier";
	private String image= "https://i.pinimg.com/originals/29/f0/31/29f031dcc97eb956bdab6884e49263d2.jpg" ;
	private int life= 10;
	private int attackLevel=5;

	public Warrior() {
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
