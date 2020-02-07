package by.training.karpilovich.task01.entity;

public class PassengerWagon extends LuggageWagon {

	private int capacity;
	
	public PassengerWagon() {}
	
	public PassengerWagon(int number,  int luggageCapacity, int passengerCapacity) {
		super(number, luggageCapacity);
		this.capacity = passengerCapacity;
	}
	
	public int getLuggageCapacity() {
		return super.getCapacity();
	}
	
	public void setLuggageCapacity(int luggageCapacity) {
		super.setCapacity(capacity);
	}
	
	
	public void setCapasity(int capacity) {
		this.capacity = capacity;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	@Override
	public String toString() {
		return super.toString() +  getClass().getName() 
				+ " [capacity=" + capacity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + super.hashCode();
		result = prime * result + capacity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		if (!super.equals(obj)) 
			return false;
		PassengerWagon other = (PassengerWagon) obj;
		if (capacity != other.capacity)
			return false;
		return true;
	}
}
