/**
 * 
 */
package za.co.sindi.validations.core;

/**
 * @author Bienfait Sindi
 * @since 23 July 2012
 *
 */
public interface Constraint<T> {

	public boolean isValid(T value);
}
