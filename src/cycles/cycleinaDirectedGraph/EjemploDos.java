package cycles.cycleinaDirectedGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EjemploDos {

    // Function to construct an adjacency list from edge list
    static List<Integer>[] constructadj(int V, int[][] edges) {

        List<Integer>[] adj = new ArrayList[V];

        // initialize each adjacency list
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        // Add directed edges to the adjacency list
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]); // Directed edge from edge[0] to edge[1]
        }
        return adj;
    }
    
    // Function to check if the directed graph contains a cycle using Kahn's Algorithm
    static boolean isCyclic(int V, int[][] edges) {
        List<Integer>[] adj = constructadj(V, edges); // BuildGraph
        
        int[] inDegree = new int[V]; // Array to store in-degree of each vertex
        
        Queue<Integer> q = new LinkedList<>(); // Queue for BFS
        int visited = 0; // Count of visited (processed) nodes
        
        // Compute in-degrees of all vertices
        for(int u = 0; u < V; u++) {
            for (int v : adj[u]) {
                inDegree[v]++;
            }
        }
        
        // Enqueue all nodes with in-degree 0
        for (int u = 0; u < V; u++) {
            if (inDegree[u] == 0) {
                q.offer(u);
            }
        }
        
        // Perform BFS (Topological Sort)
        while (!q.isEmpty()) {
            int u = q.poll();
            visited++;

            // Reduce in-degree of all adjacent vertices
            for (int v : adj[u]) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        // If not all vertices were visited, there's a cycle
        return visited != V;
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] edges= {
                { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 0 }, { 2, 3 }
        };

        // Putput: true (cycle detected)
        System.out.println(isCyclic(V, edges) ? "true" : "false");
    }
}
