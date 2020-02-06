package by.training.karpilovich.task01.serviceImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import by.training.karpilovich.task01.comparators.ComparatorByPassengerCapacity;
import by.training.karpilovich.task01.entity.LuggageWagonType;
import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.entity.PassengerWagonClass;
import by.training.karpilovich.task01.exception.RepositoryException;
import by.training.karpilovich.task01.exception.ServiceException;
import by.training.karpilovich.task01.service.impl.ServiceImpl;

public class TestServiceImpl {

	private final String fileName = "wagons2.txt";
	private ServiceImpl service;
	private List<PassengerWagon> wagons;
	List<PassengerWagon> expected;
	PassengerWagon wagon0;
	PassengerWagon wagon1;
	PassengerWagon wagon2;

	@Before
	public void initList() throws RepositoryException {
		wagons = new ArrayList<>();
		expected = new ArrayList<>();
		wagon0 = new PassengerWagon(0, LuggageWagonType.SMALL, PassengerWagonClass.FIRST);
		wagon1 = new PassengerWagon(1, LuggageWagonType.MEDIUM, PassengerWagonClass.SECOND);
		wagon2 = new PassengerWagon(2, LuggageWagonType.BIG, PassengerWagonClass.THIRD);
		wagons.add(wagon0);
		wagons.add(wagon1);
		wagons.add(wagon2);
	}

	@Before
	public  void initRepository() throws RepositoryException, ServiceException {
		service = (ServiceImpl) ServiceImpl.getService();
		service.setRepository(fileName);
	}

	@Test
	public void testGetTrainCapacity() {
		int expected = 60;
		int actual = service.getTrainCapacity();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGetTrainLuggageCapacity() {
		int expected = 1700;
		int actual = service.getTrainLuggageCapacity();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testUpdateCapacity() throws ServiceException {
		List<PassengerWagon> actual = service.updateCapacity(10, 15);
		expected = new ArrayList<>(wagons);
		expected.get(0).setCapacity(15);
		Assert.assertEquals(expected, actual);
	}

	@Test(expected = ServiceException.class)
	public void testUpdateCapacityMaxCapacityLessMin() throws ServiceException {
		List<PassengerWagon> actual = service.updateCapacity(15, 10);
		expected = new ArrayList<>(wagons);
		expected.get(0).setCapacity(15);
		Assert.assertEquals(expected, actual);
	}

	@Test(expected = ServiceException.class)
	public void testUpdateNegativeMinCapacity() throws ServiceException {
		List<PassengerWagon> actual = service.updateCapacity(-10, 15);
		expected = new ArrayList<>(wagons);
		expected.get(0).setCapacity(15);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testUpdateNumber() throws ServiceException {
		PassengerWagon update = new PassengerWagon(5, LuggageWagonType.BIG, PassengerWagonClass.FIRST);
		List<PassengerWagon> actual = service.updateNumber(0, update);
		expected = new ArrayList<>(wagons);
		expected.set(0, update);
		Assert.assertEquals(expected, actual);
	}

	@Test(expected = ServiceException.class)
	public void testUpdateNumberNullWagon() throws ServiceException {
		PassengerWagon update = null;
		List<PassengerWagon> actual = service.updateNumber(0, update);
		expected = new ArrayList<>(wagons);
		expected.set(0, update);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGetWagonNumber() {
		PassengerWagon actual = service.getWagonByNumber(1).get(0);
		expected = new ArrayList<>();
		Assert.assertEquals(wagon1, actual);
	}

	@Test
	public void testGetWagonByCapacity() throws ServiceException {
		List<PassengerWagon> actual = service.getWagonByCapacity(15, 25);
		expected = new ArrayList<>();
		expected.add(wagon1);
		Assert.assertEquals(expected, actual);
	}

	@Test(expected = ServiceException.class)
	public void testGetWagonByCapacityMaxCapacityLessMin() throws ServiceException {
		List<PassengerWagon> actual = service.getWagonByCapacity(25, 15);
		expected = new ArrayList<>();
		expected.add(wagon1);
		Assert.assertEquals(expected, actual);
	}

	@Test(expected = ServiceException.class)
	public void testGetWagonByCapacityNegativeMinCapacity() throws ServiceException {
		List<PassengerWagon> actual = service.getWagonByCapacity(-15, 25);
		expected = new ArrayList<>();
		expected.add(wagon1);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testSort() throws ServiceException {
		Comparator<PassengerWagon> comparator = new ComparatorByPassengerCapacity();
		List<PassengerWagon> actual = service.sort(comparator);
		expected = new ArrayList<>(wagons);
		Assert.assertEquals(expected, actual);
	}

	@Test(expected = ServiceException.class)
	public void testSortNullComparator() throws ServiceException {
		Comparator<PassengerWagon> comparator = null;
		List<PassengerWagon> actual = service.sort(comparator);
		expected = new ArrayList<>(wagons);
		Assert.assertEquals(expected, actual);
	}

}
