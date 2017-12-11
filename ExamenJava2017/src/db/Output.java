package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Output {

	// Connection connection =
	// DriverManager.getConnection("jdbc:mysql://localhost:3306/afstandsbediening","root","Twdih300");
	String url = "jdbc:mysql://localhost:3306/afstandsbediening";
	String user = "root@localhost";
	String password = "Twdih300";
	String Query = "Select * from bewoners";

	public void ConnectDb() {

		try (Connection conn = DriverManager.getConnection(url, user, password);
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