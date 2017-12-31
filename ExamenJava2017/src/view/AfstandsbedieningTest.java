package view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import model.IDModule;
import model.User;
import utilities.Generator;

@SuppressWarnings("serial")
public class AfstandsbedieningTest extends JComponent {

	/*
	 * TO DO
	 * 
	 * Inladen van gebruikers die al in de database zitten bij opstarten programma
	 * -> altijd gaan zoeken naar user in DB
	 * 
	 * user verwijderen en zoeken op naam -> meerdere resultaten mogelijk dus
	 * allemaal tonen Poort openen (signaal van user naar module) Functie al
	 * geschreven in IDmodule -> ok? individuele gebruiker toevoegen frequentie
	 * manueel veranderen? -> om te testen?
	 * 
	 */

	public static void main(String[] args) throws IOException, SQLException {

		int r = 1;
		IDModule module = new IDModule();
		Random random = new Random();
		do {

			String a = JOptionPane.showInputDialog(
					"Geef je keuze in: \n Willekeurige users maken = 1 \n user verwijderen = 2 \n Frequentie veranderen = 3\n Nieuwe User invoeren = 4 \n Poort openen = 5");
			int keuze = Integer.parseInt(a);

			switch (keuze) {

			case 1:
				StringBuffer alles = new StringBuffer();
				for (int i = 0; i < 50; ++i) {
					User aUser = Generator.GenerateUsers(module.getPermittedFrequency());
					module.addObserver(aUser);
					alles.append(aUser.toString());	
				}
				int g = Integer.parseInt(JOptionPane.showInputDialog(alles));
				// logger.info(alles.toString());
				break;
			case 2:
				String achternaam = JOptionPane.showInputDialog("Geef een naam in: ");
				JOptionPane.showMessageDialog(null, module.GetSpecificUser(achternaam));
				break;
			case 3:
				module.setPermittedFrequency(Generator.Randomfrequency());
				StringBuffer all = new StringBuffer();
				for (User bUser : module.getUserList()) {
					module.updateObserver(module.getPermittedFrequency(), bUser);
					all.append(bUser.toString());
				}
				JOptionPane.showMessageDialog(null, all.toString());
				break;
			case 4:
				String lastname = JOptionPane.showInputDialog("Geef de achternaam in");
				String firstname = JOptionPane.showInputDialog("Geef de voornaam in");
				module.addObserver(new User(true, module.getPermittedFrequency(), lastname, firstname));
				break;

			case 5:
				for (User user : module.getUserList()) {
					module.openGate(user);
				}

				break;
			default:
				System.out.println("Fout");
				break;
			}

		} while (r < 2);

		// JFrame frame = new JFrame("Test");
		// JTextField textField = new JTextField();
		// textField.setText("looooooooool");
		// textField.setSize(100,50);
		// textField.setVisible(true);
		// textField.setBackground(new Color(10, 150, 200));
		//
		//
		// frame.add(textField);
		// frame.setVisible(true);
		// frame.setSize(500, 500);
	}

}
