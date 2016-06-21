/**
 * 
 */
package za.co.sindi.validations.core;

import za.co.sindi.validations.core.ValidationMessage.Type;

/**
 * The top level constraint validator. This, essentially allows to register a constraint with a {@link ValidationLevel} and a message.
 * 
 * @author Bienfait Sindi
 * @since 23 July 2012
 *
 */
public interface ConstraintValidator<T> extends Validator<T> {

	public void addConstraintViolation(Constraint<T> constraint, Type messageType, String message);
	public void addConstraintViolation(Constraint<T> constraint, Type messageType, String messageKey, Object... messageValues);
}
