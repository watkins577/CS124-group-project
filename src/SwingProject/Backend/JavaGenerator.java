package SwingProject.Backend;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class JavaGenerator {

	/**
	 * This will create Java code from a Class object
	 * 
	 * @param _class
	 * @return
	 */
	public static boolean createJavaCode(Class _class) {
		File file = new File(new StringBuilder().append(_class.getName())
				.append(".java").toString());
		File file1 = new File(new StringBuilder().append("tmp_")
				.append(_class.getName()).append(".java").toString());
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
					file1)));
			pw.print("public class " + _class.getName());
			if (_class.getExtendsFrom() != null) {
				pw.print(" extends " + _class.getExtendsFrom());
			}
			pw.println(" {");
			pw.println();
			pw.println();
			for (Field f : _class.getFields()) {
				pw.println(getFieldStatementFromField(f));
			}
			pw.println();
			pw.println();
			for (Method m : _class.getMethods()) {
				pw.println(getMethodStatementFromMethod(m));
				pw.println("          ");
				pw.println("     }");
				pw.println();
				pw.println();
			}
			if (_class.getHasMain()) {
				pw.println("     public static void main(String[] args) {");
				pw.println("          ");
				pw.println("     }");
			}
			pw.println();
			pw.println();
			pw.println("}");
			pw.close();
			if (file.exists()) {
				file.delete();
			}
			file1.renameTo(file);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private static String getMethodStatementFromMethod(Method m) {
		StringBuilder statement = new StringBuilder().append("     ");
		if (m.isPrivacy()) {
			statement.append("private");
		} else {
			statement.append("public");
		}
		statement.append(" ").append(m.getReturns()).append(" ")
				.append(m.getName()).append("(");
		int i = 0;
		for (Field f : m.getParameters()) {
			if (i++ != 0) {
				statement.append(", ");
			}
			statement.append(getParamStatementFromField(f));
		}
		statement.append(") {");
		return statement.toString();

	}

	private static String getParamStatementFromField(Field f) {
		StringBuilder statement = new StringBuilder();
		statement.append(f.getType()).append(" ").append(f.getName());
		return statement.toString();
	}

	private static String getFieldStatementFromField(Field f) {
		StringBuilder statement = new StringBuilder().append("     ");
		if (f.isPrivacy()) {
			statement.append("private");
		} else {
			statement.append("public");
		}
		statement.append(" ").append(f.getType()).append(" ")
				.append(f.getName()).append(";");
		return statement.toString();
	}
}
