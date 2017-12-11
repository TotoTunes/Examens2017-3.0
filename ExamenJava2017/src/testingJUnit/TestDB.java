package testingJUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.Output;

public class TestDB {

	@Test
	public void testConnectDb() {
		Output db = new Output();
		db.ConnectDb();
	}

}
