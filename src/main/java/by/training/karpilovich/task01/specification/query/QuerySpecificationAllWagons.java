package by.training.karpilovich.task01.specification.query;

import java.util.ArrayList;
import java.util.List;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.specification.Specification;

public class QuerySpecificationAllWagons implements Specification {

	@Override
	public List<PassengerWagon> specify(List<PassengerWagon> wagons) {
		return new ArrayList<>(wagons);
	}

}
