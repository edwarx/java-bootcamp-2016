package singleton;

/*
 * Alternative way to implement the Singleton pattern found on the web.
 */
public enum AlternativeDatabaseConnection {
	INSTANCE;

	public String getConnection(String... connectionData) {
		return "Connected to the database";
	}
}