package db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Output {

	// Connection connection =
	// DriverManager.getConnection("jdbc:mysql://localhost:3306/afstandsbediening","root","Twdih300");
	String url = "jdbc:mysql://localhost:3306/afstandsbediening";
	String user = "root@localhost";
	String password = "Twdih300";
	String Query = "Select * from bewoners";
	private Properties properties; 
	

	public void ConnectDb(String filename) throws IOException {
		properties = new Properties();
		try {
			FileInputStream fileInputStream = new FileInputStream(filename);
			properties.load(fileInputStream);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password"));
				Statement stmt = conn.createStatement();
				ResultSet resultSet = stmt.executeQuery(Query);) {
			ResultSetMetaData metaData = resultSet.getMetaData();
			int numberofcollumns = metaData.getColumnCount();

			System.out.println("Waarden in bewoners : %n%n");

			for (int i = 1; i <= numberofcollumns; i++) {
				System.out.printf("%-8s\t", resultSet.getObject(i));
				System.out.println();
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Verbindingn niet gelukt");
		}

	}

}