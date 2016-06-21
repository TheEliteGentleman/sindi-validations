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
public class NotGreaterThanConstraint extends ObjectConstraint {

	private long min = 0;
	
	/**
	 * @param min
	 */
	public NotGreaterThanConstraint(long min) {
		super();
		
		if (min > Long.MAX_VALUE) {
			throw new IllegalArgumentException("Min must be lower than or equal to " + Long.MAX_VALUE);
		}
		
		this.min = min;
	}

	/* (non-Javadoc)
	 * @see za.co.bayport.validations.core.Constraint#isValid(java.lang.Object)
	 */
	public boolean isValid(Object value) {
		// TODO Auto-generated method stub
		GreaterThanConstraint constraint = new GreaterThanConstraint(min);
		return !constraint.isValid(value);
	}
}
