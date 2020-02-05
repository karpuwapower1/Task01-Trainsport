package by.training.karpilovich.task01.reader.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

import by.training.karpilovich.task01.entity.LuggageWagonType;
import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.entity.PassengerWagonClass;
import by.training.karpilovich.task01.exception.ReaderException;
import by.training.karpilovich.task01.exception.RepositoryException;
import by.training.karpilovich.task01.reader.impl.FileReader;

public class TestFileReaderImpl {
	
	private List<PassengerWagon> wagons;
	private static final String FILE = "wagons.txt";
	
	private void initList() throws RepositoryException {
	wagons = new ArrayList<>();
	wagons.add(new PassengerWagon(0, LuggageWagonType.SMALL, PassengerWagonClass.FIRST));
	wagons.add(new PassengerWagon(1, LuggageWagonType.MEDIUM, PassengerWagonClass.SECOND));
	wagons.add(new PassengerWagon(2, LuggageWagonType.BIG, PassengerWagonClass.THIRDT));
	}

	@Test
	public void testRead() throws RepositoryException, ReaderException {
		FileReader fileReader = new FileReader(FILE);
		Optional<List<PassengerWagon>> optional = fileReader.read();
		List<PassengerWagon> actual = optional.get();
		initList();
		Assert.assertEquals(wagons, actual);;
	}
}
