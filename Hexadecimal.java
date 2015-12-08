public class Hexadecimal {

    private final static String HEXDIGITS = "0123456789ABCDEF";

    private int _decNum;
    private String _hexNum;

    public Hexadecimal() {
	_decNum = 0;
	_hexNum = "0";
    }

    public Hexadecimal( int n ) {
	_decNum = n;
	_hexNum = decToHex(n);
    }

    public Hexadecimal( String s ) {
	_decNum = hexToDec(s);
	_hexNum = s;
    }

    public String toString() {
	return _decNum + " -- " + _hexNum;
    }

    public static String decToHex( int n ) {
	String s = "";
	int rem = 0;
	while (n != 0) {
	    rem = n % 16;
	    if (rem < 10) s = rem + s;
	    if (rem == 10) s = "a" + s;
	    if (rem == 11) s = "b" + s;
	    if (rem == 12) s = "c" + s;
	    if (rem == 13) s = "d" + s;
	    if (rem == 14) s = "e" + s;
	    if (rem == 15) s = "f" + s;
	    n /= 16;
	}
	return s;
    }

    public static int hexToDec( String s ) {
	int n = 0;
	for(int i = s.length(); i > 0; i--) {
	    int temp = 0;
	    try {
		temp = Integer.parseInt(s.substring(i - 1, i));
	    }
	    catch(Exception e) {
		String tmp = s.substring(i - 1, i);
		if (tmp.equals("a")) temp = 10;
	        if (tmp.equals("b")) temp = 11;
		if (tmp.equals("c")) temp = 12;
		if (tmp.equals("d")) temp = 13;
		if (tmp.equals("e")) temp = 14;
		if (tmp.equals("f")) temp = 15;
	    }
	    n += temp * Math.pow(16, s.length() - 1);
	}
	return n;
    }

    public boolean equals( Object other ) {
	return compareTo(other) == 0;
    }

    public int compareTo( Object other ) {
	if(this == other) return 0;
	if(other instanceof Hexadecimal) {
	    if (_decNum < ((Hexadecimal)other)._decNum) return -1;
	    if (_decNum > ((Hexadecimal)other)._decNum) return 1;
	    if (_decNum == ((Hexadecimal)other)._decNum) return 0;
	}
	else throw new ClassCastException("\n My first error message! "
					  + "compareTo() input not Hexadecimal!!!");
	return 999;
    }

    public static void main( String[] args ) {
	
	Hexadecimal h1 = new Hexadecimal(5);
	Hexadecimal h2 = new Hexadecimal(4);
	Hexadecimal h3 = new Hexadecimal(19);
	Hexadecimal h4 = new Hexadecimal(144);

	Hexadecimal h5 = new Hexadecimal("1");
	Hexadecimal h6 = new Hexadecimal("1c");
	Hexadecimal h7 = new Hexadecimal("def");
	Hexadecimal h8 = new Hexadecimal("90");

	Hexadecimal h9 = h1;

	System.out.println("h1: " + h1);
	System.out.println("h2: " + h2);
	System.out.println("h3: " + h3);
	System.out.println("h4: " + h4);
	System.out.println("h5: " + h5);
	System.out.println("h6: " + h6);
	System.out.println("h7: " + h7);
	System.out.println("h8: " + h8);

	System.out.println("\n==...");
	System.out.println(h1 == h2); //should be false
	System.out.println(h1 == h9); //should be true

	System.out.println("\n.equals()...");
	System.out.println(h1.equals(h3)); //should be false
	System.out.println(h1.equals(h9)); //should be true
	System.out.println(h4.equals(h6)); //should be false
	System.out.println(h4.equals(h8)); //should be true

	System.out.println("n.compareTo()...");
	System.out.println(h1.compareTo(h3)); //should be neg
	System.out.println(h3.compareTo(h1)); //should be pos
	System.out.println(h1.compareTo(h9)); //should be 0
	System.out.println(h4.compareTo(h8)); //should be 0
	
    }//end main()

}//end class
