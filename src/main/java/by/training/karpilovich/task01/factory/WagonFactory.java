package by.training.karpilovich.task01.factory;

import by.training.karpilovich.task01.entity.LuggageWagon;
import by.training.karpilovich.task01.entity.LuggageWagonType;
import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.entity.PassengerWagonClass;

public class WagonFactory {

	private WagonFactory() {
	}

	public static WagonFactory getFactory() {
		return FactoryHolder.factory;
	}

	private static class FactoryHolder {
		private static WagonFactory factory = new WagonFactory();
	}

	public LuggageWagon getLuggageWagon(int number, LuggageWagonType type) {
		return new LuggageWagon(number, type);
	}

	public PassengerWagon getPassengerWagon(int number, LuggageWagonType luggageWagon, PassengerWagonClass type) {
		return new PassengerWagon(number, luggageWagon, type);
	}

}
