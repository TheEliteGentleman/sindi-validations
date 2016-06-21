/**
 * 
 */
package za.co.sindi.validations.core.result;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import za.co.sindi.validations.core.ValidationMessage;
import za.co.sindi.validations.core.ValidationResult;

/**
 * @author Bienfait Sindi
 * @since 15 January 2015
 *
 */
public class BasicValidationResult implements ValidationResult {

	private Object invalidValue;
	private Set<ValidationMessage> messages = new LinkedHashSet<ValidationMessage>();
	
	/**
	 * @param invalidValue
	 */
	public BasicValidationResult(Object invalidValue) {
		super();
		this.invalidValue = invalidValue;
	}

	public void addMessage(ValidationMessage message) {
		if (message != null) {
			messages.add(message);
		}
	}
	
	/* (non-Javadoc)
	 * @see za.co.sindi.validations.core.ValidationResult#getInvalidValue()
	 */
	@Override
	public Object getInvalidValue() {
		// TODO Auto-generated method stub
		return invalidValue;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.validations.core.ValidationResult#getValidationMessages()
	 */
	@Override
	public Set<ValidationMessage> getValidationMessages() {
		// TODO Auto-generated method stub
		return Collections.unmodifiableSet(messages);
	}
}
