package model;

public class User implements IObserver {

	private String name;
	private boolean acces;
	private double frequency;
	/**
	 * @return the name
	 */
	
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
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
	public void HandleNotification(double frequency) {
		setFrequency(frequency);
		
	}
	public User(String name, boolean acces, double frequency) {
		super();
		this.name = name;
		this.acces = acces;
		this.frequency = frequency;
	}
	public String toString() {
		String beschrijving = name+" "+frequency+"\n";
		return beschrijving;
	}

}
