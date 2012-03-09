package SwingProject.Backend;

public class TestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Class test = (new Class("Bacon")).setHasMain(true);
		test.addField(new Field("Test", true, "String"));
		test.addField(new Field("Test", false, "Bacon"));
		test.addMethod(new Method("Test").addParam(new Field("t", "type"))
				.addParam(new Field("f", "field")));
		test.addMethod(new Method("Test").addParam(new Field("f", "field"))
				.addParam(new Field("t", "type")));
		test.setExtendsFrom("String");
		System.out.println(JavaGenerator.createJavaCode(test));
	}

}
