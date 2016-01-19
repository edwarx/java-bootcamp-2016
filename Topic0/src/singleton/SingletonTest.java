package singleton;

import static org.junit.Assert.*;
import java.sql.Connection;

import org.junit.Test;

public class SingletonTest {

	@Test
	public void testGetInstance() {
		Connection conn = Singleton.getInstance();
		assertNotNull(conn);
	}
}
