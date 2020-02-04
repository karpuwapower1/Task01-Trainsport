package by.training.karpilovich.task01.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.exception.RepositoryException;
import by.training.karpilovich.task01.exception.ServiceException;
import by.training.karpilovich.task01.factory.RepositoryFactory;
import by.training.karpilovich.task01.repository.Repository;
import by.training.karpilovich.task01.service.Service;
import by.training.karpilovich.task01.specification.query.QuerySpecification;
import by.training.karpilovich.task01.specification.query.impl.QuerySpecificationBetweenPassengerCapacity;
import by.training.karpilovich.task01.specification.query.impl.QuerySpecificationByNumber;
import by.training.karpilovich.task01.specification.update.UpdateSpecification;
import by.training.karpilovich.task01.specification.update.impl.UpdateSpecificationByNumber;
import by.training.karpilovich.task01.specification.update.impl.UpdateSpecificationByPassengerCapacity;
import by.training.karpilovich.task01.validator.Validator;

public class ServiceImpl implements Service {

	private static Repository repository;
	private Validator validator = new Validator();

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
		Optional<List<PassengerWagon>> optional = repository.getAllWagons();
		int capacity = 0;
		if (optional.isPresent()) {
			List<PassengerWagon> train = optional.get();
			for (PassengerWagon wagon : train) {
				capacity += wagon.getCapacity();
			}
		}
		return capacity;
	}

	@Override
	public int getTrainLuggageCapacity() {
		Optional<List<PassengerWagon>> optional = repository.getAllWagons();
		int luggageCapacity = 0;
		if (optional.isPresent()) {
			List<PassengerWagon> train = optional.get();
			for (PassengerWagon wagon : train) {
				luggageCapacity += wagon.getCapacity();
			}
		}
		return luggageCapacity;
	}

	@Override
	public boolean updateCapacity(int capacity, int newCapacity) throws ServiceException {
		if (!validator.isCapaciteGreaterThanZero(capacity) || !validator.isCapaciteGreaterThanZero(newCapacity)) {
			throw new ServiceException();
		}
		try {
			UpdateSpecification specification = new UpdateSpecificationByPassengerCapacity(capacity, newCapacity);
			return repository.update(specification);
		} catch (RepositoryException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean updateNumber(int number, int newNumber) throws ServiceException {
		try {
			UpdateSpecification specification = new UpdateSpecificationByNumber(number, newNumber);
			return repository.update(specification);
		} catch (RepositoryException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<PassengerWagon> getWagonByNumber(int number) throws ServiceException {
		try {
			QuerySpecification specification = new QuerySpecificationByNumber(number);
			return repository.query(specification);
		} catch (RepositoryException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<PassengerWagon> getWagonBetweenCapacity(int minCapacity, int maxCapacity) throws ServiceException {
		if (!validator.isCapaciteGreaterThanZero(minCapacity)
				|| !validator.isMinLessThanMax(minCapacity, maxCapacity)) {
			throw new ServiceException();
		}
		try {
			QuerySpecification specification = new QuerySpecificationBetweenPassengerCapacity(minCapacity, maxCapacity);
			return repository.query(specification);
		} catch (RepositoryException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<PassengerWagon> sort(Comparator<PassengerWagon> comparator) throws ServiceException {
		if (validator.isNull(comparator)) {
			throw new ServiceException();
		}
		Optional<List<PassengerWagon>> optional = repository.getAllWagons();
		List<PassengerWagon> copy = new ArrayList<>();
		if (optional.isPresent()) {
			copy = makeCopy(optional.get());
			Collections.sort(copy, comparator);
		}
		return copy;
	}

	private List<PassengerWagon> makeCopy(List<PassengerWagon> train) {
		List<PassengerWagon> copy = new ArrayList<>(train.size());
		Collections.copy(copy, train);
		return copy;
	}

}
