package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import game.Game;
import warriors.characters.Characters;

public class GameStateDAO extends DAO<Game>{

	public GameStateDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Game obj) {
		try {
			PreparedStatement ps =this.connect.prepareStatement("INSERT INTO GameState "
					+ "(`gameId`,`playerName`,`heroId`,`MapId`,`lastLog`,`currentCase`,`heroPa`,`heroPv`,`hero_id`)"
					+ " VALUES (?,?,?,?,?,?,?,?,?)"
					,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,obj.getGameId());
			ps.setString(2, obj.getPlayerName());
			ps.setInt(3, obj.getHeroId());
			ps.setInt(4, obj.getMapId());
			ps.setString(5, obj.getLastLog());
			ps.setInt(6, obj.getCurrentCase());
			ps.setInt(7, obj.getHeroPa());
			ps.setInt(8, obj.getHeroPv());
			ps.setInt(9, obj.getHeroId());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				int id=rs.getInt(1);
				obj.setId(id);
				obj.setGameId("game_"+id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean delete(Game obj) {
		try {
			PreparedStatement ps=this.connect.prepareStatement("DELETE FROM GameState WHERE `id`=?");
			ps.setInt(1,obj.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean update(Game obj) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps=this.connect.prepareStatement("UPDATE GameState "
					+ "SET `gameId`=?,`playerName`=?,`heroId`=?,`mapId`=?,`lastLog`=?,`currentCase`=?,`heroPa`=?,`heroPv`=?  "
					+ "WHERE `id`=?");
			ps.setString(1, obj.getGameId());
			ps.setString(2, obj.getPlayerName());
			ps.setInt(3, obj.getHeroId());
			ps.setInt(4,obj.getMapId());
			ps.setString(5, obj.getLastLog());
			ps.setInt(6,obj.getCurrentCase());
			ps.setInt(7, obj.getHeroPa());
			ps.setInt(8, obj.getHeroPv());
			ps.setInt(9, obj.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Game findById(int id) {
		// TODO Auto-generated method stub
		Game gameState = null;
		try {
			ResultSet result= this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM GameState Where id="+id);
			if(result.first()) {
				Characters hero = new HeroDAO(this.connect).findById(result.getInt("heroId"));
				hero.setAttackLevel(result.getInt("heroPa"));
				hero.setLife(result.getInt("heroPv"));
				gameState= new Game(
						id,
						result.getString("gameId"),
						result.getString("playerName"),
						result.getInt("heroId"),
						hero,
						result.getInt("MapId"),
						result.getString("lastLog"),
						result.getInt("currentCase"),
						result.getInt("heroPa"),
						result.getInt("heropv"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gameState;
	}

	@Override
	public List<Game> findAll() {
		// TODO Auto-generated method stub
		List<Game> gameList= new ArrayList<Game>();
		try {
			ResultSet result= this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM GameState");
			while(result.next()) {
				Characters hero = new HeroDAO(this.connect).findById(result.getInt("heroId"));
				hero.setAttackLevel(result.getInt("heroPa"));
				hero.setLife(result.getInt("heroPv"));
				gameList.add( new Game(
						result.getInt("id"),
						result.getString("gameId"),
						result.getString("playerName"),
						result.getInt("heroId"),
						hero,
						result.getInt("MapId"),
						result.getString("lastLog"),
						result.getInt("currentCase"),
						result.getInt("heroPa"),
						result.getInt("heropv")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gameList;
	}

}
