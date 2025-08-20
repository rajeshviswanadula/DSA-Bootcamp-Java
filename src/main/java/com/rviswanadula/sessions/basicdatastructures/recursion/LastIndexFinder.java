package com.rviswanadula.sessions.basicdatastructures.recursion;
/**
 * A Java program to find the last index of a target element in an array using recursion.
 * This solution follows a divide and conquer approach.
 */
import java.util.Scanner;

public class LastIndexFinder {

    /**
     * Finds the last index of a target element in an array recursively.
     * The method traverses the array from the beginning.
     * * @param arr The input array of integers.
     * @param x The target integer to find.
     * @param index The current index being checked in the recursion.
     * @return The last index of x, or -1 if not found.
     */
    public static int findLastIndex(int[] arr, int x, int index) {
        // Base case: If the index is out of bounds, the element was not found in this segment.
        if (index >= arr.length) {
            return -1;
        }

        // Recursive step: Find the last index in the rest of the array (from index + 1).
        int lastIndexInRest = findLastIndex(arr, x, index + 1);

        // Combine step: Check the result of the recursive call.
        if (lastIndexInRest != -1) {
            // If an index was found in the rest of the array, that's the last one.
            // We can return it immediately.
            return lastIndexInRest;
        } else {
            // If nothing was found in the rest of the array, check the current element.
            if (arr[index] == x) {
                // If the current element matches, this is the last occurrence.
                return index;
            } else {
                // If the current element does not match, return -1.
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read array size.
        int N = scanner.nextInt();
        int[] arr = new int[N];

        // Read array elements.
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        // Read target element x.
        int x = scanner.nextInt();

        // Call the recursive function starting from index 0.
        int result = findLastIndex(arr, x, 0);

        // Print the result.
        System.out.println(result);
        
        scanner.close();
    }
}
