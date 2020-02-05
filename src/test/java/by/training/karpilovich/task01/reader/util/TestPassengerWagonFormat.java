package by.training.karpilovich.task01.reader.util;

import org.junit.Assert;
import org.junit.Test;

import by.training.karpilovich.task01.entity.LuggageWagonType;
import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.entity.PassengerWagonClass;
import by.training.karpilovich.task01.exception.PassengerWagonFormatException;
import by.training.karpilovich.task01.factory.WagonFactory;

public class TestPassengerWagonFormat {

	public static final String DELIMETER = " ";
	public static final int WAGON_NUMBER = 0;
	public static final int LUGGAGE_WAGON_TYPE = 1;
	public static final int WAGON_CLASS = 2;

	WagonFactory factory = WagonFactory.getFactory();

	@Test
	public void testParseUpperCase() throws PassengerWagonFormatException {
		String wagon = "0 MEDIUM SECOND";
		PassengerWagon expected = new PassengerWagon(0, LuggageWagonType.MEDIUM, PassengerWagonClass.SECOND);
		PassengerWagon actual = new PassengerWagonFormat().parse(wagon);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testParseCamelCase() throws PassengerWagonFormatException {
		String wagon = "0 MediuM SEcond";
		PassengerWagon expected = new PassengerWagon(0, LuggageWagonType.MEDIUM, PassengerWagonClass.SECOND);
		PassengerWagon actual = new PassengerWagonFormat().parse(wagon);
		Assert.assertEquals(expected, actual);
	}
	
	@Test(expected = PassengerWagonFormatException.class)
	public void testParseException() throws PassengerWagonFormatException {
		String wagon = "0 First Big";
		PassengerWagon expected = new PassengerWagon(0, LuggageWagonType.MEDIUM, PassengerWagonClass.SECOND);
		PassengerWagon actual = new PassengerWagonFormat().parse(wagon);
		Assert.assertEquals(expected, actual);
	}

}
