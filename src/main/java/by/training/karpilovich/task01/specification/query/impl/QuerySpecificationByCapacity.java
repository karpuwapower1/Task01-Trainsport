package by.training.karpilovich.task01.specification.query.impl;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.specification.query.QuerySpecification;

public class QuerySpecificationByCapacity implements QuerySpecification {

	private int minCapacity;
	private int maxCapacity;

	public QuerySpecificationByCapacity(int minCapacity, int maxCapacity) {
		this.minCapacity = minCapacity;
		this.maxCapacity = maxCapacity;
	}

	@Override
	public boolean specified(PassengerWagon wagon) {
		return ((wagon.getCapacity() >= minCapacity) && (wagon.getCapacity() <= maxCapacity));
	}

}
