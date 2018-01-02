package junit;

import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

import model.User;
import utilities.Generator;

/**
 * @author Bart Taelemans & Thomas Vanden Bossche
 * @date 2 jan. 2018
 * @project Afstandsbediening
 * @purpose Run test on class User
 *
 */

public class UserTest
{
	private static User user;
	private static Random random;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		random = new Random();
		user = new User(random.nextBoolean(), Generator.Randomfrequency(), Generator.GenerateAchternaam(), Generator.GenerateVoornaam());
	}

	@Test
	public void testHandleNotification()
	{
		user.handleNotification(Generator.Randomfrequency());
	}

}
