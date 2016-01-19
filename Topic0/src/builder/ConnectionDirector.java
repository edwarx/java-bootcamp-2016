package builder;

public class ConnectionDirector {
	private DatabaseConnectionBuilder DatabaseConnectionBuilder;
	
	public ConnectionDirector(DatabaseConnectionBuilder dcb) {
		DatabaseConnectionBuilder = dcb;
	}
	public DatabaseConnection getConnection() {
		return DatabaseConnectionBuilder.getDatabaseConnection();
		
	}
	public void buildDatabaseConnection() {
		
		DatabaseConnectionBuilder.buildDatabaseType();
		DatabaseConnectionBuilder.buildUrl();
		DatabaseConnectionBuilder.buildUsername();
		DatabaseConnectionBuilder.buildPassword();
		DatabaseConnectionBuilder.getDatabaseConnection();
		
	}

}
