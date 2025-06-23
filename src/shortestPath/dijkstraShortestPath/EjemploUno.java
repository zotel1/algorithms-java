package shortestPath.dijkstraShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*Dado un grafo no dirigido ponderado representado como una lista de bordes
y un vértice de origen src, encuentre las distancias de ruta más cortas desde el vértice
de origen hasta todos los demás vértices del grafo.
El grafo contiene V vértices, numerados de a .0V - 1

En el algoritmo de Dijkstra, el objetivo es encontrar la distancia más corta
desde un nodo de origen dado a todos los demás nodos del grafo.
Como el nodo de origen es el punto de partida, su distancia se inicializa en cero.
A partir de ahí, elegimos iterativamente el nodo sin procesar con la distancia mínima
desde la fuente, aquí es donde normalmente se usa un montón mínimo
(cola de prioridad) o un conjunto para mayor eficiencia.
Para cada nodo seleccionado u,
actualizamos la distancia a sus vecinos v usando la fórmula:
dist[v] = dist[u] + weight[u][v],
pero solo si este nuevo camino ofrece una distancia más corta que la conocida actualmente.
Este proceso continúa hasta que se hayan procesado todos los nodos.*/
public class EjemploUno {
    // Construct adjacency list using ArrayList of ArrayList
    static ArrayList<ArrayList<ArrayList<Integer>>>
    constructAdj(int[][] edges, int V) {
        // Initialize the adjacency list
        ArrayList<ArrayList<ArrayList<Integer>>>
                adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Fill the adjacency list from edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            // Add edge from u to v
            ArrayList<Integer> e1 = new ArrayList<>();
            e1.add(v);
            e1.add(wt);
            adj.get(u).add(e1);

            // Since the graph is undirected, add edge from v to u
            ArrayList<Integer> e2 = new ArrayList<>();
            e2.add(u);
            e2.add(wt);
            adj.get(v).add(e2);
        }

        return adj;
    }

    //Driver Code Ends
    // Returns shortest distances from src to all other vertices
    static int[] dijkstra(int V, int[][] edges, int src) {

        // Create adjacency list
        ArrayList<ArrayList<ArrayList<Integer>>> adj =
                constructAdj(edges, V);

        // PriorityQueue to store vertices to be processed
        // Each element is a pair: [distance, node]
        PriorityQueue<ArrayList<Integer>> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a.get(0)));

        // Create a distance array and initialize all distances as infinite
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Insert source with distance 0
        dist[src] = 0;
        ArrayList<Integer> start = new ArrayList<>();

        start.add(0);
        start.add(src);
        pq.offer(start);

        // Loop until the priority queue is empty
        while (!pq.isEmpty()) {

            // Get the node with the minimum distance
            ArrayList<Integer> curr = pq.poll();
            int d = curr.get(0);
            int u = curr.get(1);

            // Traverse all adjacent vertices of the current node
            for (ArrayList<Integer> neighbor : adj.get(u)) {
                int v = neighbor.get(0);
                int weight = neighbor.get(1);

                // If there is a shorter path to v through u
                if (dist[v] > dist[u] + weight) {
                    // Update distance of v
                    dist[v] = dist[u] + weight;

                    // Add updated pair to the queue
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(dist[v]);
                    temp.add(v);
                    pq.offer(temp);
                }
            }
        }

        // Return the shortest distance array
        return dist;
    }
//Driver Code Starts

    // Driver program to test methods of graph class
    public static void main(String[] args) {
        int V = 5;
        int src = 0;

        // Edge list format: {u, v, weight}
        int[][] edges = {
                {0, 1, 4}, {0, 2, 8}, {1, 4, 6},
                {2, 3, 2}, {3, 4, 10}
        };

        // Get shortest path distances
        int[] result = dijkstra(V, edges, src);

        // Print shortest distances in one line
        for (int d : result)
            System.out.print(d + " ");
    }
}
