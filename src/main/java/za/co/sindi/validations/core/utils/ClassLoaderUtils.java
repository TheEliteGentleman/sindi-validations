/**
 * 
 */
package za.co.sindi.validations.core.utils;


/**
 * @author Bienfait Sindi
 * @since 07 February 2013
 *
 */
public final class ClassLoaderUtils {

	/**
	 * 
	 */
	private ClassLoaderUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public static <T> Class<T> getClass(String className) throws ClassNotFoundException {
		return getClass(className, null);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> Class<T> getClass(String className, ClassLoader classLoader) throws ClassNotFoundException {
		if (classLoader == null) {
			classLoader = Thread.currentThread().getContextClassLoader();
			
			if (classLoader == null) {
				classLoader = ClassLoaderUtils.class.getClassLoader();
			}
		}
		
		return (Class<T>) classLoader.loadClass(className);
	}
}
