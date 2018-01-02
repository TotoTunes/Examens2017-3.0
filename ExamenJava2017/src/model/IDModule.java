package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import db.DAO;
import utilities.Generator;

public class IDModule implements ISubject {

	private ArrayList<User> UserList;
	ArrayList<User> Search;
	private double permittedFrequency;
	// Db object in deze klasse omdat men dan niet via de view aan de DB
	// functionaliteit kan. enkel de IDmodule moet dat kunnen
	private DAO db;

	/**
	 * @return the search
	 */
	public ArrayList<User> getSearch() {
		return Search;
	}

	/**
	 * @param search
	 *            the search to set
	 */
	public void setSearch(ArrayList<User> search) {
		Search = search;
	}

	/**
	 * @return the permittedFrequency
	 */
	public double getPermittedFrequency() {
		return permittedFrequency;
	}

	/**
	 * @param permittedFrequency
	 *            the permittedFrequency to set
	 */
	public void setPermittedFrequency(double permittedFrequency) {
		this.permittedFrequency = permittedFrequency;
	}

	/**
	 * @return the userList
	 */
	public ArrayList<User> getUserList() {
		return UserList;
	}

	/**
	 * @param userList
	 *            the userList to set
	 */
	public void setUserList(ArrayList<User> userList) {
		UserList = userList;
	}

	@Override
	public void removeObserver(User user) throws IOException, SQLException {
		UserList.remove(user);
		db.deleteDB(user);
	}

	@Override
	public void addObserver(User user) throws IOException, SQLException {
		UserList.add(user);
		db.insertDB(user);
	}

	@Override
	public void updateObserver(double frequency, User user) throws SQLException, IOException {
		user.setFrequency(frequency);
		db.updateDB(frequency);
	}

	@Override
	public void notifyAll(ArrayList<User> arrayList) throws SQLException, IOException {
		System.out.print("Udate Frequentie");
		for (User user : arrayList) {
			updateObserver(Generator.Randomfrequency(), user);
		}

	}

	/**
	 * @param userList
	 * @throws SQLException
	 * @throws IOException
	 */
	public IDModule() throws IOException, SQLException {
		super();
		setDb(new DAO());
		UserList = db.loadUserFromDB();

		if (UserList.isEmpty() == true) {

			setPermittedFrequency(Generator.Randomfrequency());
		} else {
			setPermittedFrequency(UserList.get(0).getFrequency());
		}

	}

	public User GetSpecificUser(int index, ArrayList<User> list) {
		User user = list.get(index);
		return user;
	}

	@SuppressWarnings("unused")
	public String GetSpecificUser(String naam) {
		User hUser = null;
		Search = new ArrayList<>();
		StringBuffer buffer = new StringBuffer();
		int i = 0;
		for (User user : UserList) {
			if (user.getLastName().contains(naam.toUpperCase()) == true
					|| user.getFirstName().contains(naam.toUpperCase()) == true) {
				hUser = user;
				buffer.append(++i + " " + hUser.toString());
				Search.add(user);
			}
		}
		if (Search.isEmpty() == true) {
			buffer.append("geen resultaat gevonden");
		}
		return buffer.toString();
	}

	@Override
	public void openGate(User user) throws SQLException, IOException {
		if (user.getFrequency() == permittedFrequency && user.isAcces() == true) {
			System.out.println("Poort Open");
		} else if (user.getFrequency() != permittedFrequency && user.isAcces() == true) {
			updateObserver(permittedFrequency, user);
			JOptionPane.showMessageDialog(null, "Poort Open en frequency updated");
		} else if (user.getFrequency() != permittedFrequency && user.isAcces() == false) {
			JOptionPane.showMessageDialog(null, "Acces denied, user removed");
		}
	}

	public String toString(User user) {
		String beschrijving = "Ik ben " + user.getFirstName() + " " + user.getLastName() + " ( Frequency "
				+ user.getFrequency() + ", Toegang " + user.isAcces() + " )";
		return beschrijving;
	}

	public StringBuffer allToString() {
		StringBuffer buffer = new StringBuffer();
		for (User user : UserList) {
			buffer.append(toString(user) + "\n");
		}
		return buffer;
	}

	public DAO getDb() {
		return db;
	}

	public void setDb(DAO db) {
		this.db = db;
	}

}
