package by.training.karpilovich.task01.specification.update.impl;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.specification.update.UpdateSpecification;

public class UpdateSpecificationByPassengerCapacity implements UpdateSpecification {
	
	private int capacity;
	private int newCapacity;
	
	public UpdateSpecificationByPassengerCapacity(int capacity, int newCapacity) {
		this.capacity = capacity;
		this.newCapacity = newCapacity;
	}

	@Override
	public boolean isUpdated(PassengerWagon wagon) {
		return capacity == wagon.getCapacity();
	}

	@Override
	public PassengerWagon update(PassengerWagon wagon) {
		wagon.setCapacity(capacity);
		return wagon;
	}
	
	

}
