package by.training.karpilovich.task01.specification.delete;

import java.util.List;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.specification.Specification;

public class DeleteSpecificationAll implements Specification {

	@Override
	public List<PassengerWagon> specify(List<PassengerWagon> wagons) {
		wagons.clear();
		return wagons;
	}
}
