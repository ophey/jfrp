
public class Main {

    /*
      basic data types: 
     */
    static Class bc = Boolean.class;
    static boolean b = true;
    static Class lc = Long.class;
    static long l = 3;
    static Class dc = Double.class;
    static double d = 3.141;
    static Class cc = Character.class;
    static char c = 'c';
    static Class sc = String.class;
    static String s = "world";

    static String[] members = {
	val(b),
	val(c),
	val(l),
	val(d),
	val(s)
    };
    
    public static void main(String[] args) {
	for(String m : members) {
	    putln(m);
	    putln(typeOf(m).getName());
	}
	return;
    }

    static Class typeOf(String v) {
	Class result = sc;
	if(isBoolean(v)) result = bc;
	if(isNumber(v)) {
	    if(isLong(v)) result = lc;
	    if(isDouble(v)) result = dc;
	}
	if(isCharacter(v)) return result = cc;
	putln(""+val(v)+result);
	return result;
    }

    static boolean isBoolean(String v) {
	return Boolean.TRUE.toString().equalsIgnoreCase(v)
	    || Boolean.FALSE.toString().equalsIgnoreCase(v);
    }
    static boolean isNumber(String v) {
	return v.length() > 0 &&
	    (v.charAt(0) == '+'
	     || v.charAt(0) == '-'
	     || Character.isDigit(v.charAt(0)));
    }
    static boolean isLong(String v) {
	try {
	    Long.valueOf(v);
	} catch (NumberFormatException nfe) {
	    return false;
	}
	return true;
    }
    static boolean isDouble(String v) {
	try {
	    Double.valueOf(v);
	} catch (NumberFormatException nfe) {
	    return false;
	}
	return true;
    }
    static boolean isCharacter(String v) {
	return v.length() == 1;
    }
    static String val(boolean b) {
	return String.valueOf(b);
    }
    static String val(char b) {
	return String.valueOf(b);
    }
    static String val(long b) {
	return String.valueOf(b);
    }
    static String val(double b) {
	return String.valueOf(b);
    }
    static String val(String b) {
	return String.valueOf(b);
    }
    
    static void putln(String s) {
	System.out.println(s);
    }
    /*
      Construct a new relation type from the given type by 
      reducing it to the given fields. 
      (This will be the relation type for the result of projecting
      a record of the given relation type to the given fields)
     */
    static Object[][] project(Object[][] type, String[] fields) {
	Object[][] result = new Object[fields.length][2];
	for(int i = 0; i < fields.length; i++) {
	    for(int j = 0; j < type.length; j++) {
		if(type[j][0].equals(fields[i])) {
		    result[i][0] = type[j][0];
		    result[i][1] = type[j][1];
		}
	    }
	}
	return result;
    }

    /*
      Construct a new record by reducing the given record of the given 
      relation type to the given fields.
     */
    static String[] project(Object[][] type, String[] record, String[] fields) {
	String[] result = new String[fields.length];
	for(int i = 0; i < fields.length; i++) {
	    for(int j = 0; j < type.length; j++) {
		if(type[j][0].equals(fields[i])) {
		    result[i] = record[j];
		}
	    }
	}
	return result;
    }
}
