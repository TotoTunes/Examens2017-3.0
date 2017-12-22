package model;

import java.util.ArrayList;

public interface ISubject {
	void removeObserver (User user);
	void addObserver(User user);
	void updateObserver(double frequency, User user);
	void notifyAll(ArrayList<User> arrayList);
	void openGate(double frequency);
}
