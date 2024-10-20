/* 
Name - Guruprasad Dalwadi
Enrollment - 12202040601017
Batch - A4
Course Code - 202045601

Practical 4:
Write a program to search given element from an array using sequential search and binary search. Analyze the time complexity for best, average and worst case.   
*/

import java.util.Arrays;
import java.util.Scanner;

public class SearchAlgorithms {

    // Sequential Search (Linear Search)
    public static int sequentialSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;  // Return index if element is found
            }
        }
        return -1;  // Return -1 if element is not found
    }

    // Binary Search (iterative approach)
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is present at mid
            if (arr[mid] == target) {
                return mid;
            }

            // If target is greater, ignore the left half
            if (arr[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller, ignore the right half
            else {
                right = mid - 1;
            }
        }

        return -1;  // Return -1 if element is not found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {34, 7, 23, 32, 5, 62, 24};
        System.out.println("Original Array: " + Arrays.toString(arr));

        // Sorting array for binary search
        Arrays.sort(arr);
        System.out.println("Sorted Array for Binary Search: " + Arrays.toString(arr));

        System.out.print("Enter the element to search: ");
        int target = sc.nextInt();

        // Sequential Search
        int seqIndex = sequentialSearch(arr, target);
        if (seqIndex != -1) {
            System.out.println("Element found at index " + seqIndex + " using Sequential Search.");
        } else {
            System.out.println("Element not found using Sequential Search.");
        }

        // Binary Search
        int binIndex = binarySearch(arr, target);
        if (binIndex != -1) {
            System.out.println("Element found at index " + binIndex + " using Binary Search.");
        } else {
            System.out.println("Element not found using Binary Search.");
        }

        sc.close();
    }
}
