package by.training.karpilovich.task01.specification.add;

import java.util.Collection;
import java.util.List;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.specification.Specification;

public class AddAllWagonCollectionSpecification implements Specification {

	private Collection<PassengerWagon> wagons;

	public AddAllWagonCollectionSpecification(Collection<PassengerWagon> wagons) {
		this.wagons = wagons;
	}

	@Override
	public List<PassengerWagon> specify(List<PassengerWagon> wagons) {
		wagons.addAll(this.wagons);
		return wagons;
	}
}
