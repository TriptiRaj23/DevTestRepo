package com.GFAssignmentProj.CustomerApp;
import java.sql.*;

public class TestConnection {

	public static Connection createConnectionToPostgre() {
		Connection c = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CustomerDataBase", "postgres", "postgres");
			System.out.println("New Connection Created");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return c;
	}
}
