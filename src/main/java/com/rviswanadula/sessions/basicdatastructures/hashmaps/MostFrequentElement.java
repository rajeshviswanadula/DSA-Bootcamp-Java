package com.rviswanadula.sessions.basicdatastructures.hashmaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostFrequentElement {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		Map<Integer, Integer> frequencyMap = new HashMap<>();

		for (int i = 0; i < n; i++) {
			int element = scanner.nextInt();

			frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
		}

		int maxFrequency = 0;

		int mostFrequentElement = Integer.MAX_VALUE;

		for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
			int currentElement = entry.getKey(); // The element itself
			int currentFrequency = entry.getValue(); // Its frequency

			if (currentFrequency > maxFrequency) {
				maxFrequency = currentFrequency; // Update maxFrequency
				mostFrequentElement = currentElement; // Update mostFrequentElement
			}

			else if (currentFrequency == maxFrequency) {

				if (currentElement < mostFrequentElement) {
					mostFrequentElement = currentElement;
				}
			}
		}

		System.out.println(mostFrequentElement);

		scanner.close();
	}
}
