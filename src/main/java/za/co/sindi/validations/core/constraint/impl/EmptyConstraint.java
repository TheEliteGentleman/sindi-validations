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
public class EmptyConstraint extends ObjectConstraint {

	/**
	 * 
	 */
	public EmptyConstraint() {
		super();
		// TODO Auto-generated constructor stub
//		setMessage("Value is empty.");
	}

	/* (non-Javadoc)
	 * @see za.co.bayport.validations.Constraint#isValid(java.lang.Object)
	 */
	public boolean isValid(Object value) {
		// TODO Auto-generated method stub
		if (value == null) {
			return true;
		}
		
		if (value instanceof String) {
			return ((String)value).isEmpty();
		}
		
		if (value instanceof Collection) {
			return ((Collection<?>)value).isEmpty();
		}
		
		if (value instanceof Map) {
			return ((Map<?, ?>)value).isEmpty();
		}
		
		try {
			Method method = value.getClass().getDeclaredMethod("isEmpty", (Class<?>)null);
			if (method != null) {
				return (Boolean) method.invoke(value, (Object[])null);
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} catch (NoSuchMethodException e) {
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
