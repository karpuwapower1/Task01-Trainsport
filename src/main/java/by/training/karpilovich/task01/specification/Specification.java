package by.training.karpilovich.task01.specification;

import java.util.List;

import by.training.karpilovich.task01.entity.PassengerWagon;

public interface Specification {
	
	List<PassengerWagon> specify(List<PassengerWagon> wagons);
}
