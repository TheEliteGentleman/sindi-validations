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
public abstract class AbstractValidator<T> implements Validator<T> {

	protected final Logger logger = Logger.getLogger(this.getClass().getName());
//	private String fieldName;
	private MessageResolver messageResolver;
	
//	/* (non-Javadoc)
//	 * @see za.co.sindi.validations.core.Validator#setFieldName(java.lang.String)
//	 */
//	@Override
//	public void setFieldName(String fieldName) {
//		// TODO Auto-generated method stub
//		this.fieldName = fieldName;
//	}
	
	/* (non-Javadoc)
	 * @see za.co.sindi.validations.core.Validator#setMessageResolver(za.co.sindi.validations.core.MessageResolver)
	 */
	@Override
	public void setMessageResolver(MessageResolver messageResolver) {
		// TODO Auto-generated method stub
		this.messageResolver = messageResolver;
	}

//	/**
//	 * @return the fieldName
//	 */
//	public String getFieldName() {
//		return fieldName;
//	}

	/**
	 * @return the messageResolver
	 */
	public MessageResolver getMessageResolver() {
		return messageResolver;
	}
}
