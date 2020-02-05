package by.training.karpilovich.task01.repository;

import java.util.List;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.specification.Specification;

public interface Repository {

	public List<PassengerWagon> query(Specification specification);
}
