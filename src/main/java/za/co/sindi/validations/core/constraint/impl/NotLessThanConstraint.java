/**
 * 
 */
package za.co.sindi.validations.core.constraint.impl;

import za.co.sindi.validations.core.constraint.ObjectConstraint;

/**
 * @author Buhake Sindi
 * @since 19 July 2012
 *
 */
public class NotLessThanConstraint extends ObjectConstraint {

	private long max = Long.MAX_VALUE;
	
	/**
	 * @param max
	 */
	public NotLessThanConstraint(long max) {
		super();	
		this.max = max;
	}

	/* (non-Javadoc)
	 * @see za.co.bayport.validations.core.Constraint#isValid(java.lang.Object)
	 */
	public boolean isValid(Object value) {
		// TODO Auto-generated method stub
		LessThanConstraint constraint = new LessThanConstraint(max);
		return !constraint.isValid(value);
	}
}
