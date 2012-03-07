
public class TestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Class test = new Class("Bacon");
		test.addField(new Field("Test", true, "String"));
		test.addMethod(new Method("Test").addParam(new Field("t", "type")).addParam(new Field("f", "field")));
		test.setExtendsFrom("String");
		JavaGenerator.createJavaCode(test);
	}

}
