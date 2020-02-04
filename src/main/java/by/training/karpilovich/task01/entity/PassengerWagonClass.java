package by.training.karpilovich.task01.entity;

public enum PassengerWagonClass {
	
	FIRST_CLASS(20), SECOND_CLASS(30), THIRD_CLASS(60);
	
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
