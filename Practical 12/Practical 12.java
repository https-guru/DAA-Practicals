/* 
Name - Guruprasad Dalwadi
Enrollment - 12202040601017
Batch - A4
Course Code - 202045601

Practical 12:
Write a program to implement chained matrix multiplication using dynamic programming. 
*/

public class MatrixChainMultiplication {

    // Function to compute the minimum cost of matrix multiplication and to keep track of split points
    public static int matrixChainOrder(int[] p, int n) {
        // Create a table to store results of subproblems
        int[][] m = new int[n][n];
        int[][] s = new int[n][n]; // To store the split points

        // l is chain length
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;

                // Try all possible positions to split the chain
                for (int k = i; k < j; k++) {
                    // q = cost of multiplying the two sub-chains
                    int q = m[i][k] + m[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k; // Store the split point
                    }
                }
            }
        }

        // Print the optimal order of matrix multiplication
        System.out.print("Optimal Parenthesization: ");
        printOptimalParenthesization(s, 0, n - 1);
        System.out.println();

        // Return the minimum cost to multiply the entire chain
        return m[0][n - 1];
    }

    // Function to print the optimal parenthesization
    public static void printOptimalParenthesization(int[][] s, int i, int j) {
        if (i == j) {
            System.out.print("A" + (i + 1)); // Print the matrix label (A1, A2, ...)
        } else {
            System.out.print("(");
            printOptimalParenthesization(s, i, s[i][j]);
            printOptimalParenthesization(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }

    public static void main(String[] args) {
        // Example dimensions of matrices (chain)
        int[] p = {30, 35, 15, 5, 10, 20, 25}; // Dimensions
        int n = p.length - 1; // Number of matrices

        // Display input
        System.out.println("Matrix Dimensions:");
        for (int i = 0; i < p.length - 1; i++) {
            System.out.print("Matrix " + (i + 1) + ": " + p[i] + " x " + p[i + 1] + "\n");
        }

        // Calculate the minimum cost of matrix multiplication and print the order
        int minCost = matrixChainOrder(p, n);
        System.out.println("\nMinimum number of multiplications: " + minCost);
    }
}
