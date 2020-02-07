package by.training.karpilovich.task01.reader.util;

import org.junit.Assert;
import org.junit.Test;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.exception.PassengerWagonFormatException;
import by.training.karpilovich.task01.factory.WagonFactory;

public class TestPassengerWagonFormat {

	WagonFactory factory = WagonFactory.getFactory();

	@Test
	public void testParseUpperCase() throws PassengerWagonFormatException {
		String wagon = "0 50 20";
		PassengerWagon expected = new PassengerWagon(0, 50, 20);
		PassengerWagon actual = new PassengerWagonFormat().parse(wagon);
		Assert.assertEquals(expected, actual);
	}

	@Test(expected = PassengerWagonFormatException.class)
	public void testParseException() throws PassengerWagonFormatException {
		String wagon = "0 First Big";
		PassengerWagon expected = new PassengerWagon(0, 50, 20);
		PassengerWagon actual = new PassengerWagonFormat().parse(wagon);
		Assert.assertEquals(expected, actual);
	}

}
