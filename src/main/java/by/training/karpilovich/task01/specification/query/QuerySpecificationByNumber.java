package by.training.karpilovich.task01.specification.query;

import java.util.ArrayList;
import java.util.List;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.specification.Specification;

public class QuerySpecificationByNumber implements Specification {
	
	private int number;
	
	public QuerySpecificationByNumber(int number) {
		this.number = number;
	}

	@Override
	public List<PassengerWagon> specify(List<PassengerWagon> wagons) {
		List<PassengerWagon> specified = new ArrayList<>();
		for (PassengerWagon wagon : wagons) {
			if (wagon.getNumber() == number) {
				specified.add(wagon);
			}
		}
		return specified;
	}

}
