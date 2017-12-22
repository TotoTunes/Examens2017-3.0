package model;

import java.util.ArrayList;

import utilities.Generator;

public class IDModule implements ISubject {

	private ArrayList<User> UserList;
	private double permittedFrequency;

	/**
	 * @return the permittedFrequency
	 */
	public double getPermittedFrequency() {
		return permittedFrequency;
	}

	/**
	 * @param permittedFrequency the permittedFrequency to set
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
	public void addObserver(User user) {
		UserList.add(user);
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
	 */
	public IDModule() {
		super();
		UserList = new ArrayList<User>();
		setPermittedFrequency(Generator.Randomfrequency());
	}
	public User GetSpecificUser(int index) {
		User user = UserList.get(index);
		return user;
	}
	public User GetSpecificUser(String naam) {
		User hUser = null;
		for (User user : UserList) {
			if (user.getLastName().contains(naam.toUpperCase())==true || user.getFirstName().contains(naam.toUpperCase())== true) {
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
		}
		else if (user.getFrequency() != permittedFrequency && user.isAcces() == true) {
			updateObserver(permittedFrequency, user);
			System.out.println("Poort Open en frequency updated");
		}
		else if (user.getFrequency() != permittedFrequency && user.isAcces() == false) {
			System.out.println("Acces denied, user removed");
		}
	}

}
