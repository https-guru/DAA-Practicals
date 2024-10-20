/* 
Name - Guruprasad Dalwadi
Enrollment - 12202040601017
Batch - A4
Course Code - 202045601

Practical 9:
Write a program to implement making change problem using dynamic programming. 
*/

import java.util.Arrays;

public class MakingChangeDP {

    // Function to find the minimum number of coins required to make the given amount
    public static int minCoins(int[] denominations, int amount) {
        // Create a DP array to store the minimum coins for each amount
        int[] dp = new int[amount + 1];
        
        // Initialize the DP array with a large number (representing infinity)
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        // Base case: No coins are needed to make amount 0
        dp[0] = 0;

        // Fill the DP array
        for (int i = 1; i <= amount; i++) {
            for (int coin : denominations) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If dp[amount] is still Integer.MAX_VALUE, return -1 indicating it's not possible
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] denominations = {1, 5, 10, 25}; // Coin denominations
        int amount = 63; // Amount to make change for

        // Display input for the knapsack problem
        System.out.println("Coin Denominations: " + Arrays.toString(denominations));
        System.out.println("Amount to change: " + amount);
        
        // Calculate the minimum number of coins needed
        int minCoinsRequired = minCoins(denominations, amount);
        
        if (minCoinsRequired != -1) {
            System.out.println("Minimum coins needed: " + minCoinsRequired);
        } else {
            System.out.println("Change cannot be made with the given denominations.");
        }
    }
}
