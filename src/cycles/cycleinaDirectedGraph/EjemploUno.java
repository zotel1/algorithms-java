package cycles.cycleinaDirectedGraph;

import java.util.ArrayList;
import java.util.List;

/*Dado el número de vértices y una lista de aristas dirigidas,
determine si el gráfico contiene un ciclo o no.

El problema se puede resolver en base a la siguiente idea:

Para encontrar el ciclo en un grafo dirigido,
podemos usar la técnica de  Depth First Traversal  (DFS).
Se basa en la idea de que hay un ciclo en un grafo  solo
si hay un borde trasero  [es decir,
un nodo apunta a uno de sus antepasados en un árbol DFS] presente en el grafo.
*/

public class EjemploUno {

    // Function to perform DFS and detect cycle in a directed graph
    private static boolean isCyclicUtil(List<Integer>[] adj, int u, boolean[] visited, boolean[] recStack) {
        // If the current node is already in the recursion stack, a cycle is detected
        if (recStack[u])
            return true;

        // If already visited and not in recStack, it's not part of a cycle
        if (visited[u])
            return false;

        // Mark the current node as visited and add it to the recursion stack
        visited[u] = true;
        visited[u] = true;

        // Recur for all adjacent vertices
        for (int v : adj[u]) {
            if (isCyclicUtil(adj, v, visited, recStack))
                return true;
        }

        // Backtrack: remove the vertex from resursion stack
        recStack[u] = false;
        return false;
    }

    //  Function to construct adjacency list from edge list
    private static List<Integer>[] constructAdj(int V, int[][] edges) {

        // Create an array of lists
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        // Add edges to the adjacency list (directed)
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
        }
        return adj;
    }

    // Main function to check if the directed graph constains a cycle
    public static boolean isCyclic(int V, int[][] edges) {
        List<Integer>[] adj = constructAdj(V, edges);
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        // Perform DFS from each unvisited vertex
        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCyclicUtil(adj, i, visited, recStack))
                return true; // Cycle found
        }

        return false; // No cycle found
    }

    public static void main(String[] args) {
        int V = 4; // Number of vertices

        // Directed edges of the graph
        int[][] edges = {
                { 0, 1 },
                { 0, 2 },
                { 1, 2 },
                { 2, 0 }, // This edge creates a cycle (0 -> 2 -> 0)
                { 2, 3 }
        };

        // Print result
        System.out.println(isCyclic(V, edges) ? "true" : "false");
    }
}
