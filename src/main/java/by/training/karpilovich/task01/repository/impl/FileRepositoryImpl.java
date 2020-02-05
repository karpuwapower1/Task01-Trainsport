package by.training.karpilovich.task01.repository.impl;

import java.util.ArrayList;
import java.util.List;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.exception.ReaderException;
import by.training.karpilovich.task01.exception.RepositoryException;
import by.training.karpilovich.task01.reader.Reader;
import by.training.karpilovich.task01.reader.impl.FileReader;
import by.training.karpilovich.task01.repository.Repository;
import by.training.karpilovich.task01.specification.Specification;
import by.training.karpilovich.task01.validator.Validator;

public class FileRepositoryImpl implements Repository {

	List<PassengerWagon> train = new ArrayList<>();
	Reader reader;
	Validator validator = new Validator();
	private static FileRepositoryImpl instance;

	private FileRepositoryImpl(String fileName) throws RepositoryException {
		reader = FileReader.getReader(fileName);
		try {
			train = reader.read();
		} catch (ReaderException e) {
			throw new RepositoryException();
		}
	}

	public static Repository getRepository(String fileName) throws RepositoryException {
		if (instance == null) {
			instance = new FileRepositoryImpl(fileName);
		}
		return instance;
	}

	@Override
	public List<PassengerWagon> query(Specification specification) {
		return specification.specify(train);
	}
}
