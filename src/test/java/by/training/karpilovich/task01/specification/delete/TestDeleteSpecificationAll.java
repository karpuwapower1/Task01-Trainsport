package by.training.karpilovich.task01.specification.delete;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.exception.RepositoryException;
import by.training.karpilovich.task01.specification.Specification;

public class TestDeleteSpecificationAll {
	
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
		Specification specification = new DeleteSpecificationAll();
		List<PassengerWagon> expected = new ArrayList<>();
		List<PassengerWagon> actual = specification.specify(wagons);
		Assert.assertEquals(expected, actual);
	}

}
