package by.training.karpilovich.task01.specification.sort;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import by.training.karpilovich.task01.comparators.ComparatorByLuggageCapacity;
import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.exception.RepositoryException;
import by.training.karpilovich.task01.specification.Specification;

public class TestSpecificationSortByLuggageCapacity {

	private List<PassengerWagon> wagons;

	@Before
	public void initList() throws RepositoryException {
		wagons = new ArrayList<>();
		wagons.add(new PassengerWagon(0, 50, 20));
		wagons.add(new PassengerWagon(2, 70, 0));
		wagons.add(new PassengerWagon(1, 60, 10));
		
	}

	@Test
	public void testSpecify() {
		Specification specification = new SortSpecification(new ComparatorByLuggageCapacity());
		List<PassengerWagon> actual = specification.specify(wagons);
		List<PassengerWagon> expected = new ArrayList<>();
		expected.add(new PassengerWagon(0, 50, 20));
		expected.add(new PassengerWagon(1, 60, 10));
		expected.add(new PassengerWagon(2, 70, 0));
		Assert.assertEquals(expected, actual);
	}

}
