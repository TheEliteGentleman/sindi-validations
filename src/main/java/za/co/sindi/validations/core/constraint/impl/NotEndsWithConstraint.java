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
public class NotEndsWithConstraint extends StringConstraint {

	private String suffix;
	
	/**
	 * @param endString
	 */
	public NotEndsWithConstraint(String suffix) {
		super();
		if (suffix == null || suffix.isEmpty()) {
			throw new IllegalArgumentException("Suffix may not be null or empty.");
		}
		
		this.suffix = suffix;
//		setMessage("Value ends with '" + this.suffix + "'.");
	}
	
	/* (non-Javadoc)
	 * @see za.co.bayport.validations.core.Constraint#isValid(java.lang.Object)
	 */
	public boolean isValid(String value) {
		// TODO Auto-generated method stub
		EndsWithConstraint constraint = new EndsWithConstraint(suffix);
		return !constraint.isValid(value);
	}
}
