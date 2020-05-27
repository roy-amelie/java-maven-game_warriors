package warriors.characters;


public class Warrior extends Characters {

	
	public Warrior(int id, String type, String name, String Image, int life, int force, String equipement) {
		super(id, type, name, Image, life, force, equipement);
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
	
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int setAttackLevel(int attack) {
		return this.attackLevel=attack;
	}


	public String getEquipement() {
		return equipement;
	}


	public void setEquipement(String equipement) {
		this.equipement = equipement;
	}

}
