package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import game.Game;

public class GameStateDAO extends DAO<Game>{

	public GameStateDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Game obj) {
		// TODO Auto-generated method stub
		int id=0;
		try {
			PreparedStatement ps =this.connect.prepareStatement("INSERT INTO GameState (`gameId`,`playerName`,`heroId`,`MapId`,`lastLog`,`currentCase`) VALUES (?,?,?,?,?,?)"
					,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,obj.getGameId());
			ps.setString(2, obj.getPlayerName());
			ps.setInt(3, obj.getHeroId());
			ps.setInt(4, obj.getMapId());
			ps.setString(5, obj.getLastLog());
			ps.setInt(6, obj.getCurrentCase());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				id=rs.getInt(1);
				obj.setId(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(id);
		return true;
	}

	@Override
	public boolean delete(Game obj) {
		// TODO Auto-generated method stub
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
			PreparedStatement ps=this.connect.prepareStatement("UPDATE GameState SET `gameId`=?,`playerName`=?,`heroId`=?,`mapId`=?,`lastLog`=?,`currentCase`=?  WHERE `id`=?");
			ps.setString(1, obj.getGameId());
			ps.setString(2, obj.getPlayerName());
			ps.setInt(3, obj.getHeroId());
			ps.setInt(4,obj.getMapId());
			ps.setString(5, obj.getLastLog());
			ps.setInt(6,obj.getCurrentCase());
			ps.setInt(7, obj.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Game find(int id) {
		// TODO Auto-generated method stub
		Game gameState = null;
		try {
			ResultSet result= this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM GameState Where id="+id);
			if(result.first()) 
				gameState= new Game(
						id,
						result.getString("gameId"),
						result.getString("playerName"),
						result.getInt("heroId"),
						result.getInt("MapId"),
						result.getString("lastLog"),
						result.getInt("currentCase"));
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
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Hero");
			while(result.next()) 
				gameList.add( new Game(
						result.getInt("id"),
						result.getString("gameId"),
						result.getString("playerName"),
						result.getInt("heroId"),
						result.getInt("MapId"),
						result.getString("lastLog"),
						result.getInt("currentCase")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gameList;
	}

}
