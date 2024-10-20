/* 
Name - Guruprasad Dalwadi
Enrollment - 12202040601017
Batch - A4
Course Code - 202045601

Practical 11:
Write a program to implement Floyd’s algorithm for finding shortest path using dynamic programming. 
*/

public class FloydWarshall {

    // Function to implement Floyd-Warshall algorithm
    public static void floydWarshall(int[][] graph) {
        int V = graph.length; // Number of vertices

        // Create a distance array to store the shortest paths
        int[][] dist = new int[V][V];

        // Initialize the distance array
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) {
                    dist[i][j] = 0; // Distance to itself is 0
                } else if (graph[i][j] != 0) {
                    dist[i][j] = graph[i][j]; // Distance from i to j
                } else {
                    dist[i][j] = Integer.MAX_VALUE; // No path
                }
            }
        }

        // Update the distance array with shortest paths
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // Print the shortest path matrix
        printSolution(dist);
    }

    // Function to print the solution matrix
    public static void printSolution(int[][] dist) {
        int V = dist.length;
        System.out.println("Shortest path matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Example graph represented as an adjacency matrix
        int[][] graph = {
            {0, 3, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0},
            {0, 0, 0, 7, 0, 2},
            {0, 0, 0, 0, 2, 3},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}
        };

        // Display the input graph
        System.out.println("Input graph (adjacency matrix):");
        for (int[] row : graph) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        // Run the Floyd-Warshall algorithm
        floydWarshall(graph);
    }
}
