package com.rviswanadula.tgp.c4;
import java.util.Scanner;

/**
 * This class solves the "Coach Manish" problem.
 * It finds the greatest possible GCD of 'n' positive integers that sum up to 'd'.
 * The problem is reduced to finding the largest divisor 'g' of 'd' such that g <= d/n.
 */
public class CoachManish {

    /**
     * Calculates the maximum possible GCD that can be achieved from the training.
     * The total difficulty 'd' is divided into 'n' days, where each day has a
     * certain difficulty, and the sum of difficulties equals 'd'.
     *
     * @param d The total difficulty of the training.
     * @param n The number of days the training is divided into.
     * @return The greatest possible GCD of the difficulties of all days.
     */
    public int determineMaxGCD(int d, int n) {
        // Let 'g' be the GCD we are trying to maximize.
        // If 'g' is the GCD of x1, x2, ..., xn, then each xi must be a multiple of 'g'.
        // So, xi = g * yi, where yi are positive integers.
        // The sum is: g*y1 + g*y2 + ... + g*yn = d
        // Factoring out 'g': g * (y1 + y2 + ... + yn) = d
        // This implies that 'g' must be a divisor of 'd'.

        // Also, since each yi >= 1 (as difficulties must be positive),
        // the sum (y1 + y2 + ... + yn) must be at least 'n'.
        // Therefore, d/g >= n, which rearranges to g <= d/n.

        // So, we need to find the largest 'g' such that:
        // 1. 'g' divides 'd' (d % g == 0)
        // 2. 'g' is less than or equal to d/n (g <= d/n)

        // We can iterate downwards from d/n. The first divisor we find will be the largest.
        // The maximum possible value for g is d/n, because if g > d/n, then d/g < n.
        // If d/g < n, then (y1 + ... + yn) would have to be less than n, which is impossible
        // since each yi >= 1 and there are 'n' terms.
        for (int g = d / n; g >= 1; g--) {
            // Check if 'g' is a divisor of 'd'.
            if (d % g == 0) {
                // If it is, this 'g' is the largest possible GCD that satisfies both conditions.
                return g;
            }
        }

        // This line should theoretically not be reached given the constraints (1 <= n <= d).
        // The smallest possible GCD is 1, and 1 always divides 'd' and 1 <= d/n (since n <= d).
        return 1;
    }

    /**
     * Main method for testing the CoachManish solution.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read d and n
        int d = scanner.nextInt();
        int n = scanner.nextInt();

        CoachManish solver = new CoachManish();
        int result = solver.determineMaxGCD(d, n);

        System.out.println(result);

        scanner.close();
    }
}
