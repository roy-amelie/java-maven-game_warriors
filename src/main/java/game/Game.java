package game;

import java.util.List;

import cases.Cases;
import warriors.characters.Characters;
import warriors.contracts.GameState;
import warriors.contracts.GameStatus;
import warriors.contracts.Hero;
import warriors.contracts.Map;
import warriors.engine.Warriors;

public class Game implements GameState{

	private int id;
	private String playerName;
	private String gameId = "game_"+ id ;
	private GameStatus gameStatus = GameStatus.IN_PROGRESS;
	private Characters hero;
	private Map map;
	private String lastLog;
	private int currentCase;
	private int heroId;
	private int heroPv;
	private int heroPa;
	private int mapId;
	

	public Game(String playerName,Characters hero,Map map) {
		this.playerName = playerName;
		this.hero = hero;
		this.getHeroId();
		this.heroPv=10;
		this.heroPa=5;
		this.map = map;
		this.mapId=1;
		this.getGameStatus();
		this.currentCase=0;
		this.lastLog="la partie commence";		
	}
	
	public Game(int id,String gameId,String playerName,int heroId,Characters characters, int MapId, String lastLog, int currentCase,int heroPa,int heroPv) {
		this.id=id;
		this.gameId=gameId;
		this.playerName = playerName;
		this.hero=characters;
		this.heroId=heroId;
		this.mapId=1;
		this.currentCase=currentCase;
		this.lastLog=lastLog;
		this.heroPa=heroPa;
		this.heroPv=heroPv;
	}
	
	public Game(String gameId,String playerName,String gameStatus,int heroId,int MapId, String lastLog, int currentCase) {
		this.gameId=gameId;
		this.playerName = playerName;
		this.heroId=heroId;
		this.mapId=1;
		this.gameStatus=GameStatus.IN_PROGRESS;
		this.currentCase=currentCase;
		this.lastLog="la partie commence";
	}

	@Override
	public String getPlayerName() {
		// TODO Auto-generated method stub
		return playerName;
	}

	@Override
	public String getGameId() {
		// TODO Auto-generated method stub
		return gameId;
	}
	

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public GameStatus setGameStatus(GameStatus status) {
		return this.gameStatus = status;
	}

	@Override
	public GameStatus getGameStatus() {
		// TODO Auto-generated method stub
		return gameStatus;
	}

	@Override
	public Characters getHero() {
		// TODO Auto-generated method stub
		return hero;
	}

	@Override
	public Map getMap() {
		// TODO Auto-generated method stub
		return map;
	}

	public String setLastLog(String log) {
		return this.lastLog = log;
	}

	@Override
	public String getLastLog() {
		// TODO Auto-generated method stub
		return lastLog;
	}

	public int setCurrentCase(int dice) {
		return this.currentCase = getCurrentCase()+dice;
	}

	@Override
	public int getCurrentCase() {
		// TODO Auto-generated method stub
		return currentCase;
	}


	public Characters getChar() {
		// TODO Auto-generated method stub
		return (Characters)hero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHeroId() {
		heroId=getHero().getId();
		return heroId;
	}

	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	public int getHeroPv() {
		return heroPv;
	}

	public void setHeroPv(int heroPv) {
		this.heroPv = getChar().getLife();
	}

	public int getHeroPa() {
		return heroPa;
	}

	public void setHeroPa(int heroPa) {
		this.heroPa = getChar().getAttackLevel();
	}

	public String moveHero(int dice, List<Cases> caseList) {
		// TODO Auto-generated method stub
		String action;
		if((getCurrentCase()+dice)>=64) {
			setGameStatus(GameStatus.FINISHED);
			action="la partie est fini";
		} else {
			setCurrentCase(dice);
			caseList.get(getCurrentCase()).event(getChar());;
			if(getChar().getLife()<=0) {
				this.heroPv=0;
				setGameStatus(GameStatus.GAME_OVER);
				action = "vous êtes mort ";
			}else {
				this.heroPv=getChar().getLife();
				this.heroPa=getChar().getAttackLevel();
				action=String.format( "Vous avez fait un lancé de %d \nVous etes sur la case n°%d\nil y a %s\nil vous reste %d pv\nvous avez %d pa"
						,dice,getCurrentCase(),caseList.get(getCurrentCase()).toString(),getChar().getLife(),getChar().getAttackLevel());
			}
		}
		return action;
	}


}
