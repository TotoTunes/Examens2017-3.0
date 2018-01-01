package junit;

import java.util.Random;

import org.junit.Test;

import utilities.Generator;

/**
 * @author Bart Taelemans & Thomas Vanden Bossche
 * @date 1 jan. 2018
 * @project Afstandsbediening
 * @purpose test Generator
 *
 */

public class GeneratorTest
{
	@SuppressWarnings("unused")

	@Test
	public void testGenerateVoornaam()
	{
		Generator.GenerateVoornaam();
	}

	@Test
	public void testGenerateAchternaam()
	{
		Generator.GenerateAchternaam();
	}
	
	@Test
	public void testRandomFrequency()
	{
		Generator.Randomfrequency();
	}
	
	@Test
	public void testClearFrequencyList()
	{
		Generator.ClearFrequencyList();
	}

	@Test
	public void testGenerateUsers()
	{
		Random random = new Random();
		int a = random.nextInt(900);
		double b = random.nextDouble();
		double frequency = a + b;
		Generator.GenerateUsers(frequency);
	}


}
