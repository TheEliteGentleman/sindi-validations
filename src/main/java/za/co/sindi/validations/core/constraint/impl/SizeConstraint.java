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
public class SizeConstraint extends ObjectConstraint {

	private final int size;
	
	/**
	 * @param size
	 */
	public SizeConstraint(int size) {
		super();
		this.size = size;
//		setMessage("Value is of size " + this.size + ".");
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
			return ((Object[])value).length == size;
		}
		
		if (value instanceof String) {
			return ((String)value).length() == size;
		}
		
		if (value instanceof Collection) {
			return ((Collection<?>)value).size() == size;
		}
		
		if (value instanceof Map) {
			return ((Map<?, ?>)value).size() == size;
		}
		
		//Reflectively
		try {
			Method method = value.getClass().getDeclaredMethod("size", (Class<?>)null);
			if (method != null) {
				int returnedSize = (Integer) method.invoke(value, (Object[])null);
				return returnedSize == size;
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
