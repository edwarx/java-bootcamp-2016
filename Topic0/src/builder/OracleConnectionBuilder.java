package builder;

public class OracleConnectionBuilder implements DatabaseConnectionBuilder {

	private DatabaseConnection conn;

	@Override
	public void buildDatabaseType() {
		conn = (DatabaseConnection) DatabaseConnection.getInstance();
		conn.setDatabaseType("Oracle");

	}

	@Override
	public void buildUrl() {
		conn = (DatabaseConnection) DatabaseConnection.getInstance();
		conn.setUrl("127.0.0.1");

	}

	@Override
	public void buildUsername() {
		conn = (DatabaseConnection) DatabaseConnection.getInstance();
		conn.setUsername("user");

	}

	@Override
	public void buildPassword() {
		conn = (DatabaseConnection) DatabaseConnection.getInstance();
		conn.setPassword("pass");

	}

	@Override
	public DatabaseConnection getDatabaseConnection() {
		return (DatabaseConnection) DatabaseConnection.getInstance();
	}

}
