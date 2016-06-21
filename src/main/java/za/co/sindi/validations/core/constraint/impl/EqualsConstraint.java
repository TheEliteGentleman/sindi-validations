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
public class EqualsConstraint extends ObjectConstraint {

	private final Object value2;
	
	/**
	 * @param value2
	 */
	public EqualsConstraint(final Object value2) {
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
		
//		setMessage("Value is equal to value '" + value + "'.");
	}

	/* (non-Javadoc)
	 * @see za.co.bayport.validations.core.AbstractConstraint#isValid(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public boolean isValid(Object value) {
		// TODO Auto-generated method stub
		if (value == null && value2 == null) {
			return true;
		}
		
		if (value == null || value2 == null) {
			return false;
		}
		
		if (!value.getClass().equals(value2.getClass())) {
			return false;
		}
		
		if (value instanceof Comparable && value2 instanceof Comparable) {
			return (((Comparable<Object>)value).compareTo(value2) == 0);
		}
		
		return value.equals(value2);
	}
}
