/**
 * 
 */
package za.co.sindi.validations.core.constraint.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Level;

import za.co.sindi.validations.core.constraint.ObjectConstraint;

/**
 * @author Buhake Sindi
 * @since 13 July 2012
 *
 */
public class LengthConstraint extends ObjectConstraint {

	private final int length;
	
	/**
	 * @param length
	 */
	public LengthConstraint(int length) {
		super();
		this.length = length;
//		setMessage("Value is of length " + this.length + ".");
	}

	/* (non-Javadoc)
	 * @see za.co.bayport.validations.core.Constraint#isValid(java.lang.Object)
	 */
	public boolean isValid(Object value) {
		// TODO Auto-generated method stub
		if (value == null) {
			return false;
		}
		
		if (value instanceof Object[]) {
			return ((Object[])value).length == length;
		}
		
		if (value instanceof String) {
			return ((String)value).length() == length;
		}
		
		if (value instanceof Collection) {
			return ((Collection<?>)value).size() == length;
		}
		
		if (value instanceof Map) {
			return ((Map<?, ?>)value).size() == length;
		}
		
		//Reflectively
		try {
			Method method = value.getClass().getDeclaredMethod("length", (Class<?>)null);
			if (method != null) {
				int returnedLength = (Integer) method.invoke(value, (Object[])null);
				return returnedLength == length;
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		
		return false;
	}
}
