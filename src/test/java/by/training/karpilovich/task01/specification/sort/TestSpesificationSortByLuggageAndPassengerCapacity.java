package by.training.karpilovich.task01.specification.sort;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import by.training.karpilovich.task01.comparators.ComparatorByLuggageAndPassengerCapacity;
import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.exception.RepositoryException;
import by.training.karpilovich.task01.specification.Specification;

public class TestSpesificationSortByLuggageAndPassengerCapacity {

	private List<PassengerWagon> wagons;

	@Before
	public void initList() throws RepositoryException {
		wagons = new ArrayList<>();
		wagons.add(new PassengerWagon(0, 50, 10));
		wagons.add(new PassengerWagon(2, 50, 0));
		wagons.add(new PassengerWagon(1, 60, 5));
	}

	@Test
	public void testSpecify() {
		Specification specification = new SortSpecification(new ComparatorByLuggageAndPassengerCapacity());
		List<PassengerWagon> actual = specification.specify(wagons);
		List<PassengerWagon> expected = new ArrayList<>();
		expected.add(new PassengerWagon(2, 50, 0));
		expected.add(new PassengerWagon(0, 50, 10));
		expected.add(new PassengerWagon(1, 60, 5));
		Assert.assertEquals(expected, actual);
	}

}
