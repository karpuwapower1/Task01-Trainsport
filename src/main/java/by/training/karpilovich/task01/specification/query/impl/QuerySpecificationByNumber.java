package by.training.karpilovich.task01.specification.query.impl;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.specification.query.QuerySpecification;

public class QuerySpecificationByNumber implements QuerySpecification {
	
	private int number;
	
	public QuerySpecificationByNumber(int number) {
		this.number = number;
	}

	@Override
	public boolean specified(PassengerWagon wagon) {
		return wagon.getNumber() == number;
	}

}
