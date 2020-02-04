package by.training.karpilovich.task01.specification.update.impl;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.specification.update.UpdateSpecification;

public class UpdateSpecificationByNumber implements UpdateSpecification {
	
	private int number;
	private int updatedNumber;
	
	public UpdateSpecificationByNumber(int number, int updatedNumber) {
		this.number = number;
		this.updatedNumber = updatedNumber;
	}

	@Override
	public boolean isUpdated(PassengerWagon wagon) {
		return number == wagon.getNumber();
	}

	@Override
	public PassengerWagon update(PassengerWagon wagon) {
		wagon.setNumber(number);
		return wagon;
	}

}
