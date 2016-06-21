/**
 * 
 */
package za.co.sindi.validations.core;

import java.io.Serializable;

/**
 * @author Bienfait Sindi
 * @since 23 July 2012
 *
 */
public interface Message extends Serializable {

//	public String getMessage(MessageResolver resolver);
	public String getText();
}
