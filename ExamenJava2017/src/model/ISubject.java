package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ISubject {
	void removeObserver (User user) throws IOException, SQLException;
	void addObserver(User user) throws IOException, SQLException;
	void updateObserver(double frequency, User user);
	void notifyAll(ArrayList<User> arrayList);
	void openGate(User user);
}
