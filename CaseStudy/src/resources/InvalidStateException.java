package resources;

public class InvalidStateException extends Exception{
	public InvalidStateException() {}
	
	public InvalidStateException (String message) {
		super (message);
	}
}
