package com.mc.main.java8;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mc.main.java8.jdbc.DatabaseConnection;
import com.mc.main.util.Practice;
import com.mc.main.util.ReportFormater;

public class JDBCPractice extends Practice {

	private JDBCPractice() {
		super();
	}

	public static void start() {
		String relativePath = new File("").getAbsolutePath();
		File JDBCprops = new File(relativePath + "/src/main/resources/db.properties");

		if (JDBCprops.exists()) {
			printHeader("JDBC");
			System.out.println();

			// In order to work with SQL databases, we need a new Library to assist us:
			// <groupId>mysql</groupId>
			// <artifactId>mysql-connector-java</artifactId>
			//
			// This will give us access to the Connection and DriverManager classes - 
			// these classes will allow us to establish a resource connection.
			//
			// Let's review our DatabaseConnection class to see how we can manage our connection
			// Separately from our queries.
			Connection connection = DatabaseConnection.getConnection();
			
			// Our Connection allows us to create statements that allow us to execute
			// SQL queries.
			// 
			// When we expect a result from our query, it maybe in a table format
			// the ResultSet class acts like an Iterator Pattern object
			// so that we might access each row via a iteration cycle of that returned result.
			Statement statement;
			ResultSet rs;

			try {
				// First let's create a statement object based on our active connection
				// this can fail - so it requires a try block to capture exceptions.
				//
				// Consider that our connection might be fine - but if the SQL server or it's hardware
				// platform fails, we might get exceptions from our requests to a faulty host.
				statement = connection.createStatement();

				// Observer the below, review how we can execute queries, but also 
				// review our data based on ResultSets that are returned to us.
				
				// DDL
				// ========================================
				// DELETE
				statement.execute("DROP TABLE IF EXISTS example");
				// CREATE
				statement.execute("CREATE TABLE example(ID varchar(255), Name varchar(255))");

				// DML
				// ========================================
				ReportFormater.reportHeader("\tREAD + CREATE:");
				// CREATE
				statement.execute("INSERT INTO example VALUES (\"ONE\", \"Word\")");
				statement.execute("INSERT INTO example VALUES (\"TWO\", \"Other Word\")");

				// READ
				rs = statement.executeQuery("SELECT * FROM example;");
				readExample(rs);

				// Update
				System.out.println();
				ReportFormater.reportHeader("\tUPDATE:");
				statement.execute("UPDATE example SET ID = 'THREE', Name = 'New' WHERE ID = \"ONE\"");

				rs = statement.executeQuery("SELECT * FROM example");
				readExample(rs);

				// DELETE
				System.out.println();
				ReportFormater.reportHeader("\tDELETE:");
				statement.execute("DELETE FROM example WHERE ID='TWO'");

				rs = statement.executeQuery("SELECT * FROM example");
				readExample(rs);

				// Clear Table
				statement.execute("DROP TABLE IF EXISTS example");
				System.out.println();
				
				// Ideally we'd close our connection here, our connection has done its job and should be freed
				// up for other consumers of the database.
				// 
				// Connections can autoclose - but it's best practice to close our resources
				// when we are finished with them. It promotes security, application liveliness and
				// shared resource access!
				
				// In this application, the singular connection is release at the end of the
				// Runner.main method in the same fashion as our inputstream from our Console!

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void readExample(ResultSet rs) throws SQLException {
		while (rs.next()) {
			System.out.format("ID: %s, Name: %s\n", rs.getString(1), rs.getString(2));
		}
	}

}
