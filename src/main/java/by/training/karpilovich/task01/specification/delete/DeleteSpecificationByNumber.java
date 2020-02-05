package by.training.karpilovich.task01.specification.delete;

import java.util.Iterator;
import java.util.List;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.specification.Specification;

public class DeleteSpecificationByNumber implements Specification {
	
	private int number;
	
	public DeleteSpecificationByNumber(int number) {
		this.number = number;
	}

	@Override
	public List<PassengerWagon> specify(List<PassengerWagon> wagons) {
		Iterator<PassengerWagon> iterator = wagons.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getNumber() == number) {
				iterator.remove();
			}
		}
		return wagons;
	}
}
