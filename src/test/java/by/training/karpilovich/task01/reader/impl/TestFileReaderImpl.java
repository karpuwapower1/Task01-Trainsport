package by.training.karpilovich.task01.reader.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import by.training.karpilovich.task01.entity.LuggageWagonType;
import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.entity.PassengerWagonClass;
import by.training.karpilovich.task01.exception.ReaderException;
import by.training.karpilovich.task01.exception.RepositoryException;

public class TestFileReaderImpl {

	private List<PassengerWagon> wagons;
	private static final String FILE = "wagons.txt";
	private static final String ILLEGAL_FILE = "unknown.txt";
	private FileReader reader;

	private void initList() throws RepositoryException {
		wagons = new ArrayList<>();
		wagons.add(new PassengerWagon(0, LuggageWagonType.SMALL, PassengerWagonClass.FIRST));
		wagons.add(new PassengerWagon(1, LuggageWagonType.MEDIUM, PassengerWagonClass.SECOND));
		wagons.add(new PassengerWagon(2, LuggageWagonType.BIG, PassengerWagonClass.THIRD));
	}

	@Test
	public void testRead() throws ReaderException, RepositoryException {
		reader = (FileReader) FileReader.getReader();
		reader.setFileName(FILE);
		List<PassengerWagon> actual = reader.read();
		initList();
		Assert.assertEquals(wagons, actual);
	}
	
	@Test(expected = ReaderException.class)
	public void testReadWithIllegalFile() throws ReaderException, RepositoryException {
		reader = (FileReader) FileReader.getReader();
		reader.setFileName(ILLEGAL_FILE);
		List<PassengerWagon> actual = reader.read();
		initList();
		Assert.assertEquals(wagons, actual);
	}

}
