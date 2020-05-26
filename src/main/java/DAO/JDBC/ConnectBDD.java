package DAO.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectBDD {
	private static String url = "jdbc:mysql://localhost:3306/warriors?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String user = "amelie";
	private static String passwd = "Nathan/2610";
	private static Connection connect;


	public static Connection getInstance() {
		if(connect == null){
			try {
				connect = DriverManager.getConnection(url, user, passwd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connect;   
	}   

}
