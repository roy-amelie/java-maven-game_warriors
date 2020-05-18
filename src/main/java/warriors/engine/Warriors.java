package warriors.engine;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import cases.Cases;
import dice.Dice;
import dice.DiceClassic;
import dice.DiceDebug;
import game.Game;
import maps.LaForetDesSecrets;
import warriors.characters.Warrior;
import warriors.characters.Wizard;
import warriors.contracts.GameState;
import warriors.contracts.Hero;
import warriors.contracts.Map;
import warriors.contracts.WarriorsAPI;


public class Warriors implements WarriorsAPI {	

	Dice dice;
	List <Hero> warriorList= new ArrayList<Hero>();
	List <Map> mapList = new ArrayList<Map>();
	public static java.util.Map<String, Game> gameList = new HashMap<>();

	public Warriors(String pathToFileDebug) {
		warriorList.add(new Warrior());
		warriorList.add(new Wizard());

		
		mapList.add(new LaForetDesSecrets());
		
		dice= new DiceDebug(pathToFileDebug);
	}
	
	public Warriors() {
		warriorList.add(new Warrior());
		warriorList.add(new Wizard());

		mapList.add(new LaForetDesSecrets());
		
		dice= new DiceClassic();
	}

	@Override
	public List<? extends Hero> getHeroes() {
		// TODO Auto-generated method stub
		return warriorList;
	}

	@Override
	public List<? extends Map> getMaps() {
		// TODO Auto-generated method stub
		return mapList;
	}

	@Override
	public GameState createGame(String playerName, Hero hero, Map map) {
		// TODO Auto-generated method stub
		Game game = new Game(playerName, hero, map);
		gameList.put(game.getGameId(),game);
		return game;
	}

	@Override
	public GameState nextTurn(String gameID) {
		/*========= recuperation du jeu================*/
		Game game = gameList.get(gameID);
		/*========= recuperation de la map================*/
		Map map = mapList.get(0);
		List<Cases> caseList = ((LaForetDesSecrets) map).getMap();
		/*==============random de========================*/
		int nextdice = dice.next();
		/*==============modification de la case du joueur========================*/
		String action =game.moveHero(nextdice,caseList);

		game.setLastLog(action);

		return game;
	}

}
