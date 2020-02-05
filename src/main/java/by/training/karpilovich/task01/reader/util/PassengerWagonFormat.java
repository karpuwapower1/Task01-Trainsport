package by.training.karpilovich.task01.reader.util;

import by.training.karpilovich.task01.entity.LuggageWagonType;
import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.entity.PassengerWagonClass;
import by.training.karpilovich.task01.exception.PassengerWagonFormatException;
import by.training.karpilovich.task01.factory.WagonFactory;

public class PassengerWagonFormat {

	public static final String DELIMETER = " ";
	public static final int WAGON_NUMBER = 0;
	public static final int LUGGAGE_WAGON_TYPE = 1;
	public static final int WAGON_CLASS = 2;


	WagonFactory factory = WagonFactory.getFactory();

	public PassengerWagon parse(String wagon) throws PassengerWagonFormatException {
		String[] parameters = wagon.split(DELIMETER);
		try {
			int wagonNumber = Integer.parseInt(parameters[WAGON_NUMBER]);
			PassengerWagonClass type = PassengerWagonClass.valueOf(parameters[WAGON_CLASS]);
			LuggageWagonType luggageWagonType = LuggageWagonType.valueOf(parameters[LUGGAGE_WAGON_TYPE]);
			return factory.getPassengerWagon(wagonNumber, luggageWagonType, type);
		} catch (NumberFormatException e) {
			throw new PassengerWagonFormatException(e);
		} catch (IllegalArgumentException | NullPointerException e) {
			throw new PassengerWagonFormatException(e);
		}
	}

}
