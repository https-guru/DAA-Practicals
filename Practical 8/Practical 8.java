/* 
Name - Guruprasad Dalwadi
Enrollment - 12202040601017
Batch - A4
Course Code - 202045601

Practical 8:
Write a program to implement the knapsack problem using greedy algorithm.
*/

import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value;
    int weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalKnapsack {

    // Method to calculate the maximum value of items that can be put in the knapsack
    public static double getMaxValue(Item[] items, int capacity) {
        // Sort items by their value-to-weight ratio in descending order
        Arrays.sort(items, new Comparator<Item>() {
            public int compare(Item a, Item b) {
                double ratio1 = (double) a.value / a.weight;
                double ratio2 = (double) b.value / b.weight;
                return Double.compare(ratio2, ratio1);
            }
        });

        double totalValue = 0.0;

        // Iterate through the sorted items
        for (Item item : items) {
            if (capacity <= 0) {
                break; // No more capacity in the knapsack
            }

            // If the item can fit completely in the knapsack
            if (item.weight <= capacity) {
                totalValue += item.value; // Take the whole item
                capacity -= item.weight;   // Decrease the remaining capacity
            } else {
                // Take the fraction of the remaining item
                totalValue += item.value * ((double) capacity / item.weight);
                capacity = 0; // The knapsack is now full
            }
        }

        return totalValue; // Return the maximum value
    }

    public static void main(String[] args) {
        Item[] items = {
            new Item(60, 10),   // value = 60, weight = 10
            new Item(100, 20),  // value = 100, weight = 20
            new Item(120, 30)   // value = 120, weight = 30
        };

        int capacity = 50; // Capacity of the knapsack

        // Display knapsack input
        System.out.println("Knapsack Input:");
        System.out.println("Capacity: " + capacity);
        System.out.println("Items (Value, Weight): ");
        for (Item item : items) {
            System.out.println("Value: " + item.value + ", Weight: " + item.weight);
        }
        
        // Calculate maximum value
        double maxValue = getMaxValue(items, capacity);
        System.out.println("\nMaximum value in the knapsack = " + maxValue);
    }
}
