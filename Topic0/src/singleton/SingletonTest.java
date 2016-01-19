package singleton;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Test;

public class DatabaseConnectionTest {

	@Test
	public void testGetInstance() {
		DatabaseConnection conn = DatabaseConnection.getInstance();
		assertNotNull(conn);
	}

	@Test
	public void testGetConnection() {
		DatabaseConnection conn = DatabaseConnection.getInstance();
		Logger l = Logger.getLogger(DatabaseConnection.class.getName());
		assertNotNull(conn);
		assertEquals("Connected to the database", conn.getConnection(""));
		l.info(conn.getConnection(""));
	}

}
