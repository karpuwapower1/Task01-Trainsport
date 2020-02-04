package by.training.karpilovich.task01.exception;

public class PassengerWagonFormatException extends Exception {

	private static final long serialVersionUID = 1L;

	public PassengerWagonFormatException() {
		super();
	}

	public PassengerWagonFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public PassengerWagonFormatException(String message) {
		super(message);
	}

	public PassengerWagonFormatException(Throwable cause) {
		super(cause);
	}

}
