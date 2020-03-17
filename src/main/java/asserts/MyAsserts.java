package asserts;

public class MyAsserts {
	public static void assertTrue(Object obj) {
		if (obj.equals(true))
			System.out.println("Test passed:\n\tExpected: true\n\tResult: true");
		else
			System.out.println("Test failed:\n\tExpected: true\n\tResult: false");
	}

	public static void assertNotNull(Object obj) {
		if (obj == null)
			System.out.println("Test failed:\n\tExpected: Not Null");
		else
			System.out.println("Test passed:\n\tObject Not Null");
	}

	public static void assertEquals(Object obj1, Object obj2) {
		if (obj1.equals(obj2))
			System.out.println("Test passed:\n\tExpected: " + obj1 +
					"\n\tResult: " + obj2);
		else
			System.out.println("Test failed:\n\tExpected: " + obj1 +
					"\n\tResult: " + obj2);
	}
}
