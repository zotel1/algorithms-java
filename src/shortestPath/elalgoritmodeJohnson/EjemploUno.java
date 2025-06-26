package shortestPath.elalgoritmodeJohnson;

import java.util.Arrays;

/*El problema es encontrar los caminos más cortos entre cada par de vértices en un grafo dirigido ponderado dado y los pesos pueden ser negativos. Hemos discutido el algoritmo de Floyd Warshall para este problema. La complejidad temporal del algoritmo de Floyd Warshall es Θ(V3).

Usando el algoritmo de Johnson, podemos encontrar todos los pares de caminos más cortos en O(V2log V + VE). El algoritmo de Johnson utiliza tanto Dijkstra como Bellman-Ford como subrutinas. Si aplicamos el algoritmo de ruta más corta de fuente única de Dijkstra para cada vértice, considerando cada vértice como la fuente, podemos encontrar todos los pares de rutas más cortas en tiempo O(V*(V + E)* Log V).

Por lo tanto, usar el camino más corto de una sola fuente de Dijkstra parece ser una mejor opción que el algoritmo de Floyd Warshall, pero el problema con el algoritmo de Dijkstra es que no funciona para el borde de peso negativo. La idea del algoritmo de Johnson es volver a ponderar todos los bordes y hacerlos todos positivos, y luego aplicar el algoritmo de Dijkstra para cada vértice.

¿Cómo transformar un grafo dado en un grafo con todos los bordes de peso no negativo?

Uno puede pensar en un enfoque simple de encontrar el borde de peso mínimo y agregar este peso a todos los bordes. Desafortunadamente, esto no funciona, ya que puede haber un número diferente de bordes en diferentes rutas (consulte esto para ver un ejemplo). Si hay varias rutas de acceso desde un vértice U hasta v, todas las rutas deben aumentarse en la misma cantidad, de modo que la ruta más corta siga siendo la más corta en el grafo transformado. La idea del algoritmo de Johnson es asignar un peso a cada vértice. Sea el peso asignado al vértice u h[u].

Reponderamos los bordes utilizando pesos de vértices. Por ejemplo, para un borde (u, v) de peso w(u, v), el nuevo peso se convierte en w(u, v) + h[u] - h[v]. Lo bueno de esta reponderación es que todo el conjunto de caminos entre dos vértices cualesquiera se incrementa en la misma cantidad y todos los pesos negativos se convierten en no negativos. Considere cualquier ruta entre dos vértices s y t, el peso de cada ruta se incrementa en h[s] - h[t], y todos los valores de h[] de los vértices en la ruta de s a t se cancelan entre sí.

¿Cómo calculamos los valores de h[]?

Para ello se utiliza el algoritmo de Bellman-Ford. A continuación se muestra el algoritmo completo. Se agrega un nuevo vértice al grafo y se conecta a todos los vértices existentes. Los valores de distancia más cortos desde el nuevo vértice hasta todos los vértices existentes son valores h[].*/

public class EjemploUno {

    // Define infinity as a large integer value
    private static final int INF = Integer.MAX_VALUE;

    // Function to find the vertex with the minimum distance
    // from the source that has not yet been included in the shortest path tree
    private static int minDistance(int[] dist, boolean[] sptSet) {
        int min = INF, minIndex = 0;
        for (int v = 0; v < dist.length; v++) {
            // Update minIndex if a smaller distance is found
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Function to perform Dijkstra's algorithm on the modified graph
    private static void dijkstraAlgorithm(int[][] graph, int[][] alteredGraph, int source) {
        int V = graph.length;  // Number of vertices
        int[] dist = new int[V];  // Distance array to store shortest distance from source
        boolean[] sptSet = new boolean[V];  // Boolean array to track visited vertices

        // Initialize distances with infinity and source distance as 0
        Arrays.fill(dist, INF);
        dist[source] = 0;

        // Compute shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the vertex with the minimum distance that hasn't been visited
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;  // Mark this vertex as visited

            // Update distance values for adjacent vertices
            for (int v = 0; v < V; v++) {
                // Check for updates to the distance value
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != INF && dist[u] + alteredGraph[u][v] < dist[v]) {
                    dist[v] = dist[u] + alteredGraph[u][v];
                }
            }
        }

        // Print the shortest distances from the source vertex
        System.out.println("Shortest Distance from vertex " + source + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + ": " + (dist[i] == INF ? "INF" : dist[i]));
        }
    }

    // Function to perform Bellman-Ford algorithm to calculate shortest distances
    // from a source vertex to all other vertices
    private static int[] bellmanFordAlgorithm(int[][] edges, int V) {
        int[] dist = new int[V + 1];  // Distance array with an extra vertex
        Arrays.fill(dist, INF);
        dist[V] = 0;  // Distance to the new source vertex (added vertex) is 0

        // Add edges from the new source vertex to all original vertices
        int[][] edgesWithExtra = Arrays.copyOf(edges, edges.length + V);
        for (int i = 0; i < V; i++) {
            edgesWithExtra[edges.length + i] = new int[]{V, i, 0};
        }

        // Relax all edges |V| - 1 times
        for (int i = 0; i < V; i++) {
            for (int[] edge : edgesWithExtra) {
                if (dist[edge[0]] != INF && dist[edge[0]] + edge[2] < dist[edge[1]]) {
                    dist[edge[1]] = dist[edge[0]] + edge[2];
                }
            }
        }

        return Arrays.copyOf(dist, V);  // Return distances excluding the new source vertex
    }

    // Function to implement Johnson's Algorithm
    private static void johnsonAlgorithm(int[][] graph) {
        int V = graph.length;  // Number of vertices
        int[][] edges = new int[V * (V - 1) / 2][3];  // Array to store edges
        int index = 0;

        // Collect all edges from the graph
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (graph[i][j] != 0) {
                    edges[index++] = new int[]{i, j, graph[i][j]};
                }
            }
        }

        // Get the modified weights to remove negative weights using Bellman-Ford
        int[] alteredWeights = bellmanFordAlgorithm(edges, V);
        int[][] alteredGraph = new int[V][V];

        // Modify the weights of the edges to ensure all weights are non-negative
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (graph[i][j] != 0) {
                    alteredGraph[i][j] = graph[i][j] + alteredWeights[i] - alteredWeights[j];
                }
            }
        }

        // Print the modified graph with re-weighted edges
        System.out.println("Modified Graph:");
        for (int[] row : alteredGraph) {
            for (int weight : row) {
                System.out.print(weight + " ");
            }
            System.out.println();
        }

        // Run Dijkstra's algorithm for each vertex as the source
        for (int source = 0; source < V; source++) {
            System.out.println("\nShortest Distance with vertex " + source + " as the source:");
            dijkstraAlgorithm(graph, alteredGraph, source);
        }
    }

    // Main function to test Johnson's Algorithm
    public static void main(String[] args) {
        // Define a graph with possible negative weights
        int[][] graph = {
                {0, -5, 2, 3},
                {0, 0, 4, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 0}
        };

        // Execute Johnson's Algorithm
        johnsonAlgorithm(graph);
    }
}
