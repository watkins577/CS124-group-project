package SwingProject.Backend;

import java.io.Serializable;
import java.util.ArrayList;

public class Class implements Serializable{

	private String name;
	private String extendsFrom;
	private boolean hasMain;
	private ArrayList<Method> methods;
	private ArrayList<Field> fields;

	/**
	 * Creates a class with no default fields used
	 * 
	 * @param _name
	 *            Name of the Class
	 * @param _extendsFrom
	 *            What class does this extend from
	 * @param _hasMain
	 *            Does it have the main method
	 * @param _methods
	 *            An ArrayList of methods
	 * @param _fields
	 *            An ArrayList of fields
	 */
	public Class(String _name, String _extendsFrom, boolean _hasMain,
			ArrayList<Method> _methods, ArrayList<Field> _fields) {
		name = _name;
		extendsFrom = _extendsFrom;
		hasMain = _hasMain;
		methods = _methods;
		fields = _fields;
	}

	/**
	 * Creates a class from a name. Defaults that it does not extend anything,
	 * does not include the main method, and has no methods or fields
	 * 
	 * @param _name
	 *            Name of the Class
	 */
	public Class(String _name) {
		name = _name;
		extendsFrom = null;
		hasMain = false;
		methods = new ArrayList<Method>();
		fields = new ArrayList<Field>();
	}

	/**
	 * Gets the name of the class
	 * 
	 * @return The name of the class
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets what the class extends from
	 * 
	 * @return What the class extends from
	 */
	public String getExtendsFrom() {
		return extendsFrom;
	}

	/**
	 * Gets if this class contains the main method
	 * 
	 * @return If the class has the main method
	 */
	public boolean getHasMain() {
		return hasMain;
	}

	public Class setHasMain(boolean _hasMain) {
		hasMain = _hasMain;
		return this;
	}

	/**
	 * Returns an arraylist of the methods
	 * 
	 * @return An arraylist of the methods
	 */
	public ArrayList<Method> getMethods() {
		return methods;
	}

	/**
	 * Returns an arraylist of the fields
	 * 
	 * @return An arraylist of the fields
	 */
	public ArrayList<Field> getFields() {
		return fields;
	}

	public Class addMethod(Method _method) {
		if (doMethodsContainMethod(_method) == -1) {
			methods.add(_method);
		}
		return this;
	}

	public Class removeMethod(Method _method) {
		int methodAt = doMethodsContainMethod(_method);
		if (methodAt != -1) {
			methods.remove(methodAt);
		}
		return this;
	}

	public int doMethodsContainMethod(Method _method) {
		for (Method m : methods) {
			if (m.equals(_method)) {
				return methods.indexOf(m);
			}
		}
		return -1;
	}

	public Class addField(Field _field) {
		if (doFieldsContainField(_field) == -1) {
			fields.add(_field);
		}
		return this;
	}

	public Class removeField(Field _field) {
		int fieldAt = doFieldsContainField(_field);
		if (fieldAt != -1) {
			fields.remove(fieldAt);
		}
		return this;
	}

	private int doFieldsContainField(Field _field) {
		for (Field f : fields) {
			if (f.equalsName(_field)) {
				return fields.indexOf(f);
			}
		}
		return -1;
	}

	public void setExtendsFrom(String extendsFrom) {
		this.extendsFrom = extendsFrom;
	}

}
