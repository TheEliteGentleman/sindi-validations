/**
 * 
 */
package za.co.sindi.validations.core;

import java.util.logging.Logger;

/**
 * @author Bienfait Sindi
 * @since 23 July 2012
 *
 */
public abstract class AbstractConstraint<T> implements Constraint<T> {

	protected final Logger logger = Logger.getLogger(this.getClass().getName());
}
