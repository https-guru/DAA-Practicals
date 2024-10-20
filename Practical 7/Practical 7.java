/* 
Name - Guruprasad Dalwadi
Enrollment - 12202040601017
Batch - A4
Course Code - 202045601

Practical 7:
Write a program to implement making change problem using greedy algorithm.
*/

import java.util.Arrays;

public class MakingChange {

    // Function to calculate the minimum number of coins needed for a given amount
    public static void makeChange(int[] denominations, int amount) {
        // Sort denominations in descending order
        Arrays.sort(denominations);
        // Reverse the order to get descending
        for (int i = 0; i < denominations.length / 2; i++) {
            int temp = denominations[i];
            denominations[i] = denominations[denominations.length - 1 - i];
            denominations[denominations.length - 1 - i] = temp;
        }

        int coinCount = 0;
        StringBuilder result = new StringBuilder(); // To store the coins used

        // Start from the largest denomination
        for (int i = 0; i < denominations.length; i++) {
            while (amount >= denominations[i]) {
                amount -= denominations[i];
                result.append(denominations[i]).append(" "); // Store the coin used
                coinCount++; // Increment the coin count
            }
        }

        // Display the result
        if (amount == 0) {
            System.out.println("Minimum coins needed: " + coinCount);
            System.out.print("Coins used: " + result.toString());
            System.out.println();
        } else {
            System.out.println("Change cannot be made with the given denominations.");
        }
    }

    public static void main(String[] args) {
        int[] denominations = {1, 5, 10, 25}; // Coin denominations
        int amount = 63; // Amount to make change for

        System.out.println("Denominations: " + Arrays.toString(denominations));
        System.out.println("Amount to change: " + amount);
        
        makeChange(denominations, amount);
    }
}
