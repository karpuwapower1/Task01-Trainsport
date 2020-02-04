package by.training.karpilovich.task01.specification.update;

import by.training.karpilovich.task01.entity.PassengerWagon;

public interface UpdateSpecification {
	
	boolean isUpdated(PassengerWagon wagon);
	
	PassengerWagon update(PassengerWagon wagon);

}
