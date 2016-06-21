/**
 * 
 */
package za.co.sindi.validations.core;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;

import za.co.sindi.validations.core.ValidationMessage.Type;
import za.co.sindi.validations.core.message.ParameterizedMessage;
import za.co.sindi.validations.core.message.TextMessage;
import za.co.sindi.validations.core.result.BasicValidationMessage;
import za.co.sindi.validations.core.result.BasicValidationResult;
import za.co.sindi.validations.exception.ValidatorException;

/**
 * @author Bienfait Sindi
 * @since 23 July 2012
 *
 */
public abstract class AbstractConstraintValidator<T> extends AbstractValidator<T> implements ConstraintValidator<T> {

	private static final String ERROR_NO_MESSAGE_TYPE = "A ValidationMessage Type is required.";
	private static final String ERROR_NO_CONSTRAINT = "A Validation constraint is required.";
	private static final String ERROR_NO_MESSAGE = "A constraint message is required.";
	private static final String ERROR_NO_MESSAGE_KEY = "A message key is required.";
	
	private Set<ConstraintViolation<T>> constraintViolations = Collections.synchronizedSet(new LinkedHashSet<ConstraintViolation<T>>());
	
	/* (non-Javadoc)
	 * @see za.co.sindi.validations.core.ConstraintValidator#addConstraintViolation(za.co.sindi.validations.core.Constraint, za.co.sindi.validations.core.ValidationMessage.Type, java.lang.String)
	 */
	@Override
	public void addConstraintViolation(Constraint<T> constraint, Type messageType, String message) {
		// TODO Auto-generated method stub
		if (constraint == null) {
			throw new IllegalArgumentException(ERROR_NO_CONSTRAINT);
		}
		
		if (messageType == null) {
			throw new IllegalArgumentException(ERROR_NO_MESSAGE_TYPE);
		}
		
		if (message == null || message.isEmpty()) {
			throw new IllegalArgumentException(ERROR_NO_MESSAGE);
		}
		
		constraintViolations.add(new ConstraintViolation<T>(constraint, messageType, new TextMessage(message)));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.validations.core.ConstraintValidator#addConstraintViolation(za.co.sindi.validations.core.Constraint, za.co.sindi.validations.core.ValidationMessage.Type, java.lang.String, java.lang.Object[])
	 */
	@Override
	public void addConstraintViolation(Constraint<T> constraint, Type messageType, String messageKey, Object... messageValues) {
		// TODO Auto-generated method stub
		if (constraint == null) {
			throw new IllegalArgumentException(ERROR_NO_CONSTRAINT);
		}
		
		if (messageType == null) {
			throw new IllegalArgumentException(ERROR_NO_MESSAGE_TYPE);
		}
		
		if (messageKey == null || messageKey.isEmpty()) {
			throw new IllegalArgumentException(ERROR_NO_MESSAGE_KEY);
		}
		
		constraintViolations.add(new ConstraintViolation<T>(constraint, messageType, new ParameterizedMessage(getMessageResolver(), messageKey, messageValues)));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.validations.core.Validator#validate(java.lang.Object)
	 */
	@Override
	public Set<ValidationResult> validate(T value) throws ValidatorException {
		// TODO Auto-generated method stub
		if (logger.isLoggable(Level.INFO)) {
			logger.log(Level.INFO, "Validating value (" + String.valueOf(value) + ") against " + constraintViolations.size() + " validation constraint(s).");
		}
		
		//Validating
		final Set<ValidationResult> validationResults = new LinkedHashSet<ValidationResult>();
		synchronized (constraintViolations) {
			for (ConstraintViolation<?> violation : constraintViolations) {
				@SuppressWarnings("unchecked")
				Constraint<Object> constraint = (Constraint<Object>) violation.getConstraint();
				
				if (!constraint.isValid(value)) {
					BasicValidationResult result = new BasicValidationResult(value);
					
					ValidationMessage message = new BasicValidationMessage(violation.getMessageType(), violation.getMessage().getText());
					if (logger.isLoggable(Level.INFO)) {
						logger.info(message.getType() + ": " + message.toString());
					}
					
					result.addMessage(message);
					validationResults.add(result);
				}
			}
		}
		
		return Collections.unmodifiableSet(validationResults);
		
//		if (logger.isLoggable(Level.INFO)) {
//			logger.info("Validating further...");
//		}
//		
//		Set<ValidationMessage> furtherResults = validateInternally(value);
//		if (furtherResults != null && !furtherResults.isEmpty()) {
//			if (logger.isLoggable(Level.INFO)) {
//				logger.info("Further validations returned " + furtherResults.size() + " result(s).");
//			}
//			
//			validationResults.addAll(furtherResults);
////			//clear
////			furtherResults.clear();
////			furtherResults = null;
//		}
//		
//		//Log output
//		if (logger.isLoggable(Level.INFO)) {
//			logger.log(Level.INFO, "Validation returned " + validationResults.size() + " result(s).");
//		}
//		
//		return new ValidationResult() {
//			
//			@Override
//			public Set<ValidationMessage> getValidationResults() {
//				// TODO Auto-generated method stub
//				return Collections.unmodifiableSet(validationResults);
//			}
//		};
	}
	
//	/**
//	 * This method needs to be overridden if the developer wants to add further validation.
//	 * 
//	 * @param value
//	 * @return
//	 * @throws ValidatorException
//	 */
//	protected ValidationResult validateInternally(T value) throws ValidatorException {
//		return null;
//	}
}
