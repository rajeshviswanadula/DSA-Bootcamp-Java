package com.rviswanadula.sessions.basicdatastructures.slidingwindowandtwopointers.slidingwindow.slidingwindowwithtreeset;

import java.util.*;

public class BalancedSubarrayCounter {
	public static int countBalancedSubarrays(int[] arr, int target) {
		int n = arr.length;
		int prefixSum = 0;
		int balance = 0; // balance = evenCount - oddCount
		int count = 0;

		Map<Integer, List<int[]>> balanceMap = new HashMap<>();
		balanceMap.put(0, new ArrayList<>());
		balanceMap.get(0).add(new int[] { -1, 0 }); // Initial state

		for (int i = 0; i < n; i++) {

			prefixSum += arr[i];

			if (arr[i] % 2 == 0) {
				balance++;
			} else {
				balance--;
			}

			if (balanceMap.containsKey(balance)) {
				for (int[] entry : balanceMap.get(balance)) {
					int prevIndex = entry[0];
					int prevSum = entry[1];

					int subarraySum = prefixSum - prevSum;
					if (subarraySum <= target) {
						count++;
					}
				}
			}

			balanceMap.putIfAbsent(balance, new ArrayList<>());
			balanceMap.get(balance).add(new int[] { i, prefixSum });
		}

		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int target = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int result = countBalancedSubarrays(arr, target);
		System.out.println(result);
	}
}
