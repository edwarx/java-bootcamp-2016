package proxy;

public class ProxyConnection {

	private MySqlConnection conn;

	public String getConnection() {
		if (conn == null) {
			conn = new MySqlConnection();
		}
		return conn.getConnection();
	}

}
