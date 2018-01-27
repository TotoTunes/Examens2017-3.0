package view;

import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import model.IDModule;
import model.User;
import utilities.Generator;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * @author Bart Taelemans & Thomas Vanden Bossche
 * @date 1 jan. 2018
 * @project Afstandsbediening
 * @purpose Test afstandsbediening
 *
 */

@SuppressWarnings("serial")
public class AfstandsbedieningTest extends JComponent
{

	public final static Logger LOGGER = LogManager.getLogger(AfstandsbedieningTest.class.getName());

	public static void main(String[] args) throws IOException, SQLException
	{

		int r = 1;
		IDModule module = new IDModule();
		try
		{
			do
			{

				String a = JOptionPane.showInputDialog(
						"Geef je keuze in: \n Willekeurige users maken = 1 \n user verwijderen = 2 \n Frequentie veranderen = 3\n Nieuwe User invoeren = 4 \n Poort openen = 5\n Toon alle users = 6");
				int keuze = Integer.parseInt(a);

				switch (keuze)
				{

				case 1:
					StringBuffer alles = new StringBuffer();
					for (int i = 0; i < 50; ++i)
					{
						User aUser = Generator.GenerateUsers(module.getPermittedFrequency());
						module.addObserver(aUser);
						alles.append(aUser.toString());
					}
					JOptionPane.showMessageDialog(null, alles);
					break;
				case 2:
					String achternaam = JOptionPane.showInputDialog("Geef een naam in: ");
					int g = Integer.parseInt(JOptionPane.showInputDialog(module.GetSpecificUser(achternaam)
							+ "\n Geef het nummer in van de persoon die je wilt verwijderen\n EXIT =0"));
					if (g > 0)
					{
						module.removeObserver(module.GetSpecificUser(g - 1, module.getSearch()));
					}

					break;
				case 3:
					module.setPermittedFrequency(Generator.Randomfrequency());
					StringBuffer all = new StringBuffer();
					for (User bUser : module.getUserList())
					{
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
					String achternaam1 = JOptionPane.showInputDialog("Geef een naam in: ");
					int g1 = Integer.parseInt(JOptionPane.showInputDialog(module.GetSpecificUser(achternaam1)
							+ "\n Geef het nummer in van de persoon die je wilt verwijderen\n EXIT =0"));
					if (g1 > 0)
					{
						module.openGate(module.GetSpecificUser(g1 - 1, module.getSearch()));
					}								// uit db
					break;

				case 6:
					JOptionPane.showMessageDialog(null, module.allToString());

					break;
				default:
					System.out.println("Fout");
					break;
				}

			} while (r < 2);
		} catch (Exception e)
		{
			LOGGER.debug(e);
		}

	}

}
