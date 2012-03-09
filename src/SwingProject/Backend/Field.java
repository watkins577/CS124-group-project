package SwingProject.Backend;

import java.io.Serializable;

public class Field implements Serializable {

	private String name;
	private boolean privacy;
	private String type;

	public Field(String _name, boolean _privacy, String _type) {
		name = _name;
		privacy = _privacy;
		type = _type;
	}

	public Field(String _name, String _type) {
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

	public boolean equalsName(Field f) {
		return f.getName().equals(name);
	}

	public boolean equals(Field f) {
		return (f.getType().equals(type) && equalsName(f));
	}
}
