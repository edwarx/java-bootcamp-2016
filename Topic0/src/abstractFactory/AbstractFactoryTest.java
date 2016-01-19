package abstractFactory;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

public class AbstractFactoryTest {

	@Test
	public void test() {
		FactoryProducer factory = new FactoryProducer();

		Connection conn = factory.getConnection("MySQL");
		assertEquals(conn.getClass().getSimpleName(), "MySqlConnection");
		conn = factory.getConnection("MS SQL Server");
		assertEquals(conn.getClass().getSimpleName(), "SqlServerConnection");
		conn = factory.getConnection("Oracle");
		assertEquals(conn.getClass().getSimpleName(), "OracleConnection");
	}

}
