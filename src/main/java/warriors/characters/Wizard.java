package warriors.characters;

public class Wizard extends Characters{
	
	

	private String name= "Magicien";
	private String image= "https://i.pinimg.com/originals/29/f0/31/29f031dcc97eb956bdab6884e49263d2.jpg" ;
	private int life= 10;
	private int attackLevel=5;
	private int id =2;

	public Wizard(int id, String type, String name, String Image, int life, int force, String equipement) {
		super(id, type, name, Image, life, force, equipement);
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
