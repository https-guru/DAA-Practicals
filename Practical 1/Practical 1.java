/* 
Name - Guruprasad Dalwadi
Enrollment - 12202040601017
Batch - A4
Course Code - 202045601

Practical 1:
Write a program to sort given elements of an array in ascending order using bubble sort. 
Analyze the time complexity for best, average and worst case. 
*/

import java.util.Arrays;

public class BubbleSort {
    // Function to perform bubble sort on an array
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        // Traverse through all array elements
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Last i elements are already in place
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped in the inner loop, then break
            if (!swapped)
                break;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
        
        System.out.println("Original Array: " + Arrays.toString(arr));
        
        bubbleSort(arr);
        
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
