package builder;

import static org.junit.Assert.*;

import org.junit.Test;

public class BuilderTest {

	@Test
	public void test() {
		// Building an Oracle connection
		
		DatabaseConnectionBuilder dcb = new OracleConnectionBuilder();
		ConnectionDirector director = new ConnectionDirector(dcb);
		director.buildDatabaseConnection();
		DatabaseConnection conn = director.getConnection();
		assertNotNull(conn);
		assertTrue(conn.getDatabaseType().equals("Oracle"));
		
		// Building a MS SQL Server connection
		
		dcb = new SqlServerConnectionBuilder();
		director = new ConnectionDirector(dcb);
		director.buildDatabaseConnection();
		conn = director.getConnection();
		assertNotNull(conn);
		assertTrue(conn.getDatabaseType().equals("MS SQL Server"));
		
		// Building a MySQL connection
		dcb = new MySqlConnectionBuilder();
		director = new ConnectionDirector(dcb);
		director.buildDatabaseConnection();
		conn = director.getConnection();
		assertNotNull(conn);
		assertTrue(conn.getDatabaseType().equals("MySQL"));
	}

}
