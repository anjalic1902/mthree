public class P5WideningTypeCasting {
    public static void main(String[] args) {
        // Starting with byte
        byte byteValue = 10;
        System.out.println("Original byte value: " + byteValue);

        // byte to short
        short shortValue = byteValue;
        System.out.println("byte to short: " + shortValue);

        // short to char
        // Note: This is not a direct widening conversion, as char is unsigned
        // We'll use a positive short value to demonstrate
        short positiveShort = 65;  // ASCII value for 'A'
        char charValue = (char) positiveShort;
        System.out.println("short to char: " + charValue);

        // char to int
        int intFromChar = charValue;
        System.out.println("char to int: " + intFromChar);

        // int to long
        long longValue = intFromChar;
        System.out.println("int to long: " + longValue);

        // long to float
        float floatValue = longValue;
        System.out.println("long to float: " + floatValue);

        // float to double
        double doubleValue = floatValue;
        System.out.println("float to double: " + doubleValue);

        // Demonstrating multiple steps of widening in one assignment
        int bigInt = 1234567;
        double doubleFromInt = bigInt;
        System.out.println("int directly to double: " + doubleFromInt);

        // Demonstrating widening in expressions
        byte small = 10;
        short medium = 100;
        int result = small + medium;  // byte and short are promoted to int
        System.out.println("Result of byte + short (as int): " + result);

        // Widening with literals
        int largeInt = 2_000_000_000;  // 2 billion
        long veryLarge = largeInt * 3L;  // Result is too large for int, so it's widened to long
        System.out.println("Large calculation result (as long): " + veryLarge);

        // Demonstrating potential loss of precision
        long veryPrecise = 123456789123456789L;
        float lessPrecise = veryPrecise;  // Potential loss of precision
        System.out.println("Long to float (potential precision loss): " + lessPrecise);
    }
}
