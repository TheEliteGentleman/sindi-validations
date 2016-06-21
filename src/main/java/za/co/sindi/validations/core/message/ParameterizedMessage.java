/**
 * 
 */
package za.co.sindi.validations.core.message;

import za.co.sindi.validations.core.MessageResolver;
import za.co.sindi.validations.core.Message;

/**
 * @author Buhake Sindi
 * @since 13 July 2012
 *
 */
public class ParameterizedMessage implements Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3338832643989876301L;
	private MessageResolver resolver;
	private String key;
	private Object[] values;
	
	/**
	 * @param resolver
	 * @param key
	 * @param values
	 */
	public ParameterizedMessage(MessageResolver resolver, String key, Object[] values) {
		super();
		if (key == null || key.isEmpty()) {
			throw new IllegalArgumentException("Parameter key may not be null nor empty.");
		}
		
		this.key = key;
		this.values = values;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.validations.core.ValidationMessage#getMessage()
	 */
	@Override
	public String getText() {
		// TODO Auto-generated method stub
		if (resolver == null) {
			throw new IllegalArgumentException("A Message resolver is required.");
		}
		
		String value = resolver.resolveMessage(key);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				value = value.replace("{" + i + "}", values[i].toString());
			}
		}
	
		return value;
	}
}
