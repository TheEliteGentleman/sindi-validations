/**
 * 
 */
package za.co.sindi.validations.core.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotative way to annotate any {@link Validator} subclasses.
 * 
 * @author Bienfait Sindi
 * @since 12 February 2013
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Inherited
public @interface Validator {

	String value();
}
