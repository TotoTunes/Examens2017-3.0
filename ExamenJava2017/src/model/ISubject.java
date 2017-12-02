package model;

import java.util.ArrayList;

public interface ISubject {
	void RemoveObserver (User user);
	void AddObserver(User user);
	void UpdateObserver(double frequency, User user);
	void NotifyAll(ArrayList<User> arrayList);
}
