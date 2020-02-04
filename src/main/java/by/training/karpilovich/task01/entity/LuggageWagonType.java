package by.training.karpilovich.task01.entity;

public enum LuggageWagonType {
	
	SMALL(200), MEDIUM(500), BIG(1000);
	
	private int capacity;
	
	private LuggageWagonType(int capacity) {
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public String toString() {
		return "[name=" + name() + ", capacity=" + capacity + "]";
	}
}
