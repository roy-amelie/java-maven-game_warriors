package warriors.engine;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DAO.GameStateDAO;
import DAO.HeroDAO;
import DAO.JDBC.ConnectBDD;
import cases.Cases;
import dice.Dice;
import dice.DiceClassic;
import dice.DiceDebug;
import game.Game;
import maps.Board;
import maps.JsonMapCreator;
import warriors.characters.Characters;
import warriors.contracts.GameState;
import warriors.contracts.Hero;
import warriors.contracts.Map;
import warriors.contracts.WarriorsAPI;


public class Warriors implements WarriorsAPI {	

	Dice dice;
	List <Characters> warriorList= new ArrayList<Characters>();
	List <Map> mapList = new ArrayList<Map>();
	public static java.util.Map<String, Game> gameList = new HashMap<>();
	public String pathToFile="src/main/java/maps/map.json";

	public Warriors(String pathToFileDebug) {
		HeroDAO heroDao= new HeroDAO(ConnectBDD.getInstance());
		warriorList= heroDao.findAll();

		mapList.add(new Board());
			
		dice= new DiceDebug(pathToFileDebug);
	}
	
	public Warriors() {
		HeroDAO heroDao= new HeroDAO(ConnectBDD.getInstance());
		warriorList= heroDao.findAll();
			
		mapList.add(new Board());
		mapList.add(new JsonMapCreator().createInstance(getClass()));
		
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
		Game game = new Game(playerName, (Characters) hero, map);
		boolean idResult= new GameStateDAO(ConnectBDD.getInstance()).create(game);
		gameList.put(game.getGameId(),game);
		return game;
	}

	@Override
	public GameState nextTurn(String gameID) {
		/*========= recuperation du jeu================*/
		Game game = gameList.get(gameID);
		/*========= recuperation de la map================*/
		Map map = mapList.get(0);
		List<Cases> caseList = ((Board) map).getMap();
		/*==============random de========================*/
		int nextdice = dice.next();
		/*==============modification de la case du joueur========================*/
		String action =game.moveHero(nextdice,caseList);

		game.setLastLog(action);
		boolean saveResult= new GameStateDAO(ConnectBDD.getInstance()).update(game);
		System.out.println(saveResult);
		return game;
	}

}
