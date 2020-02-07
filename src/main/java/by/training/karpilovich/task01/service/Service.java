package by.training.karpilovich.task01.service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.exception.ServiceException;

public interface Service {
	
	int getTrainCapacity();
	
	int getTrainLuggageCapacity();
	
	List<PassengerWagon> addWagon(PassengerWagon wagon) throws ServiceException;
	
	List<PassengerWagon> addAllWagons(Collection<PassengerWagon> wagons) throws ServiceException;
	
	List<PassengerWagon> deleteAllWagons();
	
	List<PassengerWagon> deleteWagon(int number);
	
	List<PassengerWagon> updateNumber(int number, PassengerWagon wagon) throws ServiceException;
	
	List<PassengerWagon> updateCapacity(int capacity, int newCapacity) throws ServiceException;
	
	List<PassengerWagon> getWagonByNumber(int number);
	
	List<PassengerWagon> getWagonByCapacity(int minCapacity, int maxCapacity) throws ServiceException;
	
	List<PassengerWagon> sort(Comparator<PassengerWagon> comparator) throws ServiceException;

}
