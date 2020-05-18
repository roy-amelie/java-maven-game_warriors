package dice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DiceDebug extends Dice {
	private int i ;
	List<Integer> listDebug =  new ArrayList<Integer>();
	
	public DiceDebug(String pathToFileDebug) {
		// TODO Auto-generated constructor stub
		this.i=-1;
		String line="";
		BufferedReader readFile =null;
		String splitBy=",";
		try {
			readFile = new BufferedReader(new FileReader(pathToFileDebug));
			while((line =readFile.readLine())!=null) {
				String [] dice =line.split(splitBy);
				for(int i=0; i<dice.length;i++) {
					listDebug.add(Integer.parseInt(dice[i]));	
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	@Override
	public int next() {
		// TODO Auto-generated method stub
		int newI = getI()+1;
		setI(newI);
		return listDebug.get(i);
	}
	
}
