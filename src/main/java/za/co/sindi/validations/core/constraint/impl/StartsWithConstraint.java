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
public class StartsWithConstraint extends StringConstraint {

	private String prefix;
	
	/**
	 * @param beginStr
	 */
	public StartsWithConstraint(String prefix) {
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
		if (value == null) {
			return false;
		}
		
		return value.toLowerCase().startsWith(prefix.toLowerCase());
	}
}
