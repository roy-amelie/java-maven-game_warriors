package cases.empty;

import cases.Cases;
import warriors.characters.Characters;

public class CaseEmpty implements Cases{

	private String name="Empty";
	
	public CaseEmpty() {
		this.name = "Empty";
	}
	
	@Override
	public void event(Characters hero) {
		// TODO Auto-generated method stub
		System.out.println("une case vide ! ");
	}

	@Override
	public String toString() {
		return "une case vide";
	}

}
