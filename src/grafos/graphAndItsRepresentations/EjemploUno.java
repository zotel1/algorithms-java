package grafos.graphAndItsRepresentations;

public class EjemploUno {

    public static void addEdge(int[][] mat, int i, int j) {
        mat[i][j] = 1;
        mat[j][i] = 1; // Since the graph is unidirected
    }

    public static void displayMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.println(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Create a graph with 4 vertices and no edges note that all values are initialized as 0
        int V = 4;
        int[][] mat = new int[V][V];

        // Now add edges one by one
        addEdge(mat, 0, 1);
        addEdge(mat, 0, 2);
        addEdge(mat, 1, 2);
        addEdge(mat, 2, 3);

        /* Alternavely we can also create using below code if we know all edges in advance
        *
        * int[][] mat = {{ 0, 1, 0, 0 },
        *                { 1, 0, 1, 0 },
        *                { 0, 1, 0, 1 },
        *                { 0, 0, 1, 0 } }; */

        System.out.println("Adjancency Matrix Representation");
        displayMatrix(mat);
    }
}
