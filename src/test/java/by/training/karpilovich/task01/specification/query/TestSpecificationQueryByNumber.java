package by.training.karpilovich.task01.specification.query;

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

public class TestSpecificationQueryByNumber {
	
	private List<PassengerWagon> wagons;

	@Before
	public void initList() throws RepositoryException {
		wagons = new ArrayList<>();
		wagons.add(new PassengerWagon(0, LuggageWagonType.SMALL, PassengerWagonClass.FIRST));
		wagons.add(new PassengerWagon(1, LuggageWagonType.MEDIUM, PassengerWagonClass.SECOND));
		wagons.add(new PassengerWagon(2, LuggageWagonType.BIG, PassengerWagonClass.THIRD));
		
		wagons.add(new PassengerWagon(3, LuggageWagonType.SMALL, PassengerWagonClass.SECOND));
		wagons.add(new PassengerWagon(4, LuggageWagonType.MEDIUM, PassengerWagonClass.FIRST));
		wagons.add(new PassengerWagon(5, LuggageWagonType.BIG, PassengerWagonClass.THIRD));
		
		wagons.add(new PassengerWagon(6, LuggageWagonType.SMALL, PassengerWagonClass.FIRST));
		wagons.add(new PassengerWagon(7, LuggageWagonType.MEDIUM, PassengerWagonClass.THIRD));
		wagons.add(new PassengerWagon(8, LuggageWagonType.BIG, PassengerWagonClass.SECOND));
		wagons.add(new PassengerWagon(9, LuggageWagonType.SMALL, PassengerWagonClass.FIRST));
	}
	
	@Test
	public void testSpecify() {
		PassengerWagon expected = new PassengerWagon(6, LuggageWagonType.SMALL, PassengerWagonClass.FIRST);
		Specification specification = new QuerySpecificationByNumber(6);
		List<PassengerWagon> returned = specification.specify(wagons);
		PassengerWagon actual = returned.get(0);
		Assert.assertEquals(expected, actual);
	}

}
