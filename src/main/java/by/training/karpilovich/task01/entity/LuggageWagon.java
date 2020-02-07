package by.training.karpilovich.task01.entity;

public class LuggageWagon extends AbstractWagon {

	private int capacity;

	public LuggageWagon() {
	}

	public LuggageWagon(int number, int capacity) {
		super(number);
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return super.toString() + getClass().getName() + " [capacity=" + capacity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 17;
		int result = 1;
		result = result * prime + super.hashCode();
		result = prime * result + capacity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		if (!super.equals(obj))
			return false;
		LuggageWagon other = (LuggageWagon) obj;
		if (capacity != other.capacity)
			return false;
		return true;
	}

}
