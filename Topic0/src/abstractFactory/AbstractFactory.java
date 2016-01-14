package abstractFactory;

public abstract class AbstractFactory {
	abstract DatabaseConnection getDatabaseConnection(String dbConn);
}
