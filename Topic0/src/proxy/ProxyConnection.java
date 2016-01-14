package proxy;

public class ProxyConnection implements DatabaseConnection {

	private MySqlConnection conn;
	
	@Override
	public String getConnection() {
		if(conn == null) {
			conn = new MySqlConnection();
		}
		return conn.getConnection();
	}

}
