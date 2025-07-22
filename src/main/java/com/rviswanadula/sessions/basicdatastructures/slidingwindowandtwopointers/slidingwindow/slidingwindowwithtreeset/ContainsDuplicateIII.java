package com.rviswanadula.sessions.basicdatastructures.slidingwindowandtwopointers.slidingwindow.slidingwindowwithtreeset;

import java.util.TreeSet;

// https://leetcode.com/problems/contains-duplicate-iii/submissions/1706694324/

public class ContainsDuplicateIII {

	public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
		if (indexDiff < 0 || valueDiff < 0) {
			return false;
		}

		TreeSet<Long> window = new TreeSet<>();

		for (int i = 0; i < nums.length; i++) {
			// Check for the condition:
			// Find the smallest element in 'window' that is >= nums[i] - valueDiff
			Long ceilVal = window.ceiling((long) nums[i] - valueDiff); // Check elements >= nums[i] - valueDiff

			// If we found a 'ceilVal' and it's within the range [nums[i] - valueDiff,
			// nums[i] + valueDiff]
			if (ceilVal != null && ceilVal <= (long) nums[i] + valueDiff) {
				return true;
			}

			// Add the current number to the window
			window.add((long) nums[i]);

			// Remove the element that falls outside the window
			// The window size is indexDiff+1 (indices i-indexDiff to i)
			if (i >= indexDiff) {
				window.remove((long) nums[i - indexDiff]);
			}
		}

		return false;
	}

	public static void main(String[] args) {
		ContainsDuplicateIII solver = new ContainsDuplicateIII();
		System.out.println(solver.containsNearbyAlmostDuplicate(new int[] { 1, 5, 3, 7, 2 }, 4, 0)); // true
		System.out.println(solver.containsNearbyAlmostDuplicate(new int[] { 1, 0, 1, 1 }, 1, 2)); // true
		System.out.println(solver.containsNearbyAlmostDuplicate(new int[] { 1, 5, 9, 1, 5, 9 }, 2, 3)); // false
		System.out.println(solver.containsNearbyAlmostDuplicate(new int[] { 2147483647, -2147483647 }, 1, 2147483647)); // true
																														// (overflow
																														// consideration)
	}
}