/**
 * 
 */
package za.co.sindi.validations.core.constraint.impl;

import za.co.sindi.validations.core.constraint.StringConstraint;

/**
 * @author Buhake Sindi
 * @since 18 July 2012
 *
 */
public class ContainsConstraint extends StringConstraint {

	private String characters;
	
	/**
	 * @param characters
	 */
	public ContainsConstraint(String characters) {
		super();
		if (characters == null) {
			throw new IllegalArgumentException("Characters may not be null.");
		}
		
		this.characters = characters;
//		setMessage("Value contains the following string '" + characters + "'.");
	}


	/* (non-Javadoc)
	 * @see za.co.bayport.validations.core.Constraint#isValid(java.lang.Object)
	 */
	public boolean isValid(String value) {
		// TODO Auto-generated method stub
		if (value == null) {
			return false;
		}
		
		return value.contains(characters);
	}
}
