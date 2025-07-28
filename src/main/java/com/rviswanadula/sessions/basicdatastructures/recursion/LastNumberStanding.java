package com.rviswanadula.sessions.basicdatastructures.recursion;

import java.util.Scanner;

public class LastNumberStanding {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		int head = 1;

		int remaining = n;

		int step = 1;

		boolean isLeftToRight = true;

		while (remaining > 1) {

			if (isLeftToRight || remaining % 2 == 1) {
				head += step;
			}

			remaining /= 2;

			step *= 2;

			isLeftToRight = !isLeftToRight;
		}

		System.out.println(head);

		scanner.close();
	}
}
