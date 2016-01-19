package singleton.alternative;

import static org.junit.Assert.*;
import java.sql.Connection;

import org.junit.Test;

public class AlternativeSingletonTest {

	@Test
	public void test() {
		assertNotNull(AlternativeSingleton.INSTANCE);
	}

	@Test
	public void testGetConnection() {
		Connection conn = AlternativeSingleton.INSTANCE;
		assertNotNull(conn);
	}

}
