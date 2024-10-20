/* 
Name - Guruprasad Dalwadi
Enrollment - 12202040601017
Batch - A4
Course Code - 202045601

Practical 6:
Write a program to sort given elements of an array in ascending order using quick sort. 
Analyze the time complexity for best, average and worst case. 
*/

import java.util.Arrays;

public class QuickSort {

    // Function to perform quicksort on an array
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Function to partition the array and return pivot index
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // Pivot element (using the last element as pivot)
        int i = (low - 1);  // Index of the smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap the pivot element with the element at i+1
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;  // Return the partition index
    }

    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};

        System.out.println("Original Array: " + Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
