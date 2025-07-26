package com.rviswanadula.sessions.basicdatastructures.hashmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BerloggingWinner {

	static class Round {
		String playerName;
		int scoreChange;

		public Round(String playerName, int scoreChange) {
			this.playerName = playerName;
			this.scoreChange = scoreChange;
		}
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		scanner.nextLine(); // Consume the newline character after reading n

		Map<String, Integer> finalScores = new HashMap<>();

		List<Round> roundsHistory = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String line = scanner.nextLine();

			String[] parts = line.split(" ");
			String playerName = parts[0];
			int scoreChange = Integer.parseInt(parts[1]);

			roundsHistory.add(new Round(playerName, scoreChange));

			finalScores.put(playerName, finalScores.getOrDefault(playerName, 0) + scoreChange);
		}

		int maxOverallScore = Integer.MIN_VALUE; // Initialize with the smallest possible integer value

		for (int score : finalScores.values()) {
			if (score > maxOverallScore) {
				maxOverallScore = score;
			}
		}

		Set<String> potentialWinners = new HashSet<>();

		for (Map.Entry<String, Integer> entry : finalScores.entrySet()) {
			if (entry.getValue() == maxOverallScore) {
				potentialWinners.add(entry.getKey());
			}
		}

		Map<String, Integer> currentRoundScores = new HashMap<>();

		String winner = ""; // Variable to store the name of the ultimate winner.

		for (Round round : roundsHistory) {

			currentRoundScores.put(round.playerName,
					currentRoundScores.getOrDefault(round.playerName, 0) + round.scoreChange);

			if (potentialWinners.contains(round.playerName)
					&& currentRoundScores.get(round.playerName) >= maxOverallScore) {
				winner = round.playerName; // This player is the winner.
				break; // Exit the loop as the winner has been found.
			}
		}

		System.out.println(winner);

		scanner.close();
	}
}
