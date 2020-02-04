package by.training.karpilovich.task01.comparators;

import java.util.Comparator;

import by.training.karpilovich.task01.entity.PassengerWagon;

public class ComparatorByLuggageCapacity implements Comparator<PassengerWagon> {

	@Override
	public int compare(PassengerWagon wagon1, PassengerWagon wagon2) {
		return wagon1.getLuggageCapacity() - wagon2.getLuggageCapacity();
	}

}
