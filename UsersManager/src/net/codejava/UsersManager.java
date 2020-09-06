package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersManager {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/sampledb";
		String dbUsername = "root";
		String dbPassword = "password";
		

		String username = "johndoe";

		try {
		Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbPassword);
		
			String sql = "DELETE FROM users WHERE username=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);

			
			
			int rows = statement.executeUpdate();
			
			if (rows > 0) {
				System.out.println("The user's information has been updated!");
			}
			
			
			connection.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
