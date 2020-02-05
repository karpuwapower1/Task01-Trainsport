package by.training.karpilovich.task01.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import by.training.karpilovich.task01.entity.LuggageWagonType;
import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.entity.PassengerWagonClass;
import by.training.karpilovich.task01.exception.RepositoryException;
import by.training.karpilovich.task01.factory.RepositoryFactory;
import by.training.karpilovich.task01.repository.Repository;
import by.training.karpilovich.task01.specification.query.impl.QuerySpecificationAllWagons;
import by.training.karpilovich.task01.specification.query.impl.QuerySpecificationByCapacity;
import by.training.karpilovich.task01.specification.query.impl.QuerySpecificationByNumber;

public class TestFileRepositoryImpl {

	private static final String FILE = "wagons.txt";
	private Repository repository;

	@Before
	public void init() throws RepositoryException {
		repository = RepositoryFactory.getFactory().getRepository(FILE);
	}

	@Test(expected = RepositoryException.class)
	public void testQueryNullQuery() throws RepositoryException {
		int expected = 10;
		int actual = repository.query(null).size();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testQueryWithAllWagonSpecification() throws RepositoryException {
		int expected = 10;
		int actual = repository.query(new QuerySpecificationAllWagons()).size();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testAdd() throws RepositoryException {
		PassengerWagon wagon = new PassengerWagon(1, LuggageWagonType.BIG, PassengerWagonClass.FIRST);
		int expected = 11;
		repository.add(wagon);
		int actual = repository.query(new QuerySpecificationAllWagons()).size();
		Assert.assertEquals(expected, actual);
	}

	@Test(expected = RepositoryException.class)
	public void testAddNull() throws RepositoryException {
		PassengerWagon wagon = null;
		int expected = 11;
		repository.add(wagon);
		int actual = repository.query(new QuerySpecificationAllWagons()).size();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testAddAll() throws RepositoryException {
		PassengerWagon wagon0 = new PassengerWagon(1, LuggageWagonType.BIG, PassengerWagonClass.FIRST);
		PassengerWagon wagon1 = new PassengerWagon(2, LuggageWagonType.MEDIUM, PassengerWagonClass.FIRST);
		int expected = 12;
		List<PassengerWagon> list = new ArrayList<>();
		list.add(wagon0);
		list.add(wagon1);
		repository.addAll(list);
		int actual = repository.query(new QuerySpecificationAllWagons()).size();
		Assert.assertEquals(expected, actual);
	}

	@Test(expected = RepositoryException.class)
	public void testAddAllNull() throws RepositoryException {
		List<PassengerWagon> list = null;
		int expected = 10;
		repository.addAll(list);
		int actual = repository.query(new QuerySpecificationAllWagons()).size();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testDelete() throws RepositoryException {
		int expected = 9;
		PassengerWagon wagon = new PassengerWagon(6, LuggageWagonType.SMALL, PassengerWagonClass.FIRST);
		repository.delete(wagon);
		int actual = repository.query(new QuerySpecificationAllWagons()).size();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testDeleteWagonNotPresentInRepository() throws RepositoryException {
		int expected = 10;
		PassengerWagon wagon = new PassengerWagon(12, LuggageWagonType.SMALL, PassengerWagonClass.FIRST);
		repository.delete(wagon);
		int actual = repository.query(new QuerySpecificationAllWagons()).size();
		Assert.assertEquals(expected, actual);
	}

	@Test(expected = RepositoryException.class)
	public void testDeleteNull() throws RepositoryException {
		int expected = 9;
		PassengerWagon wagon = null;
		repository.delete(wagon);
		int actual = repository.query(new QuerySpecificationAllWagons()).size();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testQueryWithNumberSpecification() throws RepositoryException {
		int expected = 1;
		int actual = repository.query(new QuerySpecificationByNumber(5)).size();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testQueryWithCapacitySpecification() throws RepositoryException {
		int expected = 3;
		int actual = repository.query(new QuerySpecificationByCapacity(15, 25)).size();
		Assert.assertEquals(expected, actual);
	}

}
