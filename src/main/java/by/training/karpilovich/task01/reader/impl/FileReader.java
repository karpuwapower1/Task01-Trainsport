package by.training.karpilovich.task01.reader.impl;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.exception.PassengerWagonFormatException;
import by.training.karpilovich.task01.exception.ReaderException;
import by.training.karpilovich.task01.reader.Reader;
import by.training.karpilovich.task01.reader.util.PassengerWagonFormat;

public class FileReader implements Reader {

	private File file;
	private PassengerWagonFormat format = new PassengerWagonFormat();

	public FileReader(String fileName) throws ReaderException {
		URL url = getClass().getClassLoader().getResource(fileName);
		if (url == null) {
			throw new ReaderException("Illegal file");
		}
		file = new File(url.getFile());
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Optional<List<PassengerWagon>> read() throws ReaderException {
		if (!file.exists()) {
			throw new ReaderException("File doesn't exists");
		}
		Optional<List<PassengerWagon>> optionalList = Optional.empty();
		try {
			List<String> wagons = Files.readAllLines(file.toPath());
			List<PassengerWagon> passengerWagons = new ArrayList<>(wagons.size());
			for (String wagon : wagons) {
				try {
					passengerWagons.add(format.parse(wagon));
				} catch (PassengerWagonFormatException e) {
					throw new ReaderException("File is damaged", e);
				}
			}
			optionalList = Optional.ofNullable(passengerWagons);
		} catch (IOException e) {
			throw new ReaderException("IOException while reading a file");
		}
		return optionalList;
	}
}
