import java.util.ArrayList;

public class Method {

	private String name;
	private boolean privacy;
	private String returns;
	private ArrayList<Field> parameters;
	
	/**
	 * Creates a method with no default fields used
	 * @param _name Name of the method
	 * @param _privacy The privacy of the method. true for private, false for public
	 * @param _returns What the method returns
	 * @param _parameters The parameters of the method
	 */
	Method(String _name, boolean _privacy, String _returns, ArrayList<Field> _parameters) {
		name = _name;
		privacy = _privacy;
		returns = _returns;
		parameters = _parameters;
	}
	
	/**
	 * Creates a method. Defaults that it is public, returns nothing, and has no parameters
	 * @param _name Name of the method
	 */
	Method(String _name) {
		name = _name;
		privacy = false;
		returns = "void";
		parameters = new ArrayList<Field>();
	}
	
	/**
	 * Gets the name of the method
	 * @return The name of the method
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the privacy of the method
	 * @return true if private, false if public
	 */
	public boolean isPrivacy() {
		return privacy;
	}
	
	/**
	 * Sets the privacy of the method
	 * @param p New privacy: true for private, false for public
	 * @return The method being called upon
	 */
	public Method setPrivacy(boolean p) {
		privacy = p;
		return this;
	}
	
	/**
	 * Gets what this method returns
	 * @return The return of this method
	 */
	public String getReturns() {
		return returns;
	}
	
	/**
	 * Sets the returns of the method
	 * @param s New return
	 * @return The method being called upon
	 */
	public Method setReturns(String s) {
		returns = s;
		return this;
	}
	
	/**
	 * Gets the parameters of the method
	 * @return The parameters of the method
	 */
	public ArrayList<Field> getParameters() {
		return parameters;
	}
	
	/**
	 * Adds a parameter to the method if the parameter does not exist
	 * @param _field The parameter to add
	 * @return The method being called upon
	 */
	public Method addParam(Field _field) {
		if (doParamsContainParameter(_field) == -1) {
			parameters.add(_field);
		}
		return this;
	}
	
	/**
	 * Removes a parameter from the method if the parameter exists
	 * @param _field The parameter to remove
	 * @return The method being called upon
	 */
	public Method removeParam(Field _field) {
		int paramAt = doParamsContainParameter(_field);
		if (paramAt != -1) {
			parameters.remove(paramAt);
		}
		return this;
	}
	
	/**
	 * Checks if a parameter already exists, just by name
	 * @param _field The parameter to check
	 * @return The index of where it exists, or -1 if non-existent
	 */
	private int doParamsContainParameter(Field _field) {
		for (Field f : parameters) {
			if (f.getName().equals(_field.getName())) {
				return parameters.indexOf(f);
			}
		}
		return -1;
	}
}
