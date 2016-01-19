package builder;

public class SqlServerConnectionBuilder implements DatabaseConnectionBuilder {

	private DatabaseConnection conn;

	@Override
	public void buildDatabaseType() {
		conn = (DatabaseConnection) DatabaseConnection.getInstance();
		conn.setDatabaseType("MS SQL Server");

	}

	@Override
	public void buildUrl() {
		conn = (DatabaseConnection) DatabaseConnection.getInstance();
		conn.setUrl("192.168.1.1");

	}

	@Override
	public void buildUsername() {
		conn = (DatabaseConnection) DatabaseConnection.getInstance();
		conn.setUsername("u");

	}

	@Override
	public void buildPassword() {
		conn = (DatabaseConnection) DatabaseConnection.getInstance();
		conn.setPassword("p");

	}

	@Override
	public DatabaseConnection getDatabaseConnection() {
		return (DatabaseConnection) DatabaseConnection.getInstance();
	}

}
