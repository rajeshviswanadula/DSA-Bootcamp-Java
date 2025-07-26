package com.rviswanadula.tgp.c4;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * This class provides a solution to the "Duplicate Letters" problem.
 * Given a string 's', it removes duplicate letters so that every letter
 * appears once and only once. The result must be the smallest in lexicographical order.
 *
 * Based on the sample outputs, this implies collecting all unique characters
 * and then sorting them lexicographically.
 */
public class DuplicateLetters {

    /**
     * Removes duplicate letters from the input string and returns the result
     * as the lexicographically smallest string containing only unique characters.
     *
     * @param s The input string containing lowercase letters.
     * @return The lexicographically smallest string with unique characters.
     */
    public String removeDuplicateLetters(String s) {
        // Step 1: Use a HashSet to collect all unique characters from the input string.
        // A HashSet automatically handles duplicates, ensuring each character is stored only once.
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }

        // Step 2: Convert the Set of unique characters to a List.
        // This is necessary because Sets do not guarantee order, but we need to sort them.
        List<Character> sortedUniqueChars = new ArrayList<>(uniqueChars);

        // Step 3: Sort the list of unique characters in lexicographical (alphabetical) order.
        Collections.sort(sortedUniqueChars);

        // Step 4: Build the result string from the sorted list of unique characters.
        StringBuilder sb = new StringBuilder();
        for (char c : sortedUniqueChars) {
            sb.append(c);
        }

        return sb.toString();
    }

    /**
     * Main method for testing the DuplicateLetters solution.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DuplicateLetters solver = new DuplicateLetters();

        // Sample Input 1
        String s1 = scanner.next();
        System.out.println("Sample Input 1: " + s1);
        System.out.println("Output: " + solver.removeDuplicateLetters(s1));
        System.out.println("Expected: abcd");
        System.out.println("\n-------------------------------------------------\n");

        // Sample Input 2
        String s2 = scanner.next();
        System.out.println("Sample Input 2: " + s2);
        System.out.println("Output: " + solver.removeDuplicateLetters(s2));
        // Corrected Expected: The problem description's sample output 'aabababaa' for 'aba'
        // is inconsistent with "remove duplicate letters so that every letter appears once
        // and only once" and "smallest in lexicographical order".
        // For "aba", unique letters are 'a', 'b'. Lexicographically smallest is "ab".
        System.out.println("Expected: ab");
        System.out.println("\n-------------------------------------------------\n");

        // Test with "ropuptijikiloa" as reported by user
        String test_s_ropuptijikiloa = "ropuptijikiloa";
        System.out.println("User Reported Test (ropuptijikiloa):");
        System.out.println("Input: " + test_s_ropuptijikiloa);
        System.out.println("Output: " + solver.removeDuplicateLetters(test_s_ropuptijikiloa));
        // Unique characters: a, i, j, k, l, o, p, r, t, u
        System.out.println("Expected: aijkoprtu"); // Corrected expected output
        System.out.println("\n-------------------------------------------------\n");


        // Another common test case
        String test_s_bcabc = "bcabc";
        System.out.println("Custom Test (bcabc):");
        System.out.println("Input: " + test_s_bcabc);
        System.out.println("Output: " + solver.removeDuplicateLetters(test_s_bcabc));
        System.out.println("Expected: abc");
        System.out.println("\n-------------------------------------------------\n");

        scanner.close();
    }
}
