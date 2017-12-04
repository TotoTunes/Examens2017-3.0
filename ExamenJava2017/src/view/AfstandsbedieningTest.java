package view;

import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import model.IDModule;
import model.User;
import utilities.Generator;

@SuppressWarnings("serial")
public class AfstandsbedieningTest extends JComponent {

	// public static Logger logger = Logger.getLogger(AfstandsbedieningTest.class);
	public static IDModule module = new IDModule();


	public static void main(String[] args) {
		int r = 1;
		Random random = new Random();
		do {

			String a = JOptionPane.showInputDialog(
					"Geef je keuze in: \n Willekeurige users maken = 1 \n user verwijderen = 2 \n Frequentie veranderen = 3\n");
			int b = Integer.parseInt(a);

			switch (b) {

			case 1:
				StringBuffer alles = new StringBuffer();
				for (int i = 0; i < 50; ++i) {
					User aUser = Generator.GenerateUsers(module.getPermittedFrequency());
					module.AddObserver(aUser);
					alles.append(aUser.toString());
				}
				System.out.println(alles);
				// logger.info(alles.toString());
				break;
			case 2:
				String achternaam = JOptionPane.showInputDialog("Geef een naam in: ");
				System.out.println(module.GetSpecificUser(achternaam));
				break;
			case 3:
				module.setPermittedFrequency(Generator.Randomfrequency());
				StringBuffer all = new StringBuffer();
				for (User bUser : module.getUserList()) {
					module.UpdateObserver(module.getPermittedFrequency(), bUser);
					all.append(bUser.toString());
				}
				System.out.println(all.toString());
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