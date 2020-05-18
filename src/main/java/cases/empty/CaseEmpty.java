package cases.empty;

import cases.Cases;
import warriors.characters.Characters;

public class CaseEmpty implements Cases{

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
