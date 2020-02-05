package by.training.karpilovich.task01.specification.add;

import java.util.List;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.specification.Specification;

public class AddWagonSpecification implements Specification {

	private PassengerWagon wagon;

	public AddWagonSpecification(PassengerWagon wagon) {
		this.wagon = wagon;
	}

	@Override
	public List<PassengerWagon> specify(List<PassengerWagon> wagons) {
		wagons.add(wagon);
		return wagons;
	}
}
