package by.training.karpilovich.task01.entity;

public abstract class AbstractWagon {

	private int number;
	private int capacity;
	
	public AbstractWagon() {}
	
	public AbstractWagon(int number, int capacity) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public abstract int getCapacity();

	@Override
	public int hashCode() {
		final int prime = 17;
		int result = 1;
		result = prime * result + capacity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		AbstractWagon other = (AbstractWagon) obj;
		if (number != other.number)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getName() + " [number=" + number + "]";
	}
}
