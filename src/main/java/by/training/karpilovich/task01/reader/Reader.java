package by.training.karpilovich.task01.reader;

import java.util.List;
import java.util.Optional;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.exception.ReaderException;

public interface Reader {
	
	Optional<List<PassengerWagon>> read() throws ReaderException;
}
