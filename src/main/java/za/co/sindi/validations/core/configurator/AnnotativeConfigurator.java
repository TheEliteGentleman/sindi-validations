/**
 * 
 */
package za.co.sindi.validations.core.configurator;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Level;
import java.util.logging.Logger;

import za.co.sindi.validations.core.Configurator;
import za.co.sindi.validations.core.ValidationFactory;
import za.co.sindi.validations.core.Validator;
import za.co.sindi.validations.core.factory.BasicValidationFactory;
import za.co.sindi.validations.exception.ConfigurationException;

/**
 * @author Bienfait Sindi
 * @since 13 February 2013
 *
 */
public class AnnotativeConfigurator implements Configurator {

	private static final String PATH_SEPARATOR = File.pathSeparator;
	private static final String FILE_SEPARATOR = File.separator;
	private static final String JAVA_CLASS_EXTENSION = ".class";
	private static final String JAVA_JAR_EXTENSION = ".jar";
	private static final Logger LOGGER = Logger.getLogger(AnnotativeConfigurator.class.getName());
	private final String packageName;
	private ClassLoader classLoader;
	
	/**
	 * @param packageName
	 */
	public AnnotativeConfigurator(String packageName) {
		super();
		if (packageName == null || packageName.isEmpty()) {
			throw new IllegalArgumentException("A package name is required.");
		}
		
		this.packageName = packageName;
	}


	/* (non-Javadoc)
	 * @see za.co.sindi.validations.core.Configurator#createValidationFactory()
	 */
	@Override
	public ValidationFactory createValidationFactory() throws ConfigurationException {
		// TODO Auto-generated method stub
		if (classLoader == null) {
			classLoader = Thread.currentThread().getContextClassLoader();
		}
		
		if (classLoader == null) {
			classLoader = this.getClass().getClassLoader();
		}
		
		if (classLoader == null) {
			throw new IllegalStateException("Unable to initialize ClassLoader.");
		}
		
		ValidationFactory factory = null;
		try {
			String path = packageName.replace(".", PATH_SEPARATOR);
			Enumeration<URL> resources = classLoader.getResources(path);
			if (resources != null) {
				Set<Class<? extends Validator<?>>> validatorClasses = new LinkedHashSet<Class<? extends Validator<?>>>();
				
				while (resources.hasMoreElements()) {
					scan(resources.nextElement().getFile(), packageName, validatorClasses);
				}
				
				try {
					if (!validatorClasses.isEmpty()) {
						factory = new BasicValidationFactory();
						
						for (Class<? extends Validator<?>> validatorClass : validatorClasses) {
							za.co.sindi.validations.core.validator.Validator validator = validatorClass.getAnnotation(za.co.sindi.validations.core.validator.Validator.class);
							if (validator.value() == null || validator.value().isEmpty()) {
								throw new ConfigurationException("Class '" + validatorClass.getName() + "' contains @Validator with no id provided.");
							}
							
							if (LOGGER.isLoggable(Level.INFO)) {
								LOGGER.info("Registering validator '" + validatorClass.getName() + "' to id '" + validator.value() + "' in the Validation factory.");
							}
							
							factory.registerValidator(validator.value(), validatorClass);
						}
					}
				} finally {
					validatorClasses.clear();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ConfigurationException(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ConfigurationException(e);
		}
		
		return factory;
	}
	
	@SuppressWarnings("unchecked")
	private void scan(String path, String packageName, Set<Class<? extends Validator<?>>> classes) throws IOException, ClassNotFoundException {
		File file = new File(path);
		if (!file.exists()) {
			if (LOGGER.isLoggable(Level.INFO)) {
				LOGGER.info("Path '" + path + "' doesn't exist. Skipping...");
			}
			
			return;
		}

		if (file.isDirectory()) {
			for (String dir : file.list()) {
				scan(file.getCanonicalPath() + FILE_SEPARATOR + dir, packageName, classes);
			}
		} else {
			if (path.endsWith(JAVA_JAR_EXTENSION)) {
				URL url = new URL("jar", "", -1, file.toURI().toURL().toString() + "!/");
				readJarEntries(url, packageName.replace('.', '/'), classes);
			} else if (path.endsWith(JAVA_CLASS_EXTENSION)) {
				String packagePath = packageName.replace(".", FILE_SEPARATOR);
				if (path.contains(packagePath)) {
					String className = path.substring(path.indexOf(packagePath) + 1, path.indexOf(JAVA_CLASS_EXTENSION)).replace(FILE_SEPARATOR, ".");
					Class<?> clazz = classLoader.loadClass(className);
					if (match(clazz)) {
						if (LOGGER.isLoggable(Level.INFO)) {
							LOGGER.info("Found matched class '" + className + "'. Adding to set.");
						}
						classes.add((Class<? extends Validator<?>>) clazz);
					}
				}
			}
		}
	}
	
	/**
	 * Read the JAR file and adds classes that matches our {@link TypeFilter}.
	 * 
	 * @param jarURL
	 * @param packagePath
	 * @param classes
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	private void readJarEntries(URL jarURL, String packagePath, Set<Class<? extends Validator<?>>> classes) throws IOException, ClassNotFoundException {
		JarURLConnection jarConn = (JarURLConnection) jarURL.openConnection();
		JarFile jarFile = jarConn.getJarFile();
		Enumeration<JarEntry> entries = jarFile.entries();
		while (entries != null && entries.hasMoreElements()) {
			JarEntry entry = entries.nextElement();
			if (entry.isDirectory()) continue;
			
			String name = entry.getName();
			if (!name.startsWith(packagePath) || name.equals(packagePath)) continue;
			
			name = name.substring(packagePath.length());
			if (name.contains("/")) continue;
			
			if (name.endsWith(JAVA_CLASS_EXTENSION)) {
				URLClassLoader classLoader = new URLClassLoader(new URL[] {jarURL});
				Class<?> clazz = classLoader.loadClass(entry.getName().substring(0, entry.getName().length() - JAVA_CLASS_EXTENSION.length()));
				if (match(clazz)) {
					if (LOGGER.isLoggable(Level.INFO)) {
						LOGGER.info("Found matched class '" + clazz.getName() + "' in JAR '" + jarURL.getPath() + "'. Adding to set.");
					}
					classes.add((Class<? extends Validator<?>>) clazz);
				}
				//Finally
				classLoader.close();
			}
		}
	}
	
	private boolean match (Class<?> clazz) {
		return (clazz.getAnnotation(za.co.sindi.validations.core.validator.Validator.class) != null && Validator.class.isAssignableFrom(clazz)); 
	}
}
