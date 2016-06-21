/**
 * 
 */
package za.co.sindi.validations.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Bienfait Sindi
 * @since 12 January 2013
 *
 */
public abstract class ValidationFactory /*implements ValidatorFactory*/ {

	protected final Logger logger = Logger.getLogger(this.getClass().getName());
	private static ValidationFactory instance = null;
	private Map<String, Class<? extends Validator<?>>> validatorMap = null;
	
	/**
	 * 
	 */
	protected ValidationFactory() {
		super();
		// TODO Auto-generated constructor stub
		validatorMap = new ConcurrentHashMap<String, Class<? extends Validator<?>>>();
	}
	
	/**
	 * @return the instance
	 */
	public static ValidationFactory getInstance() {
		return instance;
	}

	/**
	 * @param instance the instance to set
	 */
	protected static void setInstance(ValidationFactory instance) {
		ValidationFactory.instance = instance;
	}

	public void registerValidator(String validatorId, Class<? extends Validator<?>> validatorClass) {
		if (validatorId == null || validatorId.isEmpty()) {
			throw new IllegalArgumentException("Validator ID may not be null nor empty.");
		}
		
		if (validatorClass == null) {
			throw new IllegalArgumentException("Validator class may not be null.");
		}
		
		validatorMap.put(validatorId, validatorClass);
	}
	
	@SuppressWarnings("unchecked")
	public <T> Validator<T> getValidator(String validatorId) {
		Validator<T> validator = null;
		
		try {
			validator = (Validator<T>) validatorMap.get(validatorId).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			logger.log(Level.SEVERE, "Error instantiating validator with validation ID " + validatorId, e);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			logger.log(Level.SEVERE, "Error accessing validator with validation ID " + validatorId, e);
		}
		
		return validator;
	}
}
