/**
 * 
 */
package za.co.sindi.validations.core;

import za.co.sindi.validations.exception.ConfigurationException;

/**
 * @author Bienfait Sindi
 * @since 31 January 2013
 *
 */
public interface Configurator {

	public ValidationFactory createValidationFactory() throws ConfigurationException;
}
