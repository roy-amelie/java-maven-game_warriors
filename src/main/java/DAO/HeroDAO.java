package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import game.Game;
import warriors.characters.Characters;
import warriors.characters.Warrior;
import warriors.characters.Wizard;


public class HeroDAO extends DAO<Characters>{

	public HeroDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Characters obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Characters obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Characters obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Characters find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Characters> findAll() {
		List<Characters> heroList= new ArrayList<Characters>();
		try {
			ResultSet result= this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Hero");
			while(result.next()) 
				if(result.getString("name").equals("warrior")) {
					heroList.add( new Warrior(
							result.getInt("id"),
							result.getString("type"),
							result.getString("name"),
							result.getString("Image"),
							result.getInt("life"),
							result.getInt("force"),
							result.getString("equipement")));
				} else if (result.getString("name").equals("wizard")) {
					heroList.add( new Wizard(
							result.getInt("id"),
							result.getString("type"),
							result.getString("name"),
							result.getString("Image"),
							result.getInt("life"),
							result.getInt("force"),
							result.getString("equipement")));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return heroList;
	}

	

}
