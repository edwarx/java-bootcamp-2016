package proxy;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProxyTest {

	@Test
	public void test() {
		DatabaseConnection conn = new ProxyConnection();
		assertEquals(conn.getConnection(), "Connected to a MySQL Database");
	}

}
