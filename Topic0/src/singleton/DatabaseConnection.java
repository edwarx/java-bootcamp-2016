package singleton;

public class DatabaseConnection {

	private static DatabaseConnection connection;

	private DatabaseConnection() {
	}

	public static DatabaseConnection getInstance() {
		if (connection == null) {
			connection = new DatabaseConnection();
		}
		return connection;
	}

	public String getConnection(String... connectionData) {
		return "Connected to the database";
	}

}