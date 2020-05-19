package maps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cases.Cases;
import cases.bonus.potion.BigLifePotion;
import cases.bonus.potion.LifePotion;
import cases.bonus.potion.LittleLifePotion;
import cases.bonus.spell.FireBall;
import cases.bonus.spell.Flash;
import cases.bonus.weapon.Arc;
import cases.bonus.weapon.Epee;
import cases.bonus.weapon.Massue;
import cases.empty.CaseEmpty;
import cases.enemy.Dragon;
import cases.enemy.Goblin;
import cases.enemy.Witcher;
import warriors.contracts.Map;

public class Board implements Map{
	
	private String name ;
	private int numberOfCase = 64;
	private List<Cases> map = new ArrayList<Cases>();
	
	
	
	public Board() {
		// TODO Auto-generated constructor stub
		this.name="La foret des secrets";
		this.getNumberOfCase();
		
		fillTheMap();
		mixTheMap();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	
	
	public List<Cases> getMap() {
		return map;
	}

	@Override
	public int getNumberOfCase() {
		// TODO Auto-generated method stub
		return numberOfCase;
	}
	
	public void fillTheMap() {
		/*============ enemy================*/
		addTypeCase(4, new Dragon());
		addTypeCase(10, new Witcher());
		addTypeCase(10, new Goblin());
		/*============bonus==================*/
		addTypeCase(5, new Arc());
		addTypeCase(3, new Massue());
		addTypeCase(2, new Epee());
		addTypeCase(5, new Flash());
		addTypeCase(2, new FireBall());
		addTypeCase(5, new LittleLifePotion());
		addTypeCase(3, new LifePotion());
		addTypeCase(1, new BigLifePotion());
		/*============empty==================*/
		addTypeCase(14, new CaseEmpty());
	}

	public void addTypeCase(int number,Cases Type) {
		for (int i = 0; i <number; i++) {
			map.add(Type);
		}
	}
	
	private void mixTheMap() {
		// TODO Auto-generated method stub
		Collections.shuffle(map);
	}
}
