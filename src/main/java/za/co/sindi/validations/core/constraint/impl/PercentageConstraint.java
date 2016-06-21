/**
 * 
 */
package za.co.sindi.validations.core.constraint.impl;

import za.co.sindi.validations.core.constraint.NumericConstraint;

/**
 * @author Buhake Sindi
 * @since 18 July 2012
 *
 */
public class PercentageConstraint extends NumericConstraint {

	/**
	 * 
	 */
	public PercentageConstraint() {
		super();
		// TODO Auto-generated constructor stub
//		setMessage("Value must be between [0, 100].");
	}

	/* (non-Javadoc)
	 * @see za.co.bayport.validations.core.Constraint#isValid(java.lang.Object)
	 */
	public boolean isValid(Number value) {
		// TODO Auto-generated method stub
		RangeConstraint constraint = new RangeConstraint(0, 100);
		return constraint.isValid(value);
	}
}
