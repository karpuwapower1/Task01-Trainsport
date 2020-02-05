package by.training.karpilovich.task01.specification.update;

import java.util.List;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.specification.Specification;

public class UpdateSpecificationByPassengerCapacity implements Specification {

	private int capacity;
	private int newCapacity;

	public UpdateSpecificationByPassengerCapacity(int capacity, int newCapacity) {
		this.capacity = capacity;
		this.newCapacity = newCapacity;
	}

	@Override
	public List<PassengerWagon> specify(List<PassengerWagon> wagons) {
		for (PassengerWagon wagon : wagons) {
			if (wagon.getCapacity() >= capacity) {
				wagon.setCapacity(newCapacity);
			}
		}
		return wagons;
	}

}
