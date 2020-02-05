package by.training.karpilovich.task01.service;

import java.util.Comparator;
import java.util.List;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.exception.ServiceException;

public interface Service {
	
	int getTrainCapacity();
	
	int getTrainLuggageCapacity();
	
	List<PassengerWagon> updateNumber(int number, int newNumber) throws ServiceException;
	
	List<PassengerWagon> updateCapacity(int capacity, int newCapacity) throws ServiceException;
	
	List<PassengerWagon> getWagonByNumber(int number);
	
	List<PassengerWagon> getWagonBetweenCapacity(int minCapacity, int maxCapacity) throws ServiceException;
	
	List<PassengerWagon> sort(Comparator<PassengerWagon> comparator) throws ServiceException;

}
