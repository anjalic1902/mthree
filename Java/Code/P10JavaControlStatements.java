import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class P10JavaControlStatements {

    public static void main(String[] args) {
        // 1. Conditional Statements
        conditionalStatements();

        // 2. Looping Statements
        loopingStatements();

        // 3. Jump Statements
        jumpStatements();

        // 4. Exception Handling
        exceptionHandling();

        // 5. Assertions
        assertions();
    }

    // 1. Conditional Statements
    private static void conditionalStatements() {
        System.out.println("\n--- Conditional Statements ---");

        // 1.1 if statement
        int age = 18;
        if (age >= 18) {
            System.out.println("You are eligible to vote.");
        }

        // 1.2 if-else statement
        int score = 75;
        if (score >= 60) {
            System.out.println("You passed!");
        } else {
            System.out.println("You failed.");
        }

        // 1.3 if-else-if ladder
        int grade = 85;
        if (grade >= 90) {
            System.out.println("Grade: A");
        } else if (grade >= 80) {
            System.out.println("Grade: B");
        } else if (grade >= 70) {
            System.out.println("Grade: C");
        } else if (grade >= 60) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }

        // 1.4 Nested if statements
        boolean hasLicense = true;
        if (age >= 18) {
            if (hasLicense) {
                System.out.println("You can drive.");
            } else {
                System.out.println("You need to get a license first.");
            }
        } else {
            System.out.println("You are too young to drive.");
        }

        // 1.5 switch statement
        int dayOfWeek = 3;
        switch (dayOfWeek) {
            case 1:
                System.out.println("Day: Monday");
                break;
            case 2:
                System.out.println("Day: Tuesday");
                break;
            case 3:
                System.out.println("Day: Wednesday");
                break;
            case 4:
                System.out.println("Day: Thursday");
                break;
            case 5:
                System.out.println("Day: Friday");
                break;
            case 6:
            case 7:
                System.out.println("Day: Weekend");
                break;
            default:
                System.out.println("Invalid day");
        }
    }

    // 2. Looping Statements
    private static void loopingStatements() {
        System.out.println("\n--- Looping Statements ---");

        // 2.1 for loop
        System.out.println("For loop:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteration: " + i);
        }

        // 2.2 Enhanced for loop (for-each)
        System.out.println("\nEnhanced for loop:");
        int[] numbers = {1, 2, 3, 4, 5};
        for (int num : numbers) {
            System.out.println("Number: " + num);
        }

        // 2.3 while loop
        System.out.println("\nWhile loop:");
        int count = 0;
        while (count < 5) {
            System.out.println("Count: " + count);
            count++;
        }

        // 2.4 do-while loop
        System.out.println("\nDo-while loop:");
        int num = 1;
        do {
            System.out.println("Number: " + num);
            num++;
        } while (num <= 5);
    }

    // 3. Jump Statements
    private static void jumpStatements() {
        System.out.println("\n--- Jump Statements ---");

        // 3.1 break statement
        System.out.println("Break statement:");
        for (int i = 1; i <= 10; i++) {
            if (i == 6) {
                break;
            }
            System.out.println("Iteration: " + i);
        }

        // 3.2 continue statement
        System.out.println("\nContinue statement:");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue;
            }
            System.out.println("Iteration: " + i);
        }

        // 3.3 return statement
        System.out.println("\nReturn statement:");
        System.out.println("Sum: " + sum(5, 3));
    }

    private static int sum(int a, int b) {
        return a + b;
    }

    // 4. Exception Handling
    private static void exceptionHandling() {
        System.out.println("\n--- Exception Handling ---");

        // 4.1 try-catch
        System.out.println("Try-catch:");
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 4.2 try-catch-finally
        System.out.println("\nTry-catch-finally:");
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("This block always executes.");
        }

        // 4.3 try-with-resources
        System.out.println("\nTry-with-resources:");
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // 5. Assertions
    private static void assertions() {
        System.out.println("\n--- Assertions ---");
        int age = -5;
        assert age >= 0 : "Age cannot be negative";
        System.out.println("Age: " + age);
    }
}