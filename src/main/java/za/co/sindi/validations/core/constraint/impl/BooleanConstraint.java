/**
 * 
 */
package za.co.sindi.validations.core.constraint.impl;

import za.co.sindi.validations.core.constraint.ObjectConstraint;

/**
 * @author Buhake Sindi
 * @since 18 July 2012
 *
 */
public class BooleanConstraint extends ObjectConstraint {

	/**
	 * 
	 */
	public BooleanConstraint() {
		super();
		// TODO Auto-generated constructor stub
//		setMessage("Value must either be " + String.valueOf(true) + " or " + String.valueOf(false));
	}

	/* (non-Javadoc)
	 * @see za.co.bayport.validations.core.Constraint#isValid(java.lang.Object)
	 */
	public boolean isValid(Object value) {
		// TODO Auto-generated method stub
		TrueConstraint trueConstraint = new TrueConstraint();
		FalseConstraint falseConstraint = new FalseConstraint();
		return (trueConstraint.isValid(value) || falseConstraint.isValid(value));
	}
}
