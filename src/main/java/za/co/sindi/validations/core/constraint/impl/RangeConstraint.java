/**
 * 
 */
package za.co.sindi.validations.core.constraint.impl;

import za.co.sindi.validations.core.constraint.ObjectConstraint;

/**
 * @author Buhake Sindi
 * @since 18 July 2012
 *
 */
public class RangeConstraint extends ObjectConstraint {

	private long min = Long.MIN_VALUE;
	private long max = Long.MAX_VALUE;
	
	/**
	 * @param min
	 * @param max
	 */
	public RangeConstraint(long min, long max) {
		super();

		if (min > Long.MAX_VALUE) {
			throw new IllegalArgumentException("Min may not be greater than " + Long.MAX_VALUE);
		}
		
		if (max > Long.MAX_VALUE) {
			throw new IllegalArgumentException("Max may not be greater than " + Long.MAX_VALUE);
		}
		
		if (max <= min) {
			throw new IllegalArgumentException("Max must be greater than Min.");
		}
		
		this.min = min;
		this.max = max;
//		setMessage("Value must be in range of [" + min + ", " + max + "].");
	}

	/* (non-Javadoc)
	 * @see za.co.bayport.validations.core.Constraint#isValid(java.lang.Object)
	 */
	public boolean isValid(Object value) {
		// TODO Auto-generated method stub
		MinConstraint minConstraint = new MinConstraint(min);
		MaxConstraint maxConstraint = new MaxConstraint(max);
		return (minConstraint.isValid(value) && maxConstraint.isValid(value));
	}
}
