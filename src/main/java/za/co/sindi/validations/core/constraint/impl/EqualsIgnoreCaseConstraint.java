/**
 * 
 */
package za.co.sindi.validations.core.constraint.impl;

import za.co.sindi.validations.core.constraint.StringConstraint;

/**
 * @author Buhake Sindi
 * @since 23 July 2012
 *
 */
public class EqualsIgnoreCaseConstraint extends StringConstraint {

	private final String value2;
	
	/**
	 * @param value2
	 */
	public EqualsIgnoreCaseConstraint(String value2) {
		super();
		this.value2 = value2;
	}

	/* (non-Javadoc)
	 * @see za.co.bayport.validations.core.Constraint#isValid(java.lang.Object)
	 */
	@Override
	public boolean isValid(String value) {
		// TODO Auto-generated method stub
		if (value == null) {
			return false;
		}
		
		return value.equalsIgnoreCase(value2);
	}
}
