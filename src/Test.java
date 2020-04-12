

public class Test extends Main {

    public static void main(String[] args) {

	testEquals(Boolean.class, typeOf("false"));
	testEquals(Boolean.class, typeOf("true"));
	testEquals(Long.class, typeOf("12ABC"));
	testEquals(Double.class, typeOf("3.414"));
	testEquals(Character.class, typeOf("A"));
	testEquals(String.class, typeOf("ABC"));


	// a relation type definition

	/* field names and types in one array */
	Object[][] addressFields = {
	    { "street", String.class },
	    { "number", Long.class },
	    { "zip", Long.class },
	    { "city", String.class } 
	};
	String[] addressValue = {
	    "White Rock Lake", "23", "1024", "Dallas"
	};

	for(int i = 0; i < addressFields.length; i++) {
	    testEquals(addressFields[i][1], typeOf(addressValue[i]));
	}

	String[] cityAndZip = { "city", "zip" };
	Object[][] cityAndZipFields = project(addressFields, cityAndZip);
	String[] cityAndZipValue = project(addressFields, addressValue, cityAndZip);

	for(int i = 0; i < cityAndZipFields.length; i++) {
	    testEquals(cityAndZipFields[i][1], typeOf(cityAndZipValue[i]));
	}

	for(String failure : failures) {
	    if(failure != null) {
		putln(failure);
	    }
	}
	putln("Total Failures: " + failureCount);

    }

    
    static void testEquals(Object expected, Object actual) {
	if(!expected.equals(actual)) {
	    failures[failureCount] = "Expected: " + expected + " Acutal: " + actual;
	    failureCount++;
	}
    }


    static int failureCount = 0;
    static String[] failures = {
	null,
	null,
	null,
	null,
	null,
	null,
	null,
	null,
	null,
	null, /* 10 */

	null,
	null,
	null,
	null,
	null,
	null,
	null,
	null,
	null,
	null, /* 10 */

    };
}
