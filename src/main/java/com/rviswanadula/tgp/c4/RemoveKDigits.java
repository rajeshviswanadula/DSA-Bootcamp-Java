package com.rviswanadula.tgp.c4;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * This class provides a solution to the "Remove K Digits" problem.
 * Given a non-negative integer as a string and an integer k, it removes k digits
 * from the number such that the new number is the smallest possible,
 * maintaining the original order of the remaining digits.
 * The solution uses a Monotonic Stack (implemented with a Deque).
 */
public class RemoveKDigits {

    /**
     * Removes k digits from the given number string to make the new number the smallest possible.
     *
     * @param num The input non-negative integer as a string.
     * @param k The number of digits to remove.
     * @return The smallest possible number as a string after removing k digits.
     */
    public String removeKdigits(String num, int k) {
        // Use a Deque as a stack. We want to build a monotonically increasing sequence
        // (from bottom to top of the stack) to ensure the smallest number.
        Deque<Character> stack = new ArrayDeque<>();

        // Iterate through each digit of the input number string.
        for (char digit : num.toCharArray()) {
            // While the stack is not empty, we still have removals (k > 0),
            // and the digit at the top of the stack is greater than the current digit:
            // This means we have found a "peak" (a larger digit followed by a smaller one).
            // To make the number smaller, we should remove the larger digit.
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > digit) {
                stack.removeLast(); // Remove the larger digit from the stack
                k--; // Decrement the count of digits to remove
            }
            stack.addLast(digit); // Add the current digit to the stack
        }

        // If after processing all digits, we still have k > 0,
        // it means the remaining digits in the stack are in non-decreasing order (e.g., "12345").
        // To make the number smallest, we simply remove the last k digits.
        while (k > 0 && !stack.isEmpty()) {
            stack.removeLast();
            k--;
        }

        // Build the result string from the stack.
        // The digits are in the correct relative order from bottom to top of the stack.
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeFirst()); // Append from the front of the deque
        }

        // Handle leading zeros:
        // Remove any leading zeros from the result, unless the result is "0" itself.
        int firstNonZeroIdx = 0;
        while (firstNonZeroIdx < sb.length() - 1 && sb.charAt(firstNonZeroIdx) == '0') {
            firstNonZeroIdx++;
        }
        String result = sb.substring(firstNonZeroIdx).toString();

        // Handle the case where all digits were removed or the result is empty.
        // In this case, the smallest possible number is "0".
        if (result.isEmpty()) {
            return "0";
        }

        return result;
    }

    /**
     * Main method for testing the RemoveKDigits solution.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RemoveKDigits solver = new RemoveKDigits();

        // Sample Input 1
        String num1 = scanner.next();
        int k1 = scanner.nextInt();
        System.out.println("Sample Input 1:");
        System.out.println("Input num: " + num1 + ", k: " + k1);
        System.out.println("Output: " + solver.removeKdigits(num1, k1));
        System.out.println("Expected: 1219");
        System.out.println("\n-------------------------------------------------\n");

        // Sample Input 2
        String num2 = scanner.next();
        int k2 = scanner.nextInt();
        System.out.println("Sample Input 2:");
        System.out.println("Input num: " + num2 + ", k: " + k2);
        System.out.println("Output: " + solver.removeKdigits(num2, k2));
        System.out.println("Expected: 200");
        System.out.println("\n-------------------------------------------------\n");

        // Additional Test Case: All digits removed
        String num3 = "10";
        int k3 = 2;
        System.out.println("Additional Test Case 1:");
        System.out.println("Input num: " + num3 + ", k: " + k3);
        System.out.println("Output: " + solver.removeKdigits(num3, k3));
        System.out.println("Expected: 0");
        System.out.println("\n-------------------------------------------------\n");

        // Additional Test Case: No removals needed, already smallest
        String num4 = "12345";
        int k4 = 2;
        System.out.println("Additional Test Case 2:");
        System.out.println("Input num: " + num4 + ", k: " + k4);
        System.out.println("Output: " + solver.removeKdigits(num4, k4));
        System.out.println("Expected: 123");
        System.out.println("\n-------------------------------------------------\n");

        // Additional Test Case: Large k, resulting in 0
        String num5 = "98765";
        int k5 = 5;
        System.out.println("Additional Test Case 3:");
        System.out.println("Input num: " + num5 + ", k: " + k5);
        System.out.println("Output: " + solver.removeKdigits(num5, k5));
        System.out.println("Expected: 0");
        System.out.println("\n-------------------------------------------------\n");


        scanner.close();
    }
}
