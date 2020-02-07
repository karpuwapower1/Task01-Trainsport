package by.training.karpilovich.task01.service.impl;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.exception.RepositoryException;
import by.training.karpilovich.task01.exception.ServiceException;
import by.training.karpilovich.task01.factory.RepositoryFactory;
import by.training.karpilovich.task01.repository.Repository;
import by.training.karpilovich.task01.service.Service;
import by.training.karpilovich.task01.specification.Specification;
import by.training.karpilovich.task01.specification.add.AddWagonCollectionSpecification;
import by.training.karpilovich.task01.specification.add.AddWagonSpecification;
import by.training.karpilovich.task01.specification.delete.DeleteSpecificationAll;
import by.training.karpilovich.task01.specification.delete.DeleteSpecificationByNumber;
import by.training.karpilovich.task01.specification.query.QuerySpecificationAllWagons;
import by.training.karpilovich.task01.specification.query.QuerySpecificationByMinMaxCapacity;
import by.training.karpilovich.task01.specification.query.QuerySpecificationByNumber;
import by.training.karpilovich.task01.specification.sort.SortSpecification;
import by.training.karpilovich.task01.specification.update.UpdateSpecificationByNumber;
import by.training.karpilovich.task01.specification.update.UpdateSpecificationByPassengerCapacity;
import by.training.karpilovich.task01.validator.Validator;

public class ServiceImpl implements Service {
	
	private static final Logger LOGGER = LogManager.getLogger(Service.class);
	

	private static Repository repository;
	private Validator validator = new Validator();
	private Specification specification;
	private static ServiceImpl instance;

	private ServiceImpl() {
	}

	public void setRepository(String fileName) throws ServiceException {
		try {
			RepositoryFactory factory = RepositoryFactory.getFactory();
			repository = factory.getRepository(fileName);
		} catch (RepositoryException e) {
			LOGGER.warn("File not found", e);
			throw new ServiceException("Exception while initializing a repository", e);
		}
	}
	
	public static Service getService() {
		if (instance == null) {
			instance = new ServiceImpl();
		}
		return instance;
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
			luggageCapacity += wagon.getLuggageCapacity();
		}
		return luggageCapacity;
	}

	@Override
	public List<PassengerWagon> updateCapacity(int capacity, int newCapacity) throws ServiceException {
		if (!validator.isCapacityGreaterThanZero(capacity) 
				|| !validator.isMinLessThanMax(capacity, newCapacity)) {
			LOGGER.debug("capacity=" + capacity + " newCapacity=" + newCapacity);
			throw new ServiceException();
		}
		specification = new UpdateSpecificationByPassengerCapacity(capacity, newCapacity);
		return repository.query(specification);
	}

	@Override
	public List<PassengerWagon> updateNumber(int number, PassengerWagon wagon) throws ServiceException {
		if (wagon == null) {
			throw new ServiceException();
		}
		specification = new UpdateSpecificationByNumber(number, wagon);
		return repository.query(specification);
	}

	@Override
	public List<PassengerWagon> getWagonByNumber(int number) {
		specification = new QuerySpecificationByNumber(number);
		return repository.query(specification);
	}

	@Override
	public List<PassengerWagon> getWagonByCapacity(int minCapacity, int maxCapacity) throws ServiceException {
		if (!validator.isCapacityGreaterThanZero(minCapacity)
				|| !validator.isMinLessThanMax(minCapacity, maxCapacity)) {
			LOGGER.debug("minCapacity=" + minCapacity + " maxCapacity=" + maxCapacity);
			throw new ServiceException();
		}
		specification = new QuerySpecificationByMinMaxCapacity(minCapacity, maxCapacity);
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

	@Override
	public List<PassengerWagon> addWagon(PassengerWagon wagon) throws ServiceException {
		if (wagon == null) {
			LOGGER.debug("wagon = " + wagon);
			throw new ServiceException("wagon = null");
		}
		specification = new AddWagonSpecification(wagon);
		return repository.query(specification);
	}

	@Override
	public List<PassengerWagon> addAllWagons(Collection<PassengerWagon> wagons) throws ServiceException {
		if (wagons == null) {
			LOGGER.debug("wagons = " + wagons);
			throw new ServiceException("Collection<PassengerWagons> wagons = null");
		}
		Iterator<PassengerWagon> iterator = wagons.iterator();
		while (iterator.hasNext()) {
			if (iterator.next() == null) {
				iterator.remove();
			}
		}
		specification = new AddWagonCollectionSpecification(wagons);
		return repository.query(specification);
	}

	@Override
	public List<PassengerWagon> deleteAllWagons() {
		specification = new DeleteSpecificationAll();
		return repository.query(specification);
	}

	@Override
	public List<PassengerWagon> deleteWagon(int number) {
		specification = new DeleteSpecificationByNumber(number);
		return repository.query(specification);
	}

}
