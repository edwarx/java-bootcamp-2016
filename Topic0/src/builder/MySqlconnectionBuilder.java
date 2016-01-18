package builder;

public class MySqlConnectionBuilder implements DatabaseConnectionBuilder {

	private DatabaseConnection conn;
	
	public MySqlConnectionBuilder() {
		conn = new DatabaseConnection();
	}
	@Override
	public void buildDatabaseType() {
		conn.setDatabaseType("MySQL");

	}

	@Override
	public void buildUrl(String url) {
		conn.setUrl(url);

	}

	@Override
	public void buildUsername(String username) {
		conn.setUsername(username);

	}

	@Override
	public void buildPassword(String password) {
		conn.setPassword(password);

	}

	@Override
	public DatabaseConnection getDatabaseConnection() {
		return conn;
	}

}
