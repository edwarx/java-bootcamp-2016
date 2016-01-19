package abstractFactory;

import java.sql.Connection;

public class OracleConnectionFactory implements AbstractDBConnectionFactory {

	@Override
	public Connection getConnection() {
		return OracleConnection.getInstance();
	}

}
