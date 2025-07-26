package com.rviswanadula.sessions.basicdatastructures.hashmaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubarraySumK {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int k = scanner.nextInt();

		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}

		int count = 0; // This will store the total number of subarrays whose sum is k.
		int currentSum = 0; // This will keep track of the running prefix sum.

		Map<Integer, Integer> prefixSumCounts = new HashMap<>();

		prefixSumCounts.put(0, 1);

		for (int num : nums) {

			currentSum += num;

			int targetPrevSum = currentSum - k;

			if (prefixSumCounts.containsKey(targetPrevSum)) {

				count += prefixSumCounts.get(targetPrevSum);
			}

			prefixSumCounts.put(currentSum, prefixSumCounts.getOrDefault(currentSum, 0) + 1);
		}

		System.out.println(count);

		scanner.close();
	}
}
