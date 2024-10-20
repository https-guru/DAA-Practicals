/* 
Name - Guruprasad Dalwadi
Enrollment - 12202040601017
Batch - A4
Course Code - 202045601

Practical 2:
Write a program to sort given elements of an array in ascending order using selection sort. 
Analyze the time complexity for best, average and worst case. 

*/


import java.util.Arrays;

public class SelectionSort {
    // Function to perform selection sort on an array
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // Traverse through all array elements
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted part
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            // Swap the found minimum element with the first element of the unsorted part
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 11 };

        System.out.println("Original Array: " + Arrays.toString(arr));

        selectionSort(arr);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
