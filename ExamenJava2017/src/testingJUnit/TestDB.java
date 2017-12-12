package testingJUnit;

import java.io.IOException;

import org.junit.Test;

import db.Output;

public class TestDB {

	@Test
	public void testConnectDb() throws IOException {
		Output db = new Output();
		db.ConnectDb("DBproperties.properties");
	}

}
