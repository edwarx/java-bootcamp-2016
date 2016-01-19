package abstractFactory;

import java.sql.Connection;

public interface AbstractDBConnectionFactory {
	public Connection getConnection();
}
