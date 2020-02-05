package by.training.karpilovich.task01.service;

import java.util.Comparator;
import java.util.List;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.exception.ServiceException;

public interface Service {
	
	int getTrainCapacity() throws ServiceException;
	
	int getTrainLuggageCapacity() throws ServiceException;
	
	boolean updateNumber(int number, int newNumber) throws ServiceException;
	
	boolean updateCapacity(int capacity, int newCapacity) throws ServiceException;
	
	List<PassengerWagon> getWagonByNumber(int number) throws ServiceException;
	
	List<PassengerWagon> getWagonBetweenCapacity(int minCapacity, int maxCapacity) throws ServiceException;
	
	List<PassengerWagon> sort(Comparator<PassengerWagon> comparator) throws ServiceException;

}
