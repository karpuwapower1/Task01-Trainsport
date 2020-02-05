package by.training.karpilovich.task01.specification.query.impl;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.specification.query.QuerySpecification;

public class QuerySpecificationAllWagons implements QuerySpecification {

	@Override
	public boolean specified(PassengerWagon wagon) {
		return true;
	}

}
