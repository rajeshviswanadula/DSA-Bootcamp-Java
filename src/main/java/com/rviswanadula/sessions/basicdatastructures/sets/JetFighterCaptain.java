package com.rviswanadula.sessions.basicdatastructures.sets;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JetFighterCaptain {

	private static int findOverallMissingNonNegative(int[] arr) {

		Set<Integer> presentNumbers = new HashSet<>();
		for (int num : arr) {
			if (num >= 0) { // Only non-negative numbers are relevant for this check
				presentNumbers.add(num);
			}
		}

		int missing = 0;
		while (presentNumbers.contains(missing)) {
			missing++;
		}
		return missing;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int k = scanner.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		int targetMissingValue = findOverallMissingNonNegative(arr);

		int segmentCount = 0; // Tracks the total number of valid segments found.
		int currentSegmentStart = 0; // Marks the starting index of the current potential segment.

		while (currentSegmentStart < n) {

			boolean segmentFoundInIteration = false;

			Set<Integer> currentSegmentNumbers = new HashSet<>();

			for (int i = currentSegmentStart; i < n; i++) {

				if (arr[i] >= 0) { // Only non-negative numbers contribute to the missing value logic
					currentSegmentNumbers.add(arr[i]);
				}

				int missingInCurrentSegment = 0;
				while (currentSegmentNumbers.contains(missingInCurrentSegment)) {
					missingInCurrentSegment++;
				}

				if (missingInCurrentSegment == targetMissingValue) {
					segmentCount++; // Increment the count of valid segments found.

					currentSegmentStart = i + 1;
					segmentFoundInIteration = true; // Mark that a segment was found.
					break; // Break the inner loop as we've found the shortest valid segment; move to find
							// the next.
				}
			}

			if (!segmentFoundInIteration) {
				break;
			}
		}

		if (segmentCount >= k) {
			System.out.println("Attack");
		} else {
			System.out.println("Wait");
		}

		scanner.close();
	}
}
