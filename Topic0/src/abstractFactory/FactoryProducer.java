package abstractFactory;

import java.sql.Connection;

public class FactoryProducer {
	private AbstractDBConnectionFactory factory;

	public Connection getConnection(String choice) {

		if (choice == null) {
			return null;
		}
		if (choice.compareTo("MySQL") == 0) {
			factory = new MySqlConnectionFactory();
			return factory.getConnection();
		}
		if (choice.compareTo("MS SQL Server") == 0) {
			factory = new SqlServerConnectionFactory();
			return factory.getConnection();
		}
		if (choice.compareTo("Oracle") == 0) {
			factory = new OracleConnectionFactory();
			return factory.getConnection();
		}

		return null;
	}
}
