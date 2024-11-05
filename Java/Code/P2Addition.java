public class P2Addition {
    public void printDetails() {
        int a = 10;
        a = a + 1;
        System.out.println(a);
    }
    public static void main(String[] args) {
        P2Addition obj = new P2Addition();
        obj.printDetails();
        int a = 30;
        int b = 20;
        int c = a + b;
        System.out.println("The sum of " + a + " and " + b + " is " + c);
    }
    
}
