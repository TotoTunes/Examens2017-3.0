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

	public Connection ConnectToDB() throws IOException, SQLException {
		GetDBproperties("DBproperties.properties");
		if (connection == null) {
			try {
				Class.forName(properties.getProperty("driver"));
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
			connection = DriverManager.getConnection(url, properties);
		}
		return connection;
	}

}