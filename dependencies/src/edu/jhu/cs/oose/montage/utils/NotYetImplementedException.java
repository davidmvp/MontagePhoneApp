package edu.jhu.cs.oose.montage.utils;

/**
 * An exception to help find where we haven't implemented features yet.
 * @author Greg Kogut, Zach Palmer
 *
 */
public class NotYetImplementedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * Default NotYetImplementedException constructor.
	 */
	public NotYetImplementedException() {
		super();
	}

	/**
	 * Overloaded NotYetImplementedException constructor.
	 * @param message error message
	 * @param cause throwable cause
	 */
	public NotYetImplementedException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Overloaded NotYetImplementedException constructor.
	 * @param message error message.
	 */
	public NotYetImplementedException(String message) {
		super(message);
	}

	/**
	 * Overloaded NotYetImplementedException constructor.
	 * @param cause throwable cause
	 */
	public NotYetImplementedException(Throwable cause) {
		super(cause);
	}

}
