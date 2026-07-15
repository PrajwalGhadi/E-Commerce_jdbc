package com.ecommerce.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBconfig
{

	// Private variable for connection as only accessible within class
	private static Connection dbConnection;
	private static final Properties properties = new Properties();
	static {
		try (InputStream input = DBconfig.class.getClassLoader().getResourceAsStream("db.properties")) {

			if (input == null) {
				throw new RuntimeException("db.properties file not found.");
			}

			properties.load(input);

		} catch (IOException e) {
			throw new RuntimeException("Unable to load db.properties", e);
		}
	}

	// Creating the Method to connect the database and returning the connection
	// after successfully connect
	public static Connection getConnection() {

		// Checking if dbConnection has the connection then I will directly return or
		// else I will create new connection
		if (dbConnection == null) {
			try {
				dbConnection = DriverManager.getConnection(properties.getProperty("db.url"),
						properties.getProperty("db.username"), properties.getProperty("db.password"));

				System.out.println("\n---- Connected To Database... ----\n");

				return dbConnection;
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}

		// Because here I am returning connection back if already exists that's why I
		// have removed my method getConnection()
		return dbConnection;
	}

	// Creating method for close connection
	public static void closeConnection() {
		try {
			dbConnection.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}
