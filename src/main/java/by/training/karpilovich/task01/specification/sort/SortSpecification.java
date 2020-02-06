package by.training.karpilovich.task01.specification.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.specification.Specification;

public class SortSpecification implements Specification {
	
	private Comparator<PassengerWagon> comparator;
	
	public SortSpecification(Comparator<PassengerWagon> comparator) {
		this.comparator = comparator;
	}

	@Override
	public List<PassengerWagon> specify(List<PassengerWagon> wagons) {
		List<PassengerWagon> copy = new ArrayList<>(wagons);
		Collections.sort(copy, comparator);
		return copy;
	}
}
