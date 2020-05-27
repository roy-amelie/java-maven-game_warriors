package amelie.campus.java_warriors;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DAO.GameStateDAO;
import DAO.HeroDAO;
import DAO.JDBC.ConnectBDD;
import game.Game;
import warriors.characters.Characters;
import warriors.contracts.GameState;
import warriors.contracts.GameStatus;
import warriors.contracts.Hero;
import warriors.contracts.Map;
import warriors.contracts.WarriorsAPI;
import warriors.engine.Warriors;

public class ClientConsole {

	private static String MENU_COMMENCER_PARTIE = "1";
	private static String MENU_CHARGER_PARTIE="2";
	private static String MENU_QUITTER = "3";
	public static WarriorsAPI warriors;
	public static void main(String[] args) {
		
		if(args.length>0) {
			warriors = new Warriors(args[1]);
		}else {
			warriors = new Warriors();
		}
		
		Scanner sc = new Scanner(System.in);
		String menuChoice = "";
		do {
			menuChoice = displayMenu(sc);
			if(menuChoice.equals(MENU_COMMENCER_PARTIE)) {					
				startGame(warriors, sc);
			} else if (menuChoice.equals(MENU_CHARGER_PARTIE)) {
				loadGame(sc);
			}
		}while(!menuChoice.equals(MENU_QUITTER));
		sc.close();
		System.out.println("� bient�t");
	}

	private static void loadGame(Scanner sc) {
		GameStateDAO gameStateDao = new GameStateDAO(ConnectBDD.getInstance());
		List <Game> gameList = new ArrayList<Game>();
		gameList = gameStateDao.findAll();
		for (int i = 0; i <gameList.size(); i++) {
			System.out.println(String.format("%d - joueur: %s , map: %s, points de vie: %d, niveau d\'attaque: %d ", 
					i, gameList.get(i).getPlayerName(),gameList.get(i).getMapId(),gameList.get(i).getHeroPv(),gameList.get(i).getHeroPa()));
		}
		int id=gameList.get(Integer.parseInt(sc.nextLine())).getId();
		GameState gameState= gameStateDao.findById(id);
		HeroDAO heroDao=new HeroDAO(ConnectBDD.getInstance());
		Characters hero = heroDao.findById(id);
		hero.setAttackLevel(((Game) gameState).getHeroPa());
		hero.setLife(((Game) gameState).getHeroPv());
		
		String gameId= gameState.getGameId();
		
		while (gameState.getGameStatus() == GameStatus.IN_PROGRESS) {
			System.out.println(gameState.getLastLog());
			System.out.println("\nAppuyer sur une touche pour lancer le d�"); 
			if(sc.hasNext()) {
				sc.nextLine();
				gameState = warriors.nextTurn(gameId);
			}							
		}
	}

	private static void startGame(WarriorsAPI warriors, Scanner sc) {
		System.out.println();
		System.out.println("Entrez votre nom:");
		String playerName = sc.nextLine();

		System.out.println("Choisissez votre h�ro:");
		for(int i = 0; i < warriors.getHeroes().size(); i++) {
			Hero heroe = warriors.getHeroes().get(i);
			System.out.println(i+1 + " - " + heroe.getName());
			System.out.println("    Force d'attaque : " + heroe.getAttackLevel());
			System.out.println("    Niveau de vie : " + heroe.getLife());
		}
		Hero chosenHeroe = warriors.getHeroes().get(Integer.parseInt(sc.nextLine()) - 1);

		System.out.println("Choisissez votre map:");
		for(int i = 0; i < warriors.getMaps().size(); i++) {
			Map map = warriors.getMaps().get(i);
			System.out.println(i+1 + " - " + map.getName());
		}
		Map choosenMap = warriors.getMaps().get(Integer.parseInt(sc.nextLine()) - 1);

		GameState gameState = warriors.createGame(playerName, chosenHeroe, choosenMap);
		String gameId = gameState.getGameId();
		while (gameState.getGameStatus() == GameStatus.IN_PROGRESS) {
			System.out.println(gameState.getLastLog());
			System.out.println("\nAppuyer sur une touche pour lancer le d�"); 
			if(sc.hasNext()) {
				sc.nextLine();
				gameState = warriors.nextTurn(gameId);
			}							
		}

		System.out.println(gameState.getLastLog());
	}

	private static String displayMenu(Scanner sc) {
		System.out.println();
		System.out.println("================== Java Warriors ==================");
		System.out.println("1 - Commencer une partie");
		System.out.println("2 - Charger une partie");
		System.out.println("3 - Quitter"); 
		if(sc.hasNext()) {
			String choice = sc.nextLine();
			return choice;
		}		

		return "";
	}
}

