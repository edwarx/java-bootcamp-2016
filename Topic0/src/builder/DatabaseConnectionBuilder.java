package builder;

public interface DatabaseConnectionBuilder {
	public void buildDatabaseType();
	public void buildUrl(String url);
	public void buildUsername(String username);
	public void buildPassword(String password);
	public DatabaseConnection getDatabaseConnection();
}
