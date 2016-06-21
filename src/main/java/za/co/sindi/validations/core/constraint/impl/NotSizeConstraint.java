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
public class NotSizeConstraint extends ObjectConstraint {

	private final int size;
	
	/**
	 * @param size
	 */
	public NotSizeConstraint(int size) {
		super();
		this.size = size;
//		setMessage("Value is of size " + this.size + ".");
	}

	/* (non-Javadoc)
	 * @see za.co.bayport.validations.core.Constraint#isValid(java.lang.Object)
	 */
	public boolean isValid(Object value) {
		// TODO Auto-generated method stub
		SizeConstraint constraint = new SizeConstraint(size);
		return !constraint.isValid(value);
	}
}
