/**
 * 
 */
package za.co.sindi.validations.core;

/**
 * @author Bienfait Sindi
 * @since 13 January 2013
 *
 */
public abstract class AbstractValidationMessage implements ValidationMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3975660969754419783L;
	
	private Type type;
	private String message;
	
	/* (non-Javadoc)
	 * @see za.co.sindi.validations.core.ValidationMessage#getType()
	 */
	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return type;
	}
	
	/* (non-Javadoc)
	 * @see za.co.sindi.validations.core.ValidationMessage#getMessage()
	 */
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
