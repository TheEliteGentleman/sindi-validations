/**
 * 
 */
package za.co.sindi.validations.core.resolver;

import java.util.Locale;

import za.co.sindi.validations.core.ResourceBundleAwareMessageResolver;

/**
 * @author Bienfait Sindi
 * @since 03 Feburary 2013
 *
 */
public class GenericResourceBundleMessageResolver extends ResourceBundleAwareMessageResolver {

	private Locale locale;
	
	/**
	 * 
	 * @param bundleName
	 */
	public GenericResourceBundleMessageResolver(String bundleName) {
		this(bundleName, null);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param locale
	 */
	public GenericResourceBundleMessageResolver(String bundleName, Locale locale) {
		super();
		setBundleName(bundleName);
		setLocale(locale);
	}

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.validations.core.MessageResolver#resolveMessage(java.lang.String)
	 */
	@Override
	public String resolveMessage(String key) {
		// TODO Auto-generated method stub
		if (key == null || key.isEmpty()) {
			return key;
		}
		
		return getBundle(locale).getString(key);
	}
}
