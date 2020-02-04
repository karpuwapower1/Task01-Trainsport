package by.training.karpilovich.task01.factory;

import by.training.karpilovich.task01.exception.RepositoryException;
import by.training.karpilovich.task01.repository.Repository;
import by.training.karpilovich.task01.repository.impl.FileRepositoryImpl;

public class RepositoryFactory {
	
	private RepositoryFactory() {
	}

	public static RepositoryFactory getFactory() {
		return FactoryHolder.INSTANCE;
	}

	private static class FactoryHolder {
		private static final RepositoryFactory INSTANCE = new RepositoryFactory();
	}

	public Repository getRepository(String fileName) throws RepositoryException {
		return FileRepositoryImpl.getRepository(fileName);
	}

}
