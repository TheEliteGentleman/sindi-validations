
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
public class NotStartsWithConstraint extends StringConstraint {

	private String prefix;
	
	/**
	 * @param beginStr
	 */
	public NotStartsWithConstraint(String prefix) {
		super();
		if (prefix == null || prefix.isEmpty()) {
			throw new IllegalArgumentException("Prefix may not be null.");
		}
		
		this.prefix = prefix;
//		setMessage("Value starts with '" + this.prefix + "'.");
	}
	
	/* (non-Javadoc)
	 * @see za.co.bayport.validations.core.Constraint#isValid(java.lang.Object)
	 */
	public boolean isValid(String value) {
		// TODO Auto-generated method stub
		StartsWithConstraint constraint = new StartsWithConstraint(prefix);
		return !constraint.isValid(value);
	}
}
