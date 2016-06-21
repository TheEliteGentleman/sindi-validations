/**
 * 
 */
package za.co.sindi.validations.core.constraint.impl;

import za.co.sindi.validations.core.constraint.StringConstraint;

/**
 * @author Buhake Sindi
 * @since 16 July 2012
 *
 */
public class NotPatternMatchConstraint extends StringConstraint {

	private final String regularExpression;
	
	/**
	 * @param regularExpression
	 */
	public NotPatternMatchConstraint(String regularExpression) {
		super();
		if (regularExpression == null || regularExpression.isEmpty()) {
			throw new IllegalArgumentException("Regular expression may not be null.");
		}
		
		this.regularExpression = regularExpression;
	}

	/* (non-Javadoc)
	 * @see za.co.bayport.validations.core.Constraint#isValid(java.lang.Object)
	 */
	public boolean isValid(String value) {
		// TODO Auto-generated method stub
		PatternMatchConstraint constraint = new PatternMatchConstraint(regularExpression);
		return !constraint.isValid(value);
	}
}
