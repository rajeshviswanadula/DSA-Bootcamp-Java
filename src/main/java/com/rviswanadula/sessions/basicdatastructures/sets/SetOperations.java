package com.rviswanadula.sessions.basicdatastructures.sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class provides methods to calculate the union and intersection of two
 * integer arrays. It uses HashSet for efficient O(N+M) average time complexity
 * for these operations, where N and M are the lengths of the input arrays.
 */
public class SetOperations {

	/**
	 * Calculates and prints the union and intersection of two integer arrays. The
	 * union contains all unique elements present in either array. The intersection
	 * contains all unique elements present in both arrays.
	 *
	 * @param arr1 The first input array.
	 * @param arr2 The second input array.
	 */
	public void findUnionAndIntersection(int[] arr1, int[] arr2) {
		// --- Calculate Union ---
		// A HashSet is used because it only stores unique elements, which is
		// exactly what the definition of a set union requires.
		TreeSet<Integer> unionSet = new TreeSet<>();

		// Add all elements from the first array to the unionSet.
		// Duplicates within arr1 are automatically handled by HashSet.
		for (int num : arr1) {
			unionSet.add(num);
		}

		// Add all elements from the second array to the unionSet.
		// Elements already present from arr1 will not be added again.
		for (int num : arr2) {
			unionSet.add(num);
		}

		// Convert the unionSet to a List for sorting.
		// Although the problem statement for union/intersection usually implies
		// unordered sets, if sorted output is desired, converting to a List
		// and sorting is necessary as HashSet does not guarantee order.
		// The sample output implies sorted output, so we sort here.
		// List<Integer> unionList = new ArrayList<>(unionSet);
		// Collections.sort(unionList); // Sort the union elements for consistent
		// output.

		// --- Calculate Intersection ---
		// A HashSet is used to efficiently store elements of the first array
		// for quick lookups (O(1) average time complexity).
		TreeSet<Integer> set1 = new TreeSet<>();
		for (int num : arr1) {
			set1.add(num);
		}

		// This HashSet will store the common elements found in both arrays.
		Set<Integer> intersectionSet = new HashSet<>();

		// Iterate through the second array. For each element, check if it exists in
		// set1.
		// If it exists, it means the element is present in both arrays, so add it to
		// intersectionSet.
		for (int num : arr2) {
			if (set1.contains(num)) {
				intersectionSet.add(num);
			}
		}

		// Convert the intersectionSet to a List for sorting.
		// List<Integer> intersectionList = new ArrayList<>(intersectionSet);
		// Collections.sort(intersectionList); // Sort the intersection elements for
		// consistent output.

		// --- Print Results ---

		// Print the union array first.
		// Iterate through the unionList to print elements with spaces.
		// Ensure no space after the last element.

		for (Integer i : unionSet) {
			System.out.print(i + " ");
		}
		System.out.println();

		// Print the intersection array next.
		// Similar printing logic for intersectionList.
		for (Integer i : intersectionSet) {
			System.out.print(i + " ");
		}
	}

	/**
	 * Main method to test the ArrayOperations class with sample inputs.
	 */
	public static void main(String[] args) {
		SetOperations solver = new SetOperations();

		// Sample Input 1
		int[] arr1_1 = { 1, 5, 9 };
		int[] arr1_2 = { 1, 4, 6, 8 };
		System.out.println("Sample Input 1:");
		System.out.println("Array 1: " + Arrays.toString(arr1_1));
		System.out.println("Array 2: " + Arrays.toString(arr1_2));
		System.out.println("Output:");
		solver.findUnionAndIntersection(arr1_1, arr1_2);
		System.out.println("Expected Union: 1 4 5 6 8 9"); // Corrected expected union for Sample 1
		System.out.println("Expected Intersection: 1"); // Corrected expected intersection for Sample 1
		System.out.println("\n-------------------------------------------------\n");

		// Another example (similar to the one in your problem description for
		// definition)
		int[] arr2_1 = { 1, 2, 2, 3, 4 };
		int[] arr2_2 = { 1, 1, 3, 5, 6, 6 };
		System.out.println("Custom Input 1:");
		System.out.println("Array 1: " + Arrays.toString(arr2_1));
		System.out.println("Array 2: " + Arrays.toString(arr2_2));
		System.out.println("Output:");
		solver.findUnionAndIntersection(arr2_1, arr2_2);
		System.out.println("Expected Union: 1 2 3 4 5 6");
		System.out.println("Expected Intersection: 1 3");
	}
}