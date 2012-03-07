
public class Field {
	
	private String name;
	private boolean privacy;
	private String type;
	
	Field(String _name, boolean _privacy, String _type) {
		name = _name;
		privacy = _privacy;
		type = _type;
	}
	
	Field(String _name, String _type) {
		name = _name;
		privacy = false;
		type = _type;
	}
	
	public String getName() {
		return name;
	}

	public boolean isPrivacy() {
		return privacy;
	}
	
	public Field setPrivacy(boolean p) {
		privacy = p;
		return this;
	}

	public String getType() {
		return type;
	}
	
	public Field setType(String t) {
		type = t;
		return this;
	}
}
