package abstractFactory;

public class OracleConnection implements DatabaseConnection {

	@Override
	public String getConnection() {
		return "Connected to an Oracle Database";
	}

}
