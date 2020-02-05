package by.training.karpilovich.task01.specification.update;

import java.util.List;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.specification.Specification;

public class UpdateSpecificationByNumber implements Specification {

	private int number;
	private int updatedNumber;

	public UpdateSpecificationByNumber(int number, int updatedNumber) {
		this.number = number;
		this.updatedNumber = updatedNumber;
	}

	@Override
	public List<PassengerWagon> specify(List<PassengerWagon> wagons) {
		for (PassengerWagon wagon : wagons) {
			if (wagon.getNumber() >= number) {
				wagon.setNumber(updatedNumber);
			}
		}
		return wagons;
	}

}
