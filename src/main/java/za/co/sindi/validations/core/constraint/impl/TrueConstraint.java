/**
 * 
 */
package za.co.sindi.validations.core.constraint.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import za.co.sindi.validations.core.constraint.ObjectConstraint;

/**
 * @author Buhake Sindi
 * @since 18 July 2012
 *
 */
public class TrueConstraint extends ObjectConstraint {

	/**
	 * 
	 */
	public TrueConstraint() {
		super();
		// TODO Auto-generated constructor stub
//		setMessage("Value must be " + String.valueOf(true));
	}

	/* (non-Javadoc)
	 * @see za.co.bayport.validations.core.Constraint#isValid(java.lang.Object)
	 */
	public boolean isValid(Object value) {
		// TODO Auto-generated method stub
		if (value != null) {
			if (value instanceof Boolean) {
				return ((Boolean)value).equals(true);
			}
			
			if (value instanceof String) {
				String stringValue = ((String)value).toLowerCase();
				
				return ("yes".equals(stringValue) || "true".equals(stringValue));
			}
			
			if (value instanceof Number) {
				if (value instanceof Float) {
					return ((Float)value).equals(new Float(1));
				}
				
				if (value instanceof Double) {
					return ((Double)value).equals(new Double(1));
				}
				
				if (value instanceof Integer) {
					return ((Integer)value).equals(new Integer(1));
				}
				
				if (value instanceof Long) {
					return ((Long)value).equals(new Long(1));
				}
				
				if (value instanceof Short) {
					return ((Short)value).equals(new Short((short)1));
				}
				
				if (value instanceof Byte) {
					return ((Byte)value).equals(new Byte((byte)1));
				}
				
				if (value instanceof BigInteger) {
					BigInteger integer = new BigInteger(String.valueOf(1));
					return (((BigInteger)value).compareTo(integer) == 0);
				}
				
				if (value instanceof BigDecimal) {
					BigDecimal decimal = new BigDecimal(String.valueOf(1));
					return (((BigDecimal)value).compareTo(decimal) == 0);
				}
				
				if (value instanceof AtomicInteger) {
					return ((AtomicInteger)value).get() == 1;
				}
				
				if (value instanceof AtomicLong) {
					return ((AtomicLong)value).get() == 1;
				}
			}
		}
		
		return false;
	}
}
