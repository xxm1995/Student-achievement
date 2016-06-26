package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SqlUtils {
	public static final String DIRVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/cs01";
	public static final String USER = "root";
	public static final String PSWD= "root";
	static{
		try {
			Class.forName(DIRVER);
		} catch (ClassNotFoundException e) {
			new RuntimeException("cole");
		}
	}
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PSWD);
	}
}
