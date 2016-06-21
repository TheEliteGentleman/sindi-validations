/**
 * 
 */
package za.co.sindi.validations.core;

import java.util.Set;

import za.co.sindi.validations.exception.ValidatorException;


/**
 * The top level interface with definitions required for all validations.
 * 
 * @author Bienfait Sindi
 * @since 23 July 2012
 *
 */
public interface Validator<T> {

//	/**
//	 * The field/property name of which this validator will validate.
//	 * 
//	 * @param fieldName
//	 */
//	public void setFieldName(String fieldName);
	
	/**
	 * Sets the {@link MessageResolver} to resolve parameterized messages.
	 * 
	 * @param messageResolver
	 */
	public void setMessageResolver(MessageResolver messageResolver);
	
	/**
	 * The <code>validate</code> method is where all the validation process happens.
	 * 
	 * @param value - the actual value that will be validated. 
	 * @return {@link ValidationResult} the results contains the set of all results returned from validation.
	 * @throws ValidatorException
	 */
	public Set<ValidationResult> validate(T value) throws ValidatorException;
}
