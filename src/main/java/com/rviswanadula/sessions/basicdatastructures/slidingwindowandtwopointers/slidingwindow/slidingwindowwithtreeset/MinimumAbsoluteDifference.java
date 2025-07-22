package com.rviswanadula.sessions.basicdatastructures.slidingwindowandtwopointers.slidingwindow.slidingwindowwithtreeset;

import java.util.TreeSet;

// https://leetcode.com/problems/minimum-absolute-difference-between-elements-with-constraint/description/

public class MinimumAbsoluteDifference {

	public int minimumAbsoluteDifference(int[] nums, int k) {
		int n = nums.length;
		if (n == 0) {
			return 0;
		}

		if (k == 0) {
			return 0;
		}

		int minAbsoluteDiff = Integer.MAX_VALUE;
		TreeSet<Integer> window = new TreeSet<>();

		for (int i = 0; i < n; i++) {
			// At each step 'i', we consider adding the element 'k' positions behind it
			// (i.e., nums[i - k]) to our 'window'. This element is now a candidate
			// for comparison with the current nums[i] (and future elements).
			// The condition 'i - k >= 0' ensures we don't access out-of-bounds indices.
			if (i - k >= 0) {
				window.add(nums[i - k]);
			}

			// If the window is not empty, we can start finding potential minimum
			// differences.
			// The elements currently in 'window' are nums[j] such that j <= i - k.
			// This means for any such j, |i - j| = i - j >= k, satisfying the condition.
			if (!window.isEmpty()) {
				// Find the greatest element in 'window' that is less than or equal to nums[i].
				// This helps find a candidate 'floorVal' such that |nums[i] - floorVal| is
				// minimized.
				Integer floorVal = window.floor(nums[i]);
				if (floorVal != null) {
					minAbsoluteDiff = Math.min(minAbsoluteDiff, Math.abs(nums[i] - floorVal));
				}

				// Find the least element in 'window' that is greater than or equal to nums[i].
				// This helps find a candidate 'ceilVal' such that |nums[i] - ceilVal| is
				// minimized.
				Integer ceilVal = window.ceiling(nums[i]);
				if (ceilVal != null) {
					minAbsoluteDiff = Math.min(minAbsoluteDiff, Math.abs(nums[i] - ceilVal));
				}
			}
		}

		return minAbsoluteDiff;
	}

	public static void main(String[] args) {
		MinimumAbsoluteDifference solver = new MinimumAbsoluteDifference();
		System.out.println(solver.minimumAbsoluteDifference(new int[] { 5, 3, 2, 10, 15 }, 1));
		System.out.println(solver.minimumAbsoluteDifference(new int[] { 1, 0, 1, 1 }, 1));
		System.out.println(solver.minimumAbsoluteDifference(new int[] { 1, 2, 3, 4, 5 }, 2));
	}
}