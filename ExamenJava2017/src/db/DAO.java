package db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import utilities.Generator;

public class DAO {

	String Query = "Select * from afstandsbediening.bewoners";

	private Properties properties;
	private Connection conn;

	/**
	 * @return the conn
	 */
	public Connection getConn() {
		return conn;
	}

	/**
	 * @param conn
	 *            the conn to set
	 */
	public void setConn(Connection conn) {
		this.conn = conn;
	}

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

	public Connection ConnectDB() throws IOException {
		Connection connection;
		GetDBproperties("DBproperties.properties");
		try {
			connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),
					properties.getProperty("password"));
			System.out.println("Database connected!, Dit moet nog verwijderd worden");
		} catch (SQLException e) {
			throw new IllegalStateException("Cannot connect the database!", e);
		}
		return connection;
	}

	public void QueryDB() throws IOException, SQLException {
		conn = ConnectDB();
		Statement statement = (Statement) conn.createStatement();
		ResultSet resultSet = statement.executeQuery(Query);
		while (resultSet.next()) {
			String voornaam = resultSet.getString("voornaam");
			String achternaam = resultSet.getString("achternaam");
			double frequency = resultSet.getDouble("frequency");
			boolean acces = resultSet.getBoolean("acces");

			System.out.println(voornaam + " " + achternaam + " " + frequency + " " + acces);
		}
		statement.close();
		resultSet.close();
	}

	public void updateDB() throws IOException, SQLException {
		conn = ConnectDB();
		Statement statement = (Statement) conn.createStatement();
		
		String insert = "insert into bewoners(voornaam, achternaam, frequency, acces)  values ('"+ Generator.GenerateVoornaam()+"','"+Generator.GenerateAchternaam()+"', "+1+", TRUE)";
		statement.execute(insert);
		statement.close();
	}
}