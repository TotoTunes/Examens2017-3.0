package junit;

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
		Generator.GenerateUsers(Generator.Randomfrequency());
	}


}
