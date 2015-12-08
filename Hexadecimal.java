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

}
