/* 
Name - Guruprasad Dalwadi
Enrollment - 12202040601017
Batch - A4
Course Code - 202045601

Practical 10:
Write a program to implement the knapsack problem using dynamic programming. 
*/

public class KnapsackDP {

    // Function to calculate the maximum value that can be obtained with the given capacity
    public static int knapsack(int capacity, int[] weights, int[] values, int n) {
        // Create a 2D array to store the maximum value at each n and capacity
        int[][] dp = new int[n + 1][capacity + 1];

        // Build the dp array in a bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                // Base case: If there are no items or capacity is 0
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    // If the weight of the current item is less than or equal to the capacity
                    // Choose the maximum between including the item and not including it
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    // If the current item's weight exceeds the capacity, do not include it
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // The maximum value will be in the bottom-right corner of the array
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5}; // Weights of the items
        int[] values = {3, 4, 5, 6};  // Values of the items
        int capacity = 5;              // Capacity of the knapsack
        int n = values.length;         // Number of items

        // Display input
        System.out.println("Knapsack Input:");
        System.out.println("Weights: " + java.util.Arrays.toString(weights));
        System.out.println("Values: " + java.util.Arrays.toString(values));
        System.out.println("Capacity: " + capacity);

        // Calculate the maximum value
        int maxValue = knapsack(capacity, weights, values, n);
        System.out.println("\nMaximum value in the knapsack = " + maxValue);
    }
}
