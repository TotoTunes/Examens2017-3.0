package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DAO;
import utilities.Generator;

public class IDModule implements ISubject {

	private ArrayList<User> UserList;
	private double permittedFrequency;
	// Db object in deze klasse omdat men dan niet via de view aan de DB functionaliteit kan. enkel de IDmodule moet dat kunnen
	private DAO db;

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
	public void removeObserver(User user) {
		UserList.remove(user);
	}

	@Override
	public void addObserver(User user) throws IOException, SQLException {
		UserList.add(user);
		db.updateDB(user);
	}

	@Override
	public void updateObserver(double frequency, User user) {
		user.setFrequency(frequency);
	}

	@Override
	public void notifyAll(ArrayList<User> arrayList) {
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

		setPermittedFrequency(Generator.Randomfrequency());
	}

	public User GetSpecificUser(int index) {
		User user = UserList.get(index);
		return user;
	}

	public User GetSpecificUser(String naam) {
		User hUser = null;
		for (User user : UserList) {
			if (user.getLastName().contains(naam.toUpperCase()) == true
					|| user.getFirstName().contains(naam.toUpperCase()) == true) {
				hUser = user;
				;
				break;

			}
		}
		return hUser;
	}

	@Override
	public void openGate(User user) {
		if (user.getFrequency() == permittedFrequency && user.isAcces() == true) {
			System.out.println("Poort Open");
		} else if (user.getFrequency() != permittedFrequency && user.isAcces() == true) {
			updateObserver(permittedFrequency, user);
			System.out.println("Poort Open en frequency updated");
		} else if (user.getFrequency() != permittedFrequency && user.isAcces() == false) {
			System.out.println("Acces denied, user removed");
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
			buffer.append(toString(user));
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
