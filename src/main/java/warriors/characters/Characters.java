package warriors.characters;

import warriors.contracts.Hero;

public class Characters implements Hero{
	protected int id;
	protected String type;
	protected String name;
	protected String image;
	protected int life;
	protected int attackLevel;
	protected String equipement;
	

	public Characters(int id, String type, String name, String Image, int life, int force, String equipement) {
		this.id=id;
		this.type=type;
		this.name=name;
		this.image=Image;
		this.life=life;
		this.attackLevel=force;
		this.equipement=equipement;
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
		return null;
	}

	@Override
	public int getLife() {
		// TODO Auto-generated method stub
		return life;
	}
	public int setLife(int life) {
		return this.life = life;
	}

	public int setAttackLevel(int pa){
		return this.attackLevel = pa;
	}

	@Override
	public int getAttackLevel() {
		// TODO Auto-generated method stub
		return attackLevel;
	}

	public String getType() {
		return type;
	}

	public void addPvToHero(int addPv) {
		// TODO Auto-generated method stub
		int newLife = getLife() + addPv;
		if (newLife>10) {
			setLife(10);
		} else {
			setLife(newLife);
		}
	}

	public void equipHero(int addPA) {
		// TODO Auto-generated method stub
		int PaPotentiel = 5+ addPA;
		int heroPa =getAttackLevel();
		if (PaPotentiel>heroPa) {
			setAttackLevel(PaPotentiel);
		}
	}

	public void fight(int pv, int pa) {
		// TODO Auto-generated method stub
		int heroPa =getAttackLevel();
		int enemyPv= pv-heroPa;
		if (enemyPv>0) {
			int heroPv = getLife() - pa;
			setLife(heroPv);
		}
	}

}
