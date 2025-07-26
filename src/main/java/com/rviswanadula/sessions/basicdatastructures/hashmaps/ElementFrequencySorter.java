package com.rviswanadula.sessions.basicdatastructures.hashmaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ElementFrequencySorter {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		Map<Integer, Integer> frequencyMap = new HashMap<>();

		for (int i = 0; i < n; i++) {
			int element = scanner.nextInt();

			frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
		}

		List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());

		Collections.sort(sortedEntries, (entry1, entry2) -> entry1.getKey().compareTo(entry2.getKey()));

		for (Map.Entry<Integer, Integer> entry : sortedEntries) {
			System.out.print("[" + entry.getKey() + "," + entry.getValue() + "] ");
		}
		System.out.println(); // Print a newline at the end for clean output.

		scanner.close();
	}
}
