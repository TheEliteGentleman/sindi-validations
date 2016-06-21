/**
 * 
 */
package za.co.sindi.validations.core;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Bienfait Sindi
 * @since 03 February 2013
 *
 */
public abstract class ResourceBundleAwareMessageResolver implements MessageResolver {

	private Map<Locale, ResourceBundle> resourceBundleMap = new ConcurrentHashMap<Locale, ResourceBundle>(); 
	private String bundleName;
	
	/**
	 * @param bundleName the bundleName to set
	 */
	protected void setBundleName(String bundleName) {
		if (bundleName == null || bundleName.isEmpty()) {
			throw new IllegalArgumentException("A resource bundle name may not be null nor empty.");
		}
		
		this.bundleName = bundleName;
	}

	protected ResourceBundle getBundle(Locale locale) {
		// TODO Auto-generated method stub
		if (locale == null) {
			//Default 
			locale = Locale.getDefault();
		}
		
		ResourceBundle bundle = resourceBundleMap.get(locale);
		if (bundle == null) {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			if (classLoader == null) {
				classLoader = this.getClass().getClassLoader();
			}
			
			bundle = ResourceBundle.getBundle(bundleName, locale, classLoader);
			resourceBundleMap.put(locale, bundle);
		}
		
		return bundle;
	}
}
