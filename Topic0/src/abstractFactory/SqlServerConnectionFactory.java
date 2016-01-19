package abstractFactory;

import java.sql.Connection;

public class SqlServerConnectionFactory implements AbstractDBConnectionFactory {

	@Override
	public Connection getConnection() {

		return SqlServerConnection.getInstance();
	}

}
