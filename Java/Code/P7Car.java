class Vehicle {}
//These class explains the use of instanceof operator

public class P7Car extends Vehicle{
public static void main(String[] args) {
    Vehicle a = new P7Car();
    boolean result = a instanceof P7Car;
    System.out.println("result = " + result);
}
}
