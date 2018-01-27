package junit;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

import model.IDModule;
import model.User;
import utilities.Generator;

/**
 * @author Bart Taelemans & Thomas Vanden Bossche
 * @date 2 jan. 2018
 * @project Afstandsbediening
 * @purpose Run test on class IDModule
 *
 */

public class IDModuleTest
{

	private static Random random;
	private static IDModule iDModule;
	private static User user;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		iDModule = new IDModule();
		random = new Random();
		user = new User(random.nextBoolean(), Generator.Randomfrequency(), Generator.GenerateAchternaam(),
				Generator.GenerateVoornaam());
	}

	@Test
	public void testRemoveObserver() throws Exception
	{
		iDModule.removeObserver(user);
		assertTrue("Gebruiker heeft nog toegang", user.isAcces() == false);
	}

	@Test
	public void testAddObserver() throws Exception
	{
		iDModule.addObserver(user);
		assertTrue("Gebruikersnaam is leeg", user.getLastName() != null);
	}

	@Test
	public void testUpdateObserver() throws Exception
	{
		iDModule.updateObserver(Generator.Randomfrequency(), user);
	}

//	@Test
//	public void testNotifyAllArrayListOfUser() throws Exception
//	{
//		iDModule.notifyAll(iDModule.getUserList());
//	}

	@Test
	public void testGetSpecificUserIntArrayListOfUser()
	{
		iDModule.GetSpecificUser(random.nextInt(iDModule.getUserList().size()), iDModule.getUserList());
	}

	@Test
	public void testGetSpecificUserString()
	{
		iDModule.GetSpecificUser(Generator.GenerateAchternaam());
	}

//	@Test
//	public void testOpenGate() throws Exception
//	{
//		iDModule.openGate(user);
//	}

}
