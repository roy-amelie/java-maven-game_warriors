package dice;

import java.util.Random;

public class DiceClassic extends Dice {

	@Override
	public int next() {
		// TODO Auto-generated method stub
		Random random = new Random();
		int dice = random.nextInt(6)+1;
		return dice;
	}

}
