package by.training.karpilovich.task01.reader.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.exception.PassengerWagonFormatException;
import by.training.karpilovich.task01.factory.WagonFactory;

public class PassengerWagonFormat {

	public static final String DELIMETER = " ";
	public static final int WAGON_NUMBER = 0;
	public static final int LUGGAGE_CAPACITY = 1;
	public static final int PASSENGER_CAPACITY = 2;

	private static final Logger LOGGER = LogManager.getLogger(PassengerWagonFormat.class);

	WagonFactory factory = WagonFactory.getFactory();

	public PassengerWagon parse(String wagon) throws PassengerWagonFormatException {
		String[] parameters = wagon.split(DELIMETER);
		try {
			int wagonNumber = Integer.parseInt(parameters[WAGON_NUMBER]);
			int luggageCapacity = Integer.parseInt(parameters[LUGGAGE_CAPACITY]);
			int passengerCapacity = Integer.parseInt(parameters[PASSENGER_CAPACITY]);
			return factory.getPassengerWagon(wagonNumber, luggageCapacity, passengerCapacity);
		} catch (NumberFormatException e) {
			LOGGER.warn("Illegal string " + wagon);
			throw new PassengerWagonFormatException("Invalid number", e);
		}
	}

}
