package utilities;

import java.util.ArrayList;
import java.util.Random;

import model.User;

public class Generator {

	private static Random rand = new Random();
	private static ArrayList<Double> FrequencyList = new ArrayList<Double>();

	public static String GenerateVoornaam() {

		VoornaamEnum voornaam = VoornaamEnum.values()[rand.nextInt(VoornaamEnum.values().length)];
		String result = voornaam.toString();
		return result;
	}

	public static String GenerateAchternaam() {
		AchternaamEnum achternaam = AchternaamEnum.values()[rand.nextInt(AchternaamEnum.values().length)];
		String result = achternaam.toString();
		return result;
	}


	public static double Randomfrequency() {
		int a = rand.nextInt(900);
		double b = rand.nextDouble();
		if (FrequencyList.contains(a + b) == true) {
			Randomfrequency();
		} else {
			AddFrequency(a + b);
		}

		return a + b;
	}

	private static void AddFrequency(double a) {
		FrequencyList.add(a);
	}

	public static void ClearFrequencyList() {
		FrequencyList.clear();
	}
	public static User GenerateUsers(double frequency){
		User aUser = new User(true, frequency, GenerateAchternaam(), GenerateVoornaam());
		return aUser;
	}
}
