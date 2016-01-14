package abstractFactory;

public class MsSqlServerConnection implements DatabaseConnection {
	@Override
	public String getConnection() {
		return "Connected to a Microsoft SQL Server Database";
	}
}
