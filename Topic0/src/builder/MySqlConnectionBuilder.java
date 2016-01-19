package builder;

public class MySqlConnectionBuilder implements DatabaseConnectionBuilder {

	private DatabaseConnection conn;

	@Override
	public void buildDatabaseType() {
		conn = (DatabaseConnection) DatabaseConnection.getInstance();
		conn.setDatabaseType("MySQL");

	}

	@Override
	public void buildUrl() {
		conn = (DatabaseConnection) DatabaseConnection.getInstance();
		conn.setUrl("10.0.0.1");

	}

	@Override
	public void buildUsername() {
		conn = (DatabaseConnection) DatabaseConnection.getInstance();
		conn.setUsername("admin");

	}

	@Override
	public void buildPassword() {
		conn = (DatabaseConnection) DatabaseConnection.getInstance();
		conn.setPassword("admin");

	}

	@Override
	public DatabaseConnection getDatabaseConnection() {
		return (DatabaseConnection) DatabaseConnection.getInstance();
	}

}
