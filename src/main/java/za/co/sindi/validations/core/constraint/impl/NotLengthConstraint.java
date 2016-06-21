/**
 * 
 */
package za.co.sindi.validations.core.constraint.impl;

import za.co.sindi.validations.core.constraint.ObjectConstraint;

/**
 * @author Buhake Sindi
 * @since 13 July 2012
 *
 */
public class NotLengthConstraint extends ObjectConstraint {

	private final int length;
	
	/**
	 * @param length
	 */
	public NotLengthConstraint(int length) {
		super();
		this.length = length;
//		setMessage("Value is of length " + this.length + ".");
	}

	/* (non-Javadoc)
	 * @see za.co.bayport.validations.core.Constraint#isValid(java.lang.Object)
	 */
	public boolean isValid(Object value) {
		// TODO Auto-generated method stub
		LengthConstraint constraint = new LengthConstraint(length);
		return !constraint.isValid(value);
	}
}
