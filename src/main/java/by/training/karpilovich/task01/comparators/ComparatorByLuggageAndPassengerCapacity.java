package by.training.karpilovich.task01.comparators;

import java.util.Comparator;

import by.training.karpilovich.task01.entity.PassengerWagon;

public class ComparatorByLuggageAndPassengerCapacity implements Comparator<PassengerWagon> {

	@Override
	public int compare(PassengerWagon o1, PassengerWagon o2) {
		Comparator<PassengerWagon> comparator = Comparator.comparing(PassengerWagon::getLuggageCapacity)
				.thenComparing(PassengerWagon::getCapacity);
		return comparator.compare(o1, o2);
	}
}
