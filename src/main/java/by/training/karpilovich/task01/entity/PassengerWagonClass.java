package by.training.karpilovich.task01.entity;

public enum PassengerWagonClass {
	
	FIRST(10), SECOND(20), THIRDT(30);
	
	private int capacity;
	
	private PassengerWagonClass(int capacity) {
		this.capacity = capacity;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public String toString() {
		return "name=" + name() + ", capacity=" +  capacity + "]";
	}

}
