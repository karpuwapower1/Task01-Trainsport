package by.training.karpilovich.task01.reader;

import java.util.List;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.exception.ReaderException;

public interface Reader {
	
	List<PassengerWagon> read() throws ReaderException;
}
