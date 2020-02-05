package by.training.karpilovich.task01.service.impl;

import java.util.Comparator;
import java.util.List;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.exception.RepositoryException;
import by.training.karpilovich.task01.exception.ServiceException;
import by.training.karpilovich.task01.factory.RepositoryFactory;
import by.training.karpilovich.task01.repository.Repository;
import by.training.karpilovich.task01.service.Service;
import by.training.karpilovich.task01.specification.Specification;
import by.training.karpilovich.task01.specification.query.QuerySpecificationAllWagons;
import by.training.karpilovich.task01.specification.query.QuerySpecificationByCapacity;
import by.training.karpilovich.task01.specification.query.QuerySpecificationByNumber;
import by.training.karpilovich.task01.specification.sort.SortSpecification;
import by.training.karpilovich.task01.specification.update.UpdateSpecificationByNumber;
import by.training.karpilovich.task01.specification.update.UpdateSpecificationByPassengerCapacity;
import by.training.karpilovich.task01.validator.Validator;

public class ServiceImpl implements Service {

	private static Repository repository;
	private Validator validator = new Validator();
	private Specification specification;

	public ServiceImpl() {
	}

	public static void setRepository(String fileName) throws ServiceException {
		try {
			RepositoryFactory factory = RepositoryFactory.getFactory();
			repository = factory.getRepository(fileName);
		} catch (RepositoryException e) {
			// TODO logging
		}
	}

	@Override
	public int getTrainCapacity() {
		specification = new QuerySpecificationAllWagons();
		List<PassengerWagon> train = repository.query(specification);
		int capacity = 0;
		for (PassengerWagon wagon : train) {
			capacity += wagon.getCapacity();
		}
		return capacity;
	}

	@Override
	public int getTrainLuggageCapacity() {
		specification = new QuerySpecificationAllWagons();
		List<PassengerWagon> train = repository.query(specification);
		int luggageCapacity = 0;
		for (PassengerWagon wagon : train) {
			luggageCapacity += wagon.getCapacity();
		}
		return luggageCapacity;
	}

	@Override
	public List<PassengerWagon> updateCapacity(int capacity, int newCapacity) throws ServiceException {
		if (!validator.isCapacityGreaterThanZero(capacity) || !validator.isCapacityGreaterThanZero(newCapacity)) {
			throw new ServiceException();
		}
		specification = new UpdateSpecificationByPassengerCapacity(capacity, newCapacity);
		return repository.query(specification);
	}

	@Override
	public List<PassengerWagon> updateNumber(int number, int newNumber) throws ServiceException {
		specification = new UpdateSpecificationByNumber(number, newNumber);
		return repository.query(specification);
	}

	@Override
	public List<PassengerWagon> getWagonByNumber(int number) {
		specification = new QuerySpecificationByNumber(number);
		return repository.query(specification);
	}

	@Override
	public List<PassengerWagon> getWagonBetweenCapacity(int minCapacity, int maxCapacity) throws ServiceException {
		if (!validator.isCapacityGreaterThanZero(minCapacity)
				|| !validator.isMinLessThanMax(minCapacity, maxCapacity)) {
			throw new ServiceException();
		}
		specification = new QuerySpecificationByCapacity(minCapacity, maxCapacity);
		return repository.query(specification);
	}

	@Override
	public List<PassengerWagon> sort(Comparator<PassengerWagon> comparator) throws ServiceException {
		if (comparator == null) {
			throw new ServiceException("Comparator is null");
		}
		specification = new SortSpecification(comparator);
		return repository.query(specification);
	}

}
