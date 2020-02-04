package by.training.karpilovich.task01.validator;

public class Validator {
	
	public boolean isMinLessThanMax(int min, int max) {
		return min <= max;
	}
	
	public boolean isCapaciteGreaterThanZero(int capacity) {
		return capacity > 0;
	}
	
	public boolean isNull(Object obj) {
		return obj == null;
	}

}
