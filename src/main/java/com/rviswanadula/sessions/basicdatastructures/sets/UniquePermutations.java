package com.rviswanadula.sessions.basicdatastructures.sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet; // Used for automatic sorting and uniqueness

public class UniquePermutations {

	// Set to store unique permutations, automatically sorted lexicographically
	private Set<String> uniquePermutations;

	public UniquePermutations() {
		this.uniquePermutations = new TreeSet<>(); // TreeSet ensures uniqueness and lexicographical order
	}

	/**
	 * Finds all unique permutations of a given string.
	 *
	 * @param s The input string.
	 * @return A List of unique permutations, sorted lexicographically.
	 */
	public List<String> findUniquePermutations(String s) {
		if (s == null || s.isEmpty()) {
			return new ArrayList<>();
		}

		// Convert string to char array for easier manipulation and sorting
		char[] chars = s.toCharArray();
		// Step 1: Sort the character array. This is crucial for the duplicate-skipping
		// logic.
		Arrays.sort(chars);

		// visited array to keep track of characters used in the current permutation
		boolean[] visited = new boolean[chars.length];
		// StringBuilder to build the current permutation efficiently
		StringBuilder currentPermutation = new StringBuilder();

		// Start the backtracking process
		backtrack(chars, visited, currentPermutation);

		// Convert the TreeSet to an ArrayList for the return type
		return new ArrayList<>(uniquePermutations);
	}

	/**
	 * Recursive backtracking function to generate permutations.
	 *
	 * @param chars              The sorted character array from the input string.
	 * @param visited            A boolean array indicating if a character at an
	 *                           index has been used.
	 * @param currentPermutation The StringBuilder holding the permutation being
	 *                           built.
	 */
	private void backtrack(char[] chars, boolean[] visited, StringBuilder currentPermutation) {
		// Base case: If the current permutation has the same length as the original
		// string,
		// a complete permutation is formed. Add it to the set.
		if (currentPermutation.length() == chars.length) {
			uniquePermutations.add(currentPermutation.toString());
			return; // Backtrack
		}

		// Iterate through all characters in the sorted array
		for (int i = 0; i < chars.length; i++) {
			// Duplicate-Skipping Condition:
			// 1. If the character at index 'i' has already been visited in the current
			// path, skip it.
			// 2. If 'i' is not the first element AND the current character is the same as
			// the previous one
			// AND the previous identical character was NOT visited (meaning we are on a
			// path
			// where we didn't pick the previous identical character), then skip the current
			// character.
			// This prevents redundant permutations like "a1b" and "a2b" when 'a1' and 'a2'
			// are identical.
			if (visited[i] || (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1])) {
				continue; // Skip this character
			}

			// Choose: Mark the character as visited and append it to the current
			// permutation.
			visited[i] = true;
			currentPermutation.append(chars[i]);

			// Explore: Recursively call backtrack to build the rest of the permutation.
			backtrack(chars, visited, currentPermutation);

			// Backtrack (Undo): Unmark the character as visited and remove it from the
			// current permutation.
			// This allows other branches of the recursion tree to use this character.
			currentPermutation.deleteCharAt(currentPermutation.length() - 1);
			visited[i] = false;
		}
	}

	/**
	 * Main method for testing the UniquePermutations solution.
	 */
	public static void main(String[] args) {
		UniquePermutations solver = new UniquePermutations();

		// Sample Input 1
		String s1 = "abe";
		System.out.println("Sample Input 1: " + s1);
		List<String> permutations1 = solver.findUniquePermutations(s1);
		System.out.println("Output:");
		for (String p : permutations1) {
			System.out.println(p);
		}
		// Expected Output 1:
		// abe
		// aeb
		// bae
		// bea
		// eab
		// eba
		System.out.println("Expected (lexicographical order):\nabe\naeb\nbae\nbea\neab\neba");

		System.out.println("\n-------------------------------------------------\n");

		// Sample Input 2
		String s2 = "aba";
		System.out.println("Sample Input 2: " + s2);
		List<String> permutations2 = solver.findUniquePermutations(s2);
		System.out.println("Output:");
		for (String p : permutations2) {
			System.out.println(p);
		}
		// Expected Output 2:
		// aab
		// aba
		// baa
		System.out.println("Expected (lexicographical order):\naab\naba\nbaa");
	}
}