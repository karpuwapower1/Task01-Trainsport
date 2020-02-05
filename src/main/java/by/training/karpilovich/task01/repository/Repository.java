package by.training.karpilovich.task01.repository;

import java.util.Collection;
import java.util.List;

import by.training.karpilovich.task01.entity.PassengerWagon;
import by.training.karpilovich.task01.exception.RepositoryException;
import by.training.karpilovich.task01.specification.query.QuerySpecification;
import by.training.karpilovich.task01.specification.update.UpdateSpecification;

public interface Repository {

	boolean add(PassengerWagon wagon) throws RepositoryException;
	
	boolean addAll(Collection<PassengerWagon> wagons) throws RepositoryException;
	
	boolean delete(PassengerWagon wagon) throws RepositoryException;
	
	boolean update(UpdateSpecification scpecification) throws RepositoryException;
	
	List<PassengerWagon> query(QuerySpecification specification) throws RepositoryException;

}
