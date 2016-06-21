/**
 * 
 */
package za.co.sindi.validations.exception;

/**
 * @author Bienfait Sindi
 * @since 23 July 2012
 *
 */
public class ValidatorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5953027946984316077L;

	/**
	 * @param message
	 */
	public ValidatorException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ValidatorException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ValidatorException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
}
