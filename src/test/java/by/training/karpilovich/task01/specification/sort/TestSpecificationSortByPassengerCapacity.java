package by.training.karpilovich.task01.specification.sort;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import by.training.karpilovich.task01.comparators.ComparatorByPassengerCapacity;
import by.training.karpilovich.task01.entity.LuggageWagonType;
import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.entity.PassengerWagonClass;
import by.training.karpilovich.task01.exception.RepositoryException;
import by.training.karpilovich.task01.specification.Specification;

public class TestSpecificationSortByPassengerCapacity {

	private List<PassengerWagon> wagons;

	@Before
	public void initList() throws RepositoryException {
		wagons = new ArrayList<>();
		wagons.add(new PassengerWagon(6, LuggageWagonType.SMALL, PassengerWagonClass.FIRST));
		wagons.add(new PassengerWagon(7, LuggageWagonType.MEDIUM, PassengerWagonClass.THIRD));
		wagons.add(new PassengerWagon(8, LuggageWagonType.BIG, PassengerWagonClass.SECOND));
		wagons.add(new PassengerWagon(9, LuggageWagonType.SMALL, PassengerWagonClass.FIRST));
	}

	@Test
	public void testSpecify() {
		Specification specification = new SortSpecification(new ComparatorByPassengerCapacity());
		List<PassengerWagon> actual = specification.specify(wagons);
		List<PassengerWagon> expected = new ArrayList<>();
		expected.add(new PassengerWagon(6, LuggageWagonType.SMALL, PassengerWagonClass.FIRST));
		expected.add(new PassengerWagon(9, LuggageWagonType.SMALL, PassengerWagonClass.FIRST));
		expected.add(new PassengerWagon(8, LuggageWagonType.BIG, PassengerWagonClass.SECOND));
		expected.add(new PassengerWagon(7, LuggageWagonType.MEDIUM, PassengerWagonClass.THIRD));
		Assert.assertEquals(expected, actual);
	}

}
