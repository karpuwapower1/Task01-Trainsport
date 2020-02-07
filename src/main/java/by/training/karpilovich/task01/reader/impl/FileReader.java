package by.training.karpilovich.task01.reader.impl;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.exception.PassengerWagonFormatException;
import by.training.karpilovich.task01.exception.ReaderException;
import by.training.karpilovich.task01.reader.Reader;
import by.training.karpilovich.task01.reader.util.PassengerWagonFormat;

public class FileReader implements Reader {

	private String fileName;
	private PassengerWagonFormat format = new PassengerWagonFormat();
	private static FileReader fileReader;
	private static final Logger LOGGER = LogManager.getLogger(FileReader.class);
	
	private FileReader() {
	}
	
	public static Reader getReader() {
		if (fileReader == null) {
			fileReader = new FileReader();
		}
		return fileReader;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public List<PassengerWagon> read() throws ReaderException {
		URL url = this.getClass().getClassLoader().getResource(fileName);
		if (url == null) {
			LOGGER.warn("File doesn't exist" + fileName);
			throw new ReaderException("File doesn't exists");
		}
		File file = new File(url.getFile());
		List<PassengerWagon> passengerWagons;
		try {
			List<String> wagons = Files.readAllLines(file.toPath());
			passengerWagons = new ArrayList<>(wagons.size());
			for (String wagon : wagons) {
				passengerWagons.add(format.parse(wagon));
			}
		} catch (PassengerWagonFormatException e) {
			LOGGER.warn("File is damaged" + fileName);
			throw new ReaderException("File is damaged", e);
		} catch (IOException e) {
			LOGGER.warn("IO while worfing with " + fileName);
			throw new ReaderException("IOException while reading a file");
		}
		return passengerWagons;
	}
}
