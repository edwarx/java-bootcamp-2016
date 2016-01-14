package abstractFactory;

public class MySqlConnection implements DatabaseConnection {

	@Override
	public String getConnection() {

		return "Connected to a MySQL Database";
	}

}
