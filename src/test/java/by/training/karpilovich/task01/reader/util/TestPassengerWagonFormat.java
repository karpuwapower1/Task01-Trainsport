package by.training.karpilovich.task01.reader.util;

import org.junit.Assert;
import org.junit.Test;

import by.training.karpilovich.task01.entity.LuggageWagonType;
import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.entity.PassengerWagonClass;
import by.training.karpilovich.task01.exception.PassengerWagonFormatException;
import by.training.karpilovich.task01.factory.WagonFactory;

public class TestPassengerWagonFormat {

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
