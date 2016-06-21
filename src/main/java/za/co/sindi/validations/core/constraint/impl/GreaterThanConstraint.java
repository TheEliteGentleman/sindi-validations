/**
 * 
 */
package za.co.sindi.validations.core.constraint.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import za.co.sindi.validations.core.constraint.ObjectConstraint;

/**
 * @author Buhake Sindi
 * @since 19 July 2012
 *
 */
public class GreaterThanConstraint extends ObjectConstraint {

	private long min = 0;
	
	/**
	 * @param min
	 */
	public GreaterThanConstraint(long min) {
		super();
		
		if (min > Long.MAX_VALUE) {
			throw new IllegalArgumentException("Min must be lower than or equal to " + Long.MAX_VALUE);
		}
		
		this.min = min;
	}

	/* (non-Javadoc)
	 * @see za.co.bayport.validations.core.Constraint#isValid(java.lang.Object)
	 */
	public boolean isValid(Object value) {
		// TODO Auto-generated method stub
		if (value != null) {
			if (value instanceof Number) {
				if (value instanceof Float) {
					return ((Number)value).floatValue() > min;
				}
				
				if (value instanceof Double) {
					return ((Number)value).doubleValue() > min;
				}
				
				if (value instanceof Integer) {
					return ((Number)value).intValue() > min;
				}
				
				if (value instanceof Long) {
					return ((Number)value).longValue() > min;
				}
				
				if (value instanceof Short) {
					return ((Number)value).shortValue() > min;
				}
				
				if (value instanceof Byte) {
					return ((Number)value).byteValue() > min;
				}
				
				if (value instanceof BigInteger) {
					BigInteger minInteger = new BigInteger(String.valueOf(min));
					return (((BigInteger)value).compareTo(minInteger) > 0);
				}
				
				if (value instanceof BigDecimal) {
					BigDecimal minDecimal = new BigDecimal(String.valueOf(min));
					return (((BigDecimal)value).compareTo(minDecimal) > 0);
				}
				
				if (value instanceof AtomicInteger) {
					return ((AtomicInteger)value).get() > min;
				}
				
				if (value instanceof AtomicLong) {
					return ((AtomicLong)value).get() > min;
				}
			}
			
			if (value instanceof Object[]) {
				return ((Object[])value).length > min;
			}
			
			if (value instanceof String) {
				return ((String)value).length() > min;
			}
			
			if (value instanceof Collection) {
				return ((Collection<?>)value).size() > min;
			}
			
			if (value instanceof Map) {
				return ((Map<?, ?>)value).size() > min;
			}
		}
		
		return false;
	}
}
