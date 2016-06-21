/**
 * 
 */
package za.co.sindi.validations.core.configurator;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import za.co.sindi.validations.core.Configurator;
import za.co.sindi.validations.core.ValidationFactory;
import za.co.sindi.validations.core.Validator;
import za.co.sindi.validations.core.factory.BasicValidationFactory;
import za.co.sindi.validations.core.utils.ClassLoaderUtils;
import za.co.sindi.validations.exception.ConfigurationException;

/**
 * @author Bienfait Sindi
 * @since 04 February 2013
 *
 */
public class XMLConfigurator implements Configurator {

	private static final Logger logger = Logger.getLogger(XMLConfigurator.class.getName());
	private static final String TAG_VALIDATION_CONFIG = "validation-config";
	private static final String TAG_VALIDATORS = "validators";
	private static final String TAG_VALIDATOR = "validator";
	private static final String TAG_ID = "id";
	private static final String TAG_CLASS = "class";
	private InputStream input;
	
	/**
	 * @param input
	 * @throws IOException 
	 */
	public XMLConfigurator(URL resource) throws IOException {
		super();
		if (resource == null) {
			throw new IllegalArgumentException("A URL resource is required.");
		}
		
		this.input = resource.openStream();
	}
	
	/**
	 * @param input
	 */
	public XMLConfigurator(InputStream input) {
		super();
		if (input == null) {
			throw new IllegalArgumentException("An input stream is required.");
		}
		
		this.input = input;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.validations.core.Configurator#createValidationFactory()
	 */
	@Override
	public ValidationFactory createValidationFactory() throws ConfigurationException {
		// TODO Auto-generated method stub
		ValidationFactory validationFactory = null;
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputSource iSource = new InputSource(input);
			Element rootElement = builder.parse(iSource).getDocumentElement();
			
			//This MUST exist, even if there are no sub-elements
			if (!TAG_VALIDATION_CONFIG.equals(rootElement.getTagName())) {
				throw new ConfigurationException("Unknown tag name '" + rootElement.getTagName() + "'. Expected '" + TAG_VALIDATION_CONFIG + "'.");
			}
			
			//Get NodeList
			NodeList nodes = rootElement.getElementsByTagName(TAG_VALIDATORS);
			if (nodes != null && nodes.getLength() > 0) {
				
				if (nodes.getLength() != 1) {
					throw new ConfigurationException("There can only be one '" + TAG_VALIDATORS +"' tag (we found " + nodes.getLength() + ").");
				}
				
				//Initiate validator factory.
				validationFactory = new BasicValidationFactory();
				
				//Iterate through validator
				nodes = ((Element)nodes.item(0)).getElementsByTagName(TAG_VALIDATOR);
				if (nodes != null) {
					for (int i = 0; i < nodes.getLength(); i++) {
						Element item = (Element) nodes.item(i);
						NodeList ids = ((Element)item).getElementsByTagName(TAG_ID);
						NodeList classes = ((Element)item).getElementsByTagName(TAG_CLASS);
						
						if (ids == null || ids.getLength() != 1) {
							throw new ConfigurationException("<" + TAG_VALIDATOR + "> can only contain 1 <" + TAG_ID + "> element.");
						}
						
						if (classes == null || classes.getLength() != 1) {
							throw new ConfigurationException("<" + TAG_VALIDATOR + "> can only contain 1 <" + TAG_CLASS + "> element.");
						}
						
						String validatorId = ((Element)ids.item(0)).getNodeValue();
						String className = ((Element)classes.item(0)).getNodeValue();
						Class<? extends Validator<?>> validatorClass = ClassLoaderUtils.getClass(className);
						if (!Validator.class.isAssignableFrom(validatorClass)) {
							throw new ConfigurationException("Validator class '" + className + "' is not a valid " + Validator.class.getName() + " instance.");
						}
						
						if (logger.isLoggable(Level.INFO)) {
							logger.info("Register validator (validator id: " + validatorId + ", class: " + className + ").");
						}
						validationFactory.registerValidator(validatorId, validatorClass);
					}
				}
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			throw new ConfigurationException(e);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			throw new ConfigurationException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ConfigurationException(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ConfigurationException(e);
		}
		
		return validationFactory;
	}
}
