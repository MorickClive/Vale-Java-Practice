package com.mc.main.java8.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// In order to work our database, we need some form of stable connection
// to our SQL database server.
//
// We'll use DatabaseConnection as a means to store this connection and credentials required to
// access the database
public class DatabaseConnection {

	private static Connection activeConnection;
	private static String URL;
	private static String username;
	private static String password;

	// For this example, we'll only ever have one connection active at a time
	// we won't want more than one instance able to connect at a given time.
	private DatabaseConnection() {
		super();
	}
	
	// This will be our means of acquiring a connection instance
	// it'll handle setup requirements and provide us with either an existing connection
	// or initialise a new connection.
	public static Connection getConnection() {
		if (activeConnection == null) {
			initConnection();
		}
		return activeConnection;
	}
	
	// As part of creating a connection instance, we need to use a DriverManager class
	// with the right address and credentials in order to establish a connection.
	private static void initConnection() {
			try {
				readProperties();
				activeConnection = DriverManager.getConnection(URL, username, password);
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
	}
	
	// It's a bad idea to hard code sensitive data into our applications
	// for this reason, the Database Connection class reads user credentials from a properties.
	//
	// We can use a mention of the respective resource folder to avoid uploading these resources to
	// our public repositories.
	public static void readProperties() throws IOException {
		Properties props = new Properties();
		InputStream is = DatabaseConnection.class.getClassLoader().getResourceAsStream("db.properties");
		
		props.load(is);

		URL = props.get("URL") + "?serverTimezone=UTC";
		username = (String) props.get("Username");
		password = (String) props.get("Password");		
	}

	// Like any resource, we want to close our connection to ensure the database isn't waiting
	// for a close signal; preventing misuse of our database connection and improving
	// liveliness of our database access.
	public static void close() {
		try {
			if (activeConnection != null) {
				activeConnection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	};

}
