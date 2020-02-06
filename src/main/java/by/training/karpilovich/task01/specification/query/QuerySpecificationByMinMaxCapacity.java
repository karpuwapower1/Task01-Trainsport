package by.training.karpilovich.task01.specification.query;

import java.util.ArrayList;
import java.util.List;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.specification.Specification;

public class QuerySpecificationByMinMaxCapacity implements Specification {

	private int minCapacity;
	private int maxCapacity;

	public QuerySpecificationByMinMaxCapacity(int minCapacity, int maxCapacity) {
		this.minCapacity = minCapacity;
		this.maxCapacity = maxCapacity;
	}

	@Override
	public List<PassengerWagon> specify(List<PassengerWagon> wagons) {
		List<PassengerWagon> specified = new ArrayList<>();
		for (PassengerWagon wagon : wagons) {
			if ((wagon.getCapacity() >= minCapacity) && (wagon.getCapacity() <= maxCapacity)) {
				specified.add(wagon);
			}
		}
		return specified;
	}

}
