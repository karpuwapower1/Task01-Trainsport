package by.training.karpilovich.task01.factory;

import by.training.karpilovich.task01.entity.LuggageWagon;
import by.training.karpilovich.task01.entity.PassengerWagon;

public class WagonFactory {

	private WagonFactory() {
	}

	public static WagonFactory getFactory() {
		return FactoryHolder.factory;
	}

	private static class FactoryHolder {
		private static WagonFactory factory = new WagonFactory();
	}

	public LuggageWagon getLuggageWagon(int number, int capacity) {
		return new LuggageWagon(number, capacity);
	}

	public PassengerWagon getPassengerWagon(int number, int luggageCapacity, int passengerCapacity) {
		return new PassengerWagon(number, luggageCapacity, passengerCapacity);
	}

}
