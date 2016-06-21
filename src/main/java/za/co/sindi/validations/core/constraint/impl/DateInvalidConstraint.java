/**
 * 
 */
package za.co.sindi.validations.core.constraint.impl;

import java.util.Locale;

import za.co.sindi.validations.core.constraint.StringConstraint;

/**
 * @author Buhake Sindi
 * @since 18 July 2012
 *
 */
public class DateInvalidConstraint extends StringConstraint {

	private String pattern;
	private Locale locale;
	private boolean lenient;
	
	/**
	 * @param pattern
	 * @param lenient
	 */
	public DateInvalidConstraint(String pattern, boolean lenient) {
		this(pattern, null, lenient);
	}

	/**
	 * @param pattern
	 * @param locale
	 * @param lenient
	 */
	public DateInvalidConstraint(String pattern, Locale locale, boolean lenient) {
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
		DateValidConstraint constraint = null;
		if (locale != null) {
			constraint = new DateValidConstraint(pattern, locale, lenient);
		} else {
			constraint = new DateValidConstraint(pattern, lenient);
		}
		return !constraint.isValid(value);
	}
}
