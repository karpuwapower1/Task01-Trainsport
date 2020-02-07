package by.training.karpilovich.task01.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.exception.ReaderException;
import by.training.karpilovich.task01.exception.RepositoryException;
import by.training.karpilovich.task01.reader.impl.FileReader;
import by.training.karpilovich.task01.repository.Repository;
import by.training.karpilovich.task01.specification.Specification;

public class FileRepository implements Repository {

	private static final Logger LOGGER = LogManager.getLogger(FileRepository.class);
	private FileReader reader;
	private List<PassengerWagon> train = new ArrayList<>();
	private static FileRepository instance;

	private FileRepository(String fileName) throws RepositoryException {
		reader = (FileReader) FileReader.getReader();
		reader.setFileName(fileName);
		try {
			train = reader.read();
		} catch (ReaderException e) {
			LOGGER.warn(e);
			throw new RepositoryException();
		}
	}

	public static Repository getRepository(String fileName) throws RepositoryException {
		if (instance == null) {
			instance = new FileRepository(fileName);
		}
		return instance;
	}

	@Override
	public List<PassengerWagon> query(Specification specification) {
		return specification.specify(train);
	}
}
