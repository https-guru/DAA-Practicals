/* 
Name - Guruprasad Dalwadi
Enrollment - 12202040601017
Batch - A4
Course Code - 202045601

Practical 13:
Write a program to implement longest common subsequence using dynamic programming.
*/

public class LongestCommonSubsequence {

    // Function to compute the length of the Longest Common Subsequence
    public static int lcs(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        // Create a 2D array to store lengths of longest common subsequence
        int[][] L = new int[m + 1][n + 1];

        // Build the L table in bottom-up manner
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    L[i][j] = L[i - 1][j - 1] + 1; // Characters match
                } else {
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]); // Characters do not match
                }
            }
        }

        // Print the LCS
        printLCS(X, Y, L, m, n);

        // Return the length of LCS
        return L[m][n];
    }

    // Function to print the Longest Common Subsequence
    public static void printLCS(String X, String Y, int[][] L, int m, int n) {
        StringBuilder lcs = new StringBuilder();

        // Traverse the table L to construct the LCS
        while (m > 0 && n > 0) {
            if (X.charAt(m - 1) == Y.charAt(n - 1)) {
                lcs.insert(0, X.charAt(m - 1)); // Prepend matching character
                m--;
                n--;
            } else if (L[m - 1][n] > L[m][n - 1]) {
                m--; // Move up
            } else {
                n--; // Move left
            }
        }

        System.out.println();
        System.out.print("Longest Common Subsequence: " + lcs);
    }

    public static void main(String[] args) {
        String X = "AGGTAB";  // Example string 1
        String Y = "GXTXAYB"; // Example string 2

        // Display input strings
        System.out.println("Input Strings:");
        System.out.println("String 1: " + X);
        System.out.println("String 2: " + Y);

        // Calculate the length of the Longest Common Subsequence
        int lcsLength = lcs(X, Y);
        System.out.println("\nLength of Longest Common Subsequence: " + lcsLength);
    }
}
