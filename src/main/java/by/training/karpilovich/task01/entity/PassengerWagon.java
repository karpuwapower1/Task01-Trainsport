package by.training.karpilovich.task01.entity;

public class PassengerWagon extends LuggageWagon {

	private PassengerWagonClass passengerWagonType;
	
	public PassengerWagon() {}
	
	public PassengerWagon(int number,  LuggageWagonType luggageWagonType, PassengerWagonClass passengerWagonType) {
		super(number, luggageWagonType);
		this.passengerWagonType = passengerWagonType;
	}
	
	public int getLuggageCapacity() {
		return super.getCapacity();
	}
	
	public LuggageWagonType getLuggageWagonType() {
		return super.getType();
	}
	
	public void setLuggageWagonType(LuggageWagonType luggageWagonType) {
		super.setType(luggageWagonType);
	}
	
	public PassengerWagonClass getPassengerWagonType() {
		return passengerWagonType;
	}
	
	public void setPassengerWagonType(PassengerWagonClass type) {
		this.passengerWagonType = type;
	}
	
	public void setCapasity(int capacity) {
		passengerWagonType.setCapacity(capacity);
	}
	
	public int getCapacity() {
		return passengerWagonType.getCapacity();
	}
	
	@Override
	public String toString() {
		return super.toString() +  getClass().getName() 
				+ " [type=" + (passengerWagonType == null ? "null" : passengerWagonType.toString()) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + super.hashCode();
		result = prime * result + (passengerWagonType == null ? 0 : passengerWagonType.hashCode());
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
		if (passengerWagonType != other.passengerWagonType)
			return false;
		return true;
	}
}
