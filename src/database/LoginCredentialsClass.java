package database;

import java.sql.*;

public class LoginCredentialsClass extends DatabaseConnectivity{
	public static String getPassword(String userName) {
		try {
			Statement passwordStatement = databaseConnector.createStatement();
			ResultSet resultSet = passwordStatement.executeQuery(selectLoginQuery + "'" + userName + "';" );
			String password  = null;
			while(resultSet.next()) password = resultSet.getString(1);
			return password;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static boolean changePassword(String userName, String password)
	{
		try {
			PreparedStatement passwordStatement = databaseConnector.prepareStatement(updatePassQuery);			
			passwordStatement.setString(1, password);
			passwordStatement.setString(2, userName);
			int status = passwordStatement.executeUpdate();
			if(status == 1) return true;
			return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
