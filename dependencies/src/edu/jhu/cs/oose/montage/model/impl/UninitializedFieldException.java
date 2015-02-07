package edu.jhu.cs.oose.montage.model.impl;

/**
 * UninitializedFieldException class.
 * @author Greg Kogut, Da Lu, Zachary Palmer
 *
 */
public class UninitializedFieldException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default UninitializedFieldException constructor.
	 */
	public UninitializedFieldException() {
		super();
	}

	/**
	 * Overloaded UninitializedFieldException constructor.
	 * @param message error message
	 * @param cause throwable cause
	 * @param enableSuppression set to true to enable
	 * @param writableStackTrace set to true to enable
	 */
	public UninitializedFieldException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * Overloaded UninitializedFieldException constructor.
	 * @param message error message
	 * @param cause throwable cause
	 */
	public UninitializedFieldException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Overloaded UninitializedFieldException constructor.
	 * @param message error message
	 */
	public UninitializedFieldException(String message) {
		super(message);
	}

	/**
	 * Overloaded UninitializedFieldException constructor.
	 * @param cause throwable cause
	 */
	public UninitializedFieldException(Throwable cause) {
		super(cause);
	}

}
