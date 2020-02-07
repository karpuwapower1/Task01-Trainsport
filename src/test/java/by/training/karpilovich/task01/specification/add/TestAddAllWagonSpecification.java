package by.training.karpilovich.task01.specification.add;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.exception.RepositoryException;
import by.training.karpilovich.task01.specification.Specification;

public class TestAddAllWagonSpecification {

	private List<PassengerWagon> wagons;

	@Before
	public void initList() throws RepositoryException {
		wagons = new ArrayList<>();
		wagons.add(new PassengerWagon(0, 50, 20));
		wagons.add(new PassengerWagon(1, 60, 10));
		wagons.add(new PassengerWagon(2, 70, 0));
	}

	@Test
	public void testSpecify() {
		List<PassengerWagon> additional = new ArrayList<>();
		PassengerWagon added = new PassengerWagon(9, 30, 40);
		additional.add(added);
		Specification specification = new AddWagonSpecification(added);
		List<PassengerWagon> actual = specification.specify(wagons);
		wagons.add(added);
		Assert.assertEquals(wagons, actual);
	}

}
