package by.training.karpilovich.task01.repository.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.exception.ReaderException;
import by.training.karpilovich.task01.exception.RepositoryException;
import by.training.karpilovich.task01.reader.Reader;
import by.training.karpilovich.task01.reader.impl.FileReader;
import by.training.karpilovich.task01.repository.Repository;
import by.training.karpilovich.task01.specification.query.QuerySpecification;
import by.training.karpilovich.task01.specification.update.UpdateSpecification;
import by.training.karpilovich.task01.validator.Validator;

public class FileRepositoryImpl implements Repository {

	List<PassengerWagon> train = new ArrayList<>();
	Reader reader;
	Validator validator = new Validator();
	private static FileRepositoryImpl instance;

	private FileRepositoryImpl(String fileName) throws RepositoryException {
		reader = new FileReader(fileName);
		try {
			Optional<List<PassengerWagon>> optional = reader.read();
			if (optional.isPresent()) {
				train = optional.get();
			}
		} catch (ReaderException e) {
			throw new RepositoryException();
		}
	}

	public static Repository getRepository(String fileName) throws RepositoryException {
		instance = new FileRepositoryImpl(fileName);
		return instance;
	}

	@Override
	public boolean add(PassengerWagon wagon) throws RepositoryException {
		if (validator.isNull(wagon)) {
			throw new RepositoryException();
		}
		return train.add(wagon);
	}

	@Override
	public boolean addAll(Collection<PassengerWagon> wagons) throws RepositoryException {
		if (validator.isNull(wagons)) {
			throw new RepositoryException();
		}
		return train.addAll(wagons);
	}

	@Override
	public boolean delete(PassengerWagon wagon) throws RepositoryException {
		if (validator.isNull(wagon)) {
			throw new RepositoryException();
		}
		return train.remove(wagon);
	}

	@Override
	public boolean update(UpdateSpecification specification) throws RepositoryException {
		if (validator.isNull(specification)) {
			throw new RepositoryException();
		}
		ListIterator<PassengerWagon> iter = train.listIterator();
		int updateQuantity = 0;
		PassengerWagon wagon;
		while (iter.hasNext()) {
			wagon = iter.next();
			if (specification.isUpdated(wagon)) {
				iter.remove();
				iter.add(specification.update(wagon));
				updateQuantity += 1;
			}
		}
		return updateQuantity > 0;
	}
	
	@Override
	public List<PassengerWagon> query(QuerySpecification specification) throws RepositoryException {
		if (validator.isNull(specification)) {
			throw new RepositoryException();
		}
		List<PassengerWagon> specifiedWagons = new ArrayList<>();
		for (PassengerWagon wagon : train) {
			if (specification.specified(wagon))
				specifiedWagons.add(wagon);
		}
		return specifiedWagons;
	}
}
