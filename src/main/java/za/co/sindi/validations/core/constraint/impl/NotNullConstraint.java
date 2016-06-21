/**
 * 
 */
package za.co.sindi.validations.core.constraint.impl;

import za.co.sindi.validations.core.constraint.ObjectConstraint;


/**
 * @author Buhake Sindi
 * @since 13 July 2012
 *
 */
public class NotNullConstraint extends ObjectConstraint {

	/**
	 * 
	 */
	public NotNullConstraint() {
		super();
		// TODO Auto-generated constructor stub
//		setMessage("Value may not be null.");
	}

	/* (non-Javadoc)
	 * @see za.co.bayport.validations.Constraint#isValid(java.lang.Object)
	 */
	public boolean isValid(Object value) {
		// TODO Auto-generated method stub
		return value != null;
	}
}
