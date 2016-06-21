/**
 * 
 */
package za.co.sindi.validations.core.constraint.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;

import za.co.sindi.validations.core.constraint.StringConstraint;

/**
 * @author Buhake Sindi
 * @since 18 July 2012
 *
 */
public class DateValidConstraint extends StringConstraint {

	private String pattern;
	private Locale locale;
	private boolean lenient;
	
	/**
	 * @param pattern
	 * @param lenient
	 */
	public DateValidConstraint(String pattern, boolean lenient) {
		this(pattern, null, lenient);
	}

	/**
	 * @param pattern
	 * @param locale
	 * @param lenient
	 */
	public DateValidConstraint(String pattern, Locale locale, boolean lenient) {
		super();
		
		if (pattern == null || pattern.isEmpty()) {
			throw new IllegalArgumentException("Date pattern may not be null or empty.");
		}
		
		this.pattern = pattern;
		this.locale = locale;
		this.lenient = lenient;
	}

	/* (non-Javadoc)
	 * @see za.co.bayport.validations.core.Constraint#isValid(java.lang.Object)
	 */
	public boolean isValid(String value) {
		// TODO Auto-generated method stub
		if (value == null) {
			return false;
		}
		
		//I thought of using regular expression, but I will have to be intelligent enough to find all possible outcomes.
		//This is easier.
		DateFormat format = null;
		if (locale != null) {
			format = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
		} else {
			format = new SimpleDateFormat(pattern);
		}
		
		format.setLenient(lenient);
		Date date = null;
		try {
			date = format.parse(value);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			logger.log(Level.SEVERE, "Error validating date using DateFormat with pattern '" + pattern +"'. Failing this...", e);
			date = null;
		}
		
		return (date != null);
	}
}
