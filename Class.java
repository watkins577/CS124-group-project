import java.util.ArrayList;


public class Class {
	
	private String name;
	private String extendsFrom;
	private boolean hasMain;
	private ArrayList<Method> methods;
	private ArrayList<Field> fields;
	
	/**
	 * Creates a class with no default fields used
	 * @param _name Name of the Class
	 * @param _extendsFrom What class does this extend from
	 * @param _hasMain Does it have the main method
	 * @param _methods An ArrayList of methods
	 * @param _fields An ArrayList of fields
	 */
	Class (String _name, String _extendsFrom, boolean _hasMain, ArrayList<Method> _methods, ArrayList<Field> _fields) {
		name = _name;
		extendsFrom = _extendsFrom;
		hasMain = _hasMain;
		methods = _methods;
		fields = _fields;
	}
	
	/**
	 * Creates a class from a name. Defaults that it does not extend anything, does not include the main method, and has no methods or fields
	 * @param _name Name of the Class
	 */
	Class (String _name) {
		name = _name;
		extendsFrom = null;
		hasMain = false;
		methods = new ArrayList<Method>();
		fields = new ArrayList<Field>();
	}

	public String getName() {
		return name;
	}

	public String getExtendsFrom() {
		return extendsFrom;
	}

	public boolean isHasMain() {
		return hasMain;
	}

	public ArrayList<Method> getMethods() {
		return methods;
	}

	public ArrayList<Field> getFields() {
		return fields;
	}
	
	public Class addMethod(Method _method) {
		methods.add(_method);
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
			if (m.getName().equals(_method.getName())) {
				return methods.indexOf(m);
			}
		}
		return -1;
	}
	
	public Class addField(Field _field) {
		fields.add(_field);
		return this;
	}

	public void setExtendsFrom(String extendsFrom) {
		this.extendsFrom = extendsFrom;
	}

}
