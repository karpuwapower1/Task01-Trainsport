package by.training.karpilovich.task01.comparators;

import java.util.Comparator;

import by.training.karpilovich.task01.entity.PassengerWagon;

public class ComparatorByPassengerAndLuggageCapacity implements Comparator<PassengerWagon> {

	@Override
	public int compare(PassengerWagon o1, PassengerWagon o2) {
		Comparator<PassengerWagon> comparator = Comparator.comparingInt(PassengerWagon::getCapacity)
				.thenComparingInt(PassengerWagon::getLuggageCapacity);
		return comparator.compare(o1, o2);
	}

}
