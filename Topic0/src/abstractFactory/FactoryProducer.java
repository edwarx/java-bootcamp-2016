package abstractFactory;

public class FactoryProducer {
	public static AbstractFactory getFactory(String choice) {

		if (choice.equalsIgnoreCase("Connection")) {
			return new ConnectionFactory();
		}

		return null;
	}
}
