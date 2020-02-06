package by.training.karpilovich.task01.specification.add;

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

public class TestAddAllWagonSpecification {
	
	private List<PassengerWagon> wagons;

	@Before
	public void initList() throws RepositoryException {
		wagons = new ArrayList<>();
		wagons.add(new PassengerWagon(0, LuggageWagonType.SMALL, PassengerWagonClass.FIRST));
		wagons.add(new PassengerWagon(1, LuggageWagonType.MEDIUM, PassengerWagonClass.SECOND));
		wagons.add(new PassengerWagon(2, LuggageWagonType.BIG, PassengerWagonClass.THIRD));
	}

	@Test
	public void testSpecify() {
		List<PassengerWagon> additional = new ArrayList<>();
		PassengerWagon added = new PassengerWagon(9, LuggageWagonType.SMALL, PassengerWagonClass.FIRST);
		additional.add(added);
		Specification specification = new AddWagonSpecification(added);
		List<PassengerWagon> actual = specification.specify(wagons);
		wagons.add(added);
		Assert.assertEquals(wagons, actual);
	}

}
