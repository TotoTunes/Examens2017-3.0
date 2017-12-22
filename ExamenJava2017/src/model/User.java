package model;

import javax.security.auth.Subject;

public class User implements IObserver {


	private boolean acces;
	private double frequency;
	private String lastName;
	private String firstName;
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the name
	 */

	/**
	 * @return the acces
	 */
	public boolean isAcces() {
		return acces;
	}
	/**
	 * @param acces the acces to set
	 */
	public void setAcces(boolean acces) {
		this.acces = acces;
	}
	/**
	 * @return the frequency
	 */
	public double getFrequency() {
		return frequency;
	}
	/**
	 * @param frequency the frequency to set
	 */
	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}
	@Override
	public void handleNotification(double frequency) {
		setFrequency(frequency);
		
	}

	/**
	 * @param acces
	 * @param frequency
	 * @param lastName
	 * @param firstName
	 */
	public User(boolean acces, double frequency, String lastName, String firstName) {
		super();
		this.acces = acces;
		this.frequency = frequency;
		this.lastName = lastName;
		this.firstName = firstName;
	}
	public String toString() {
		String beschrijving = firstName+" "+lastName+" "+frequency+"\n";
		return beschrijving;
	}
}

