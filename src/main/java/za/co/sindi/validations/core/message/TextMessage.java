/**
 * 
 */
package za.co.sindi.validations.core.message;

import za.co.sindi.validations.core.Message;

/**
 * @author Buhake Sindi
 * @since 13 July 2012
 *
 */
public class TextMessage implements Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5534853530718768223L;
	private String text;
	
	/**
	 * @param text
	 */
	public TextMessage(String text) {
		super();
		if (text == null) {
			throw new IllegalArgumentException("A validation message is required.");
		}
		this.text = text;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.validations.core.Message#getText()
	 */
	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return text;
	}
}
