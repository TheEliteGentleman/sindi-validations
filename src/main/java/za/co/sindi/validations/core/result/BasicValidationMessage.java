/**
 * 
 */
package za.co.sindi.validations.core.result;

import za.co.sindi.validations.core.AbstractValidationMessage;

/**
 * @author Bienfait Sindi
 * @since 23 July 2012
 *
 */
public class BasicValidationMessage extends AbstractValidationMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8206982389865043722L;

	/**
	 * @param type
	 * @param message
	 */
	public BasicValidationMessage(Type type, String message) {
		super();
		if (type == null) {
			throw new IllegalArgumentException("A Validation level may not be null.");
		}
		
		if (message == null) {
			throw new IllegalArgumentException("A validation message may not be null.");
		}
		
		setType(type);
		setMessage(message);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BasicValidationMessage [type=" + getType() + ", message=" + getMessage() + "]";
	}
}
