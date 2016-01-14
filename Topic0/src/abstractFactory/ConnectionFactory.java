package abstractFactory;

public class ConnectionFactory extends AbstractFactory {

	@Override
	DatabaseConnection getDatabaseConnection(String dbConn) {
		if (dbConn == null) {
			return null;
		}

		if (dbConn.equalsIgnoreCase("MySQL")) {
			return new MySqlConnection();

		} else if (dbConn.equalsIgnoreCase("MS SQL Server")) {
			return new MsSqlServerConnection();

		} else if (dbConn.equalsIgnoreCase("Oracle")) {
			return new OracleConnection();
		}

		return null;
	}
}
