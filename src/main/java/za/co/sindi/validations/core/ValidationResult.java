/**
 * 
 */
package za.co.sindi.validations.core;

import java.util.Set;

/**
 * @author Bienfait Sindi
 * @since 23 July 2012
 *
 */
public interface ValidationResult {

	public Object getInvalidValue();
	public Set<ValidationMessage> getValidationMessages();
}
