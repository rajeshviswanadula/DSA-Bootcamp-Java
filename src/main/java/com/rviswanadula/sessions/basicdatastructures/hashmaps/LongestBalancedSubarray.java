package com.rviswanadula.sessions.basicdatastructures.hashmaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestBalancedSubarray {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}

		int maxLength = 0;

		int currentSum = 0;

		Map<Integer, Integer> sumToIndex = new HashMap<>();

		sumToIndex.put(0, -1);

		for (int i = 0; i < n; i++) {

			if (nums[i] == 0) {
				currentSum -= 1;
			} else { // nums[i] == 1
				currentSum += 1;
			}

			if (sumToIndex.containsKey(currentSum)) {

				int previousIndex = sumToIndex.get(currentSum);
				int currentSubarrayLength = i - previousIndex;

				maxLength = Math.max(maxLength, currentSubarrayLength);
			} else {

				sumToIndex.put(currentSum, i);
			}
		}

		System.out.println(maxLength);

		scanner.close();
	}
}
