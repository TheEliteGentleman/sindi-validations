/**
 * 
 */
package za.co.sindi.validations.core;

import java.io.Serializable;

import za.co.sindi.validations.core.ValidationMessage.Type;

/**
 * @author Bienfait Sindi
 * @since 29 July 2012
 *
 */
public final class ConstraintViolation<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5234366756403212451L;
	private Constraint<T> constraint;
	private Type messageType;
	private Message message;
	
	/**
	 * @param constraint
	 * @param messageType
	 * @param message
	 */
	public ConstraintViolation(Constraint<T> constraint, Type messageType, Message message) {
		super();
		this.constraint = constraint;
		this.messageType = messageType;
		this.message = message;
	}

	/**
	 * @return the constraint
	 */
	public Constraint<T> getConstraint() {
		return constraint;
	}

	/**
	 * @return the messageType
	 */
	public Type getMessageType() {
		return messageType;
	}

	/**
	 * @return the message
	 */
	public Message getMessage() {
		return message;
	}
}
