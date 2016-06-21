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
public class NotEqualConstraint extends ObjectConstraint {

	private final Object value2;
	
	/**
	 * @param value2
	 */
	public NotEqualConstraint(final Object value2) {
		super();
		this.value2 = value2;
		
//		String value = "";
//		if (this.value2  == null) {
//			value = "null";
//		} else {
//			if (this.value2 instanceof String) {
//				value = (String)this.value2;
//			} else {
//				value = this.value2.toString();
//			}
//		}
		
//		setMessage("Value is not equal to value '" + value + "'.");
	}

	/* (non-Javadoc)
	 * @see za.co.bayport.validations.core.AbstractConstraint#isValid(java.lang.Object)
	 */
	public boolean isValid(Object value) {
		// TODO Auto-generated method stub
		if (value == null && value2 == null) {
			return false;
		}
		
		if (value != null && value2 != null) {
			return !value.equals(value2);
		}
		
		return true;
	}
}
