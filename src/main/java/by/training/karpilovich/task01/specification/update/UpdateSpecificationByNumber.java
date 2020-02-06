package by.training.karpilovich.task01.specification.update;

import java.util.List;
import java.util.ListIterator;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.specification.Specification;

public class UpdateSpecificationByNumber implements Specification {

	private int number;
	private PassengerWagon wagon;

	public UpdateSpecificationByNumber(int number, PassengerWagon wagon) {
		this.number = number;
		this.wagon = wagon;
	}

	@Override
	public List<PassengerWagon> specify(List<PassengerWagon> wagons) {
		ListIterator<PassengerWagon> iterator = wagons.listIterator();
		while (iterator.hasNext()) {
			if (iterator.next().getNumber() == number) {
				iterator.remove();
				iterator.add(wagon);
			}
		}
		return wagons;
	}

}
