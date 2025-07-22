package com.rviswanadula.sessions.basicdatastructures.slidingwindowandtwopointers.slidingwindow.slidingwindowwithtreeset;

import java.util.TreeSet;
import java.util.Arrays;

/**
 * This class provides a solution to find the least greater element on the right
 * for each element in an array. If no such element exists, it replaces it with
 * -1. It leverages Java's TreeSet, which maintains elements in a sorted order
 * and offers efficient O(log N) operations for insertion and finding the next
 * higher element.
 */
public class LeastGreaterElement {

	/**
	 * Finds the least greater element on the right side for each element in the
	 * given array. The algorithm processes the array from right to left,
	 * maintaining a sorted set of elements encountered so far on the right.
	 *
	 * @param nums The input array of integers.
	 * @return An array where each element is replaced by the least greater element
	 *         on its right, or -1 if no such element exists.
	 */
	public int[] findLeastGreaterElements(int[] nums) {
		// Get the length of the input array.
		int n = nums.length;
		// Initialize the result array to store the output.
		// This array will hold the transformed elements.
		int[] result = new int[n];
		// Initialize a TreeSet to store elements encountered so far from the right.
		// TreeSet automatically keeps elements sorted and handles duplicates (stores
		// only unique elements).
		// The key method here is `higher(E e)`, which efficiently finds the smallest
		// element
		// in the set that is strictly greater than `e`.
		TreeSet<Integer> treeSet = new TreeSet<>();

		// Iterate through the array from right to left.
		// This direction is crucial because for each element `nums[i]`, we need to look
		// only at elements that are *to its right*. By processing from right to left,
		// the `treeSet` will always contain elements that are already on the right side
		// of the current `nums[i]`.
		for (int i = n - 1; i >= 0; i--) {
			// Use the `higher()` method of TreeSet to find the least element
			// in the `treeSet` that is strictly greater than `nums[i]`.
			// If no such element exists (i.e., all elements in the set are less than or
			// equal to nums[i]),
			// `higher()` returns `null`.
			Integer greaterElement = treeSet.higher(nums[i]);

			// Check if a greater element was found.
			if (greaterElement != null) {
				// If found, store this least greater element in the result array at the current
				// index.
				result[i] = greaterElement;
			} else {
				// If `higher()` returned `null`, it means there are no elements to the right
				// that are greater than `nums[i]`. As per the problem statement, replace it
				// with -1.
				result[i] = -1;
			}

			// After processing `nums[i]`, add it to the `treeSet`.
			// This makes `nums[i]` available for consideration when processing elements
			// further to its left in subsequent iterations.
			treeSet.add(nums[i]);
		}

		// Return the final array containing the transformed elements.
		return result;
	}

	/**
	 * Main method for testing the LeastGreaterElement solution. It includes the
	 * sample inputs provided in the problem description.
	 */
	public static void main(String[] args) {
		// Create an instance of the solver class.
		LeastGreaterElement solver = new LeastGreaterElement();

		// --- Sample Input 1 ---
		int[] nums1 = { 158, 58, 71, 18, 31, 32, 63, 92, 43, 3, 91, 93, 25, 80, 28 };
		int[] result1 = solver.findLeastGreaterElements(nums1);
		System.out.println("Sample Input 1:");
		System.out.println("Input: " + Arrays.toString(nums1));
		System.out.println("Output: " + Arrays.toString(result1));
		// Expected Output 1: [18, 63, 80, 25, 32, 43, 80, 93, 80, 25, 93, -1, 28, -1,
		// -1]
		System.out.println("Expected: [18, 63, 80, 25, 32, 43, 80, 93, 80, 25, 93, -1, 28, -1, -1]");

		System.out.println("\n-------------------------------------------------\n");

		// --- Sample Input 2 ---
		int[] nums2 = { 62, 6, 9, 1, 3, 2 };
		int[] result2 = solver.findLeastGreaterElements(nums2);
		System.out.println("Sample Input 2:");
		System.out.println("Input: " + Arrays.toString(nums2));
		System.out.println("Output: " + Arrays.toString(result2));
		// Expected Output 2: [3, 9, -1, 2, -1, -1]
		System.out.println("Expected: [3, 9, -1, 2, -1, -1]");
	}
}
