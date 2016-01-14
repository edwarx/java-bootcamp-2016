package databaseConnections;

public interface DatabaseConnection {
	public static DatabaseConnection getInstance();

	public DatabaseConnection getConnection();

}
