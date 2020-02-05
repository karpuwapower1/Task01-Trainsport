package by.training.karpilovich.task01.entity;

public abstract class AbstractWagon {

	protected int number;
	
	public AbstractWagon() {
	}
	
	public AbstractWagon(int number) {
		this.number = number;
	}
	
	public abstract int getCapacity();

	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}

	@Override
	public int hashCode() {
		return number;
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
