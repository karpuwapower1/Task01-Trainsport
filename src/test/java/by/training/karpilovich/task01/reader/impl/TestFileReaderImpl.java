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
	public void testRead() throws ReaderException, RepositoryException {
		FileReader fileReader = new FileReader(FILE);
		Optional<List<PassengerWagon>> optional = fileReader.read();
		List<PassengerWagon> actual = optional.get();
		initList();
		Assert.assertEquals(wagons, actual);
		;
	}

	@Test(expected = ReaderException.class)
	public void testReadNonexistingFile() throws ReaderException, RepositoryException {
		FileReader fileReader = new FileReader("unknownFile.txt");
		Optional<List<PassengerWagon>> optional = fileReader.read();
		List<PassengerWagon> actual = optional.get();
		initList();
		Assert.assertEquals(wagons, actual);
	}

}
