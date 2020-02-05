package by.training.karpilovich.task01.validator;

public class Validator {
	
	public boolean isMinLessThanMax(int min, int max) {
		return min <= max;
	}
	
	public boolean isCapacityGreaterThanZero(int capacity) {
		return capacity > 0;
	}
}
