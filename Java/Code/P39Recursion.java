public class P39Recursion {
    // Recursive method to calculate factorial
    public static int factorial(int n) {
        if (n == 0) {
            return 1;  // Base case: factorial of 0 is 1
        } else {
            return n * factorial(n - 1);  // Recursive case
        }
    }

    public static void main(String[] args) {
        int num = 5;
        int result = factorial(num);
        System.out.println("Factorial of " + num + " is: " + result);
    }
}

