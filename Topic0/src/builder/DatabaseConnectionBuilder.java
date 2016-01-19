package builder;

public interface DatabaseConnectionBuilder {
	public void buildDatabaseType();

	public void buildUrl();

	public void buildUsername();

	public void buildPassword();

	public DatabaseConnection getDatabaseConnection();
}
