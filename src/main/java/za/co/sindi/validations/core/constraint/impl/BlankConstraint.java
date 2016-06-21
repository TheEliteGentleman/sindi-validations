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
public class BlankConstraint extends StringConstraint {

	/**
	 * 
	 */
	public BlankConstraint() {
		super();
		// TODO Auto-generated constructor stub
//		setMessage("Value may be blank.");
	}

	/* (non-Javadoc)
	 * @see za.co.bayport.validations.core.AbstractConstraint#isValid(java.lang.Object)
	 */
	public boolean isValid(String value) {
		// TODO Auto-generated method stub
		if (value == null) {
			return false;
		}
		
		return "".equals(value.trim());
	}
}
