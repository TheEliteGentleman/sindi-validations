/**
 * 
 */
package za.co.sindi.validations.core;

import java.io.Serializable;

/**
 * The interface depicts the result returned from the validation.
 * 
 * @author Bienfait Sindi
 * @since 26 January 2013
 *
 */
public interface ValidationMessage extends Serializable {
	
	public enum Type {
		ERROR,
		INFO,
		WARNING,
	}

	public Type getType();
	public String getMessage();
}
