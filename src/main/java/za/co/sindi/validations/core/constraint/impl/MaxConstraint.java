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
public class MaxConstraint extends ObjectConstraint {

	private long max = Long.MAX_VALUE;
	
	/**
	 * @param max
	 */
	public MaxConstraint(long max) {
		super();	
		this.max = max;
	}

	/* (non-Javadoc)
	 * @see za.co.bayport.validations.core.Constraint#isValid(java.lang.Object)
	 */
	public boolean isValid(Object value) {
		// TODO Auto-generated method stub
		if (value != null) {
			if (value instanceof Number) {
				if (value instanceof Float) {
					return ((Number)value).floatValue() <= max;
				}
				
				if (value instanceof Double) {
					return ((Number)value).doubleValue() <= max;
				}
				
				if (value instanceof Integer) {
					return ((Number)value).intValue() <= max;
				}
				
				if (value instanceof Long) {
					return ((Number)value).longValue() <= max;
				}
				
				if (value instanceof Short) {
					return ((Number)value).shortValue() <= max;
				}
				
				if (value instanceof Byte) {
					return ((Number)value).byteValue() <= max;
				}
				
				if (value instanceof BigInteger) {
					BigInteger minInteger = new BigInteger(String.valueOf(max));
					return (((BigInteger)value).compareTo(minInteger) <= 0);
				}
				
				if (value instanceof BigDecimal) {
					BigDecimal minDecimal = new BigDecimal(String.valueOf(max));
					return (((BigDecimal)value).compareTo(minDecimal) <= 0);
				}
				
				if (value instanceof AtomicInteger) {
					return ((AtomicInteger)value).get() <= max;
				}
				
				if (value instanceof AtomicLong) {
					return ((AtomicLong)value).get() <= max;
				}
			}
			
			if (value instanceof Object[]) {
				return ((Object[])value).length <= max;
			}
			
			if (value instanceof String) {
				return ((String)value).length() <= max;
			}
			
			if (value instanceof Collection) {
				return ((Collection<?>)value).size() <= max;
			}
			
			if (value instanceof Map) {
				return ((Map<?, ?>)value).size() <= max;
			}
		}
		
		return false;
	}
}
