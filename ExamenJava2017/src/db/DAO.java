package db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

public class DAO {

	// Connection connection =
	// DriverManager.getConnection("jdbc:mysql://localhost:3306/afstandsbediening","root","Twdih300");
	String url = "jdbc:mysql://localhost:3306/afstandsbediening";
	// String user = "root@localhost";
	// String password = "Twdih300";
	// String Query = "Select * from afstandsbediening.bewoners";

	private Properties properties;
	private Connection connection; 
	private Properties GetDBproperties(String filename) throws IOException {
		properties = new Properties();
		try {
			FileInputStream fileInputStream = new FileInputStream(filename);
			properties.load(fileInputStream);
			fileInputStream.close();
		} catch (FileNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "verbinding niet gelukt");
			e1.printStackTrace();
		}

		return properties;

	}

	public void ConnectDB() throws IOException {
		GetDBproperties("DBproperties.properties");
		try (Connection connection = DriverManager.getConnection(url, properties.getProperty("user"), properties.getProperty("password"))) {
			System.out.println("Database connected!");
		} catch (SQLException e) {
			throw new IllegalStateException("Cannot connect the database!", e);
		}
	}

}