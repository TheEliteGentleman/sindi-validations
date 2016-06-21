/**
 * 
 */
package za.co.sindi.validations.core.constraint.impl;

import java.util.Date;

import za.co.sindi.validations.core.AbstractConstraint;

/**
 * @author Buhake Sindi
 * @since 23 July 2012
 *
 */
public class DateRangeConstraint extends AbstractConstraint<Date> {

	private Date min;
	private Date max;
	
	/**
	 * @param min
	 * @param max
	 */
	public DateRangeConstraint(Date min, Date max) {
		super();
		if (min == null) {
			throw new IllegalArgumentException("Min date may not be null.");
		}
		
		if (max == null) {
			throw new IllegalArgumentException("Max date may not be null.");
		}
		
		if (min.equals(max) || min.compareTo(max) == 0) {
			throw new IllegalArgumentException("Min and Max dates may not be equal.");
		}
		
		this.min = min;
		this.max = max;
	}


	/* (non-Javadoc)
	 * @see za.co.bayport.validations.core.Constraint#isValid(java.lang.Object)
	 */
	@Override
	public boolean isValid(Date value) {
		// TODO Auto-generated method stub
		if (value == null) {
			return false;
		}
		
		return value.after(min) && value.before(max);
	}
}
