package by.training.karpilovich.task01.specification.update;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.exception.RepositoryException;
import by.training.karpilovich.task01.specification.Specification;

public class TestUpdateSpecificationByNumber {

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
		PassengerWagon update = new PassengerWagon(3, 40, 20);
		Specification specification = new UpdateSpecificationByNumber(1, update);
		List<PassengerWagon> updated = specification.specify(wagons);
		PassengerWagon actual = updated.get(2);
		Assert.assertEquals(update, actual);
	}

}
