package model;

public interface IObserver {

	void handleNotification(double frequency);
	void demandOpenGate(double frequency);
}
