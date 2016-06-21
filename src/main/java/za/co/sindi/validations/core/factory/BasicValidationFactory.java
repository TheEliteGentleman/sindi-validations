/**
 * 
 */
package za.co.sindi.validations.core.factory;

import za.co.sindi.validations.core.ValidationFactory;

/**
 * @author Bienfait Sindi
 * @since 13 February 2013
 *
 */
public class BasicValidationFactory extends ValidationFactory {

	/**
	 * 
	 */
	public BasicValidationFactory() {
		super();
		// TODO Auto-generated constructor stub
		ValidationFactory.setInstance(this);
	}

//	/**
//	 * 
//	 * @param validators
//	 */
//	public BasicValidationFactory(Map<String, Class<? extends Validator<?>>> validators) {
//		this();
//		// TODO Auto-generated constructor stub
//		if (validators != null && !validators.isEmpty()) {
//			for (Entry<String, Class<? extends Validator<?>>> entry : validators.entrySet()) {
//				registerValidator(entry.getKey(), entry.getValue());
//			}
//		}
//	}
}
