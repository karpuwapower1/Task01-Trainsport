package by.training.karpilovich.task01.comparators;

import java.util.Comparator;

import by.training.karpilovich.task01.entity.PassengerWagon;

public class ComparatorByPassengerCapacity implements Comparator<PassengerWagon> {

	public int compare(PassengerWagon wagon1, PassengerWagon wagon2) {
		return wagon1.getCapacity() - wagon2.getCapacity();
	}
}
