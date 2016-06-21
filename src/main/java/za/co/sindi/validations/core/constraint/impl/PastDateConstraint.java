/**
 * 
 */
package za.co.sindi.validations.core.constraint.impl;

import java.util.Date;

import za.co.sindi.validations.core.AbstractConstraint;

/**
 * @author Buhake Sindi
 * @since 23 July 2012
 *
 */
public class PastDateConstraint extends AbstractConstraint<Date> {

	private Date when;
	
	/**
	 * @param when
	 */
	public PastDateConstraint(Date when) {
		super();
		if (when == null) {
			throw new IllegalArgumentException("when cannot be null.");
		}
		
		this.when = when;
	}

	/* (non-Javadoc)
	 * @see za.co.bayport.validations.core.Constraint#isValid(java.lang.Object)
	 */
	@Override
	public boolean isValid(Date value) {
		// TODO Auto-generated method stub
		if (value == null) {
			return false;
		}
		
		return value.before(when);
	}
}
