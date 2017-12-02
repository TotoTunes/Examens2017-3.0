package testingJUnit;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.junit.Test;

import utilities.Generator;

public class TestGenerator {

	@Test
	public void test() {
		ArrayList<String> naamlijst = new ArrayList<String>();
		System.getProperty("line.seperator");

		for (int j = 0; j < 50; j++) {
			String arg0 = Generator.GenerateNaam();
			naamlijst.add(arg0);
			Generator.Randomfrequency();
		}

		String alles = null;
		for (String string : naamlijst) {
			alles += string + "\n";
		}
		JOptionPane.showMessageDialog(null, alles);
		Generator.ClearFrequencyList();
	}

}
