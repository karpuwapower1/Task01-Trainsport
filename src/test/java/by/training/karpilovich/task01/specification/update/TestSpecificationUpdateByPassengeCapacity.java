package by.training.karpilovich.task01.specification.update;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import by.training.karpilovich.task01.entity.LuggageWagonType;
import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.entity.PassengerWagonClass;
import by.training.karpilovich.task01.exception.RepositoryException;
import by.training.karpilovich.task01.specification.Specification;

public class TestSpecificationUpdateByPassengeCapacity {

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
		Specification specification = new UpdateSpecificationByPassengerCapacity(10, 15);
		List<PassengerWagon> expected = specification.specify(wagons);
		List<PassengerWagon> actual = wagons;
		actual.get(0).setCapasity(15);
		actual.get(3).setCapacity(15);
		Assert.assertEquals(expected, actual);
	}

}
