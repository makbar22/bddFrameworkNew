package basics.selenium06112020;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.opencsv.CSVWriter;

public class JDBCUtility {

	// 1. declare private static connection object of connection class
	private static Connection connection; // this will connect our script to database

	// 2. declare private static statement object of statement class
	private static Statement statement; // this will execute the query we are passing

	// 3. declare private static ResultSet object of ResultSet class
	private static ResultSet resultSet; // this will store the retrieved data from query execution

	// 4.syntax for Postgresql URL: jdbc:postgresql://host:port/databaseName
	private static String url = "jdbc:postgresql://localhost:5432/dvdrental";

	// 5.user name for database
	private static String userName = "postgres";

	// 6.password for database
	private static String password = "root";

	// 7.create connection to database
	public static void setupDBConnection() { // this method will connect us to the database
		try {
			connection = DriverManager.getConnection(url, userName, password);

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	public static ResultSet runQuery(String query) {

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultSet;

	}

	public static void returnResult() {// return or store the results

		try {
			while (resultSet.next()) {
				// write any code to do with results
				// you can print it to console
				// you can store it in an object array
				// you can write it to excel or csv file

				CSVWriter csvWriter; // to write it in csv
				File file = new File(
						"C:\\Users\\murta\\eclipse-workspace\\SeleniumProject.Feb2020\\testDataOutput\\book.csv");
				// FileWriter class to write in CSV file
				try {
					FileWriter filewriter = new FileWriter(file);
					csvWriter = new CSVWriter(filewriter);
					csvWriter.writeAll(resultSet, true);
					csvWriter.close();

				} catch (SQLException e) {

				} catch (IOException e) {
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// close the database connection
	public static void closeDBConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {

			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}