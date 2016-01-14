package abstractFactory;

import static org.junit.Assert.*;

import org.junit.Test;

public class AbstractFactoryTest {

	@Test
	public void test() {
		AbstractFactory connectionFactory = FactoryProducer.getFactory("Connection");
		assertNotNull(connectionFactory);

		DatabaseConnection conn = connectionFactory.getDatabaseConnection("MySQL");
		assertEquals(conn.getClass().getSimpleName(), "MySqlConnection");
		assertEquals(conn.getConnection(), "Connected to a MySQL Database");
		conn = connectionFactory.getDatabaseConnection("MS SQL Server");
		assertEquals(conn.getClass().getSimpleName(), "MsSqlServerConnection");
		assertEquals(conn.getConnection(), "Connected to a Microsoft SQL Server Database");
		conn = connectionFactory.getDatabaseConnection("Oracle");
		assertEquals(conn.getClass().getSimpleName(), "OracleConnection");
		assertEquals(conn.getConnection(), "Connected to an Oracle Database");
	}

}
