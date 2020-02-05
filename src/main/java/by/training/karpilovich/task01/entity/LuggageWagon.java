package by.training.karpilovich.task01.entity;

public class LuggageWagon extends AbstractWagon {

	private LuggageWagonType type;

	public LuggageWagon() {
	}

	public LuggageWagon(int number, LuggageWagonType type) {
		super(number);
		this.type = type;
	}

	public int getCapacity() {
		return type.getCapacity();
	}

	public void setCapacity(int capacity) {
		type.setCapacity(capacity);
	}

	public LuggageWagonType getType() {
		return type;
	}

	public void setType(LuggageWagonType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return super.toString() + getClass().getName() + " [type=" + type.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 17;
		int result = 1;
		result = result * prime + super.hashCode();
		result = prime * result + ((type == null) ? 0 : type.ordinal());
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
		if (type != other.type)
			return false;
		return true;
	}

}
