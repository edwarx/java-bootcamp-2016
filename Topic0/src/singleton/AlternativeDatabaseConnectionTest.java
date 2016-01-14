package singleton;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Test;

public class AlternativeDatabaseConnectionTest {

	@Test
	public void test() {
		assertNotNull(AlternativeDatabaseConnection.INSTANCE);
	}

	@Test
	public void testGetConnection() {
		AlternativeDatabaseConnection conn = AlternativeDatabaseConnection.INSTANCE;
		Logger l = Logger.getLogger(AlternativeDatabaseConnection.class.getName());
		assertNotNull(conn);
		assertEquals("Connected to the database", conn.getConnection(""));
		l.info(conn.getConnection(""));
	}

}
