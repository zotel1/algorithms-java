package shortestPath.dialsAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*Dado un grafo ponderado y un vértice de origen,
la tarea consiste en encontrar las rutas más cortas desde el nodo de origen
hasta todos los demás vértices.

En este artículo hemos aprendido cómo encontrar el camino más corto desde un vértice de origen determinado a todos los demás vértices utilizando el algoritmo de camino más corto de Dijkstra con la complejidad temporal de O(E log V).

¿Podemos optimizar el algoritmo de ruta más corta de Dijkstra para que funcione mejor que O(E log V) si el peso máximo es pequeño (o el rango de pesos de borde es pequeño)?

Por ejemplo, en el diagrama anterior,
el peso máximo es 14.
Muchas veces,
el rango de pesos en los bordes está en un rango pequeño
(es decir, todos los pesos de los bordes se pueden asignar a 0, 1, 2.
W donde W es un número pequeño).
En ese caso,
el algoritmo de Dijkstra se puede modificar mediante el uso de diferentes
estructuras de datos y cubos, lo que se denomina
implementación de dial del algoritmo de Dijkstra.
la complejidad del tiempo es O(E + WV)
donde W es el peso máximo en cualquier borde del gráfico,
por lo que podemos ver que, si W es pequeño,
esta implementación se ejecuta mucho más rápido que el algoritmo tradicional.

Las siguientes son observaciones importantes.

La distancia máxima entre dos nodos cualesquiera puede estar en el máximo w(V – 1) (w es el peso máximo de la arista y podemos tener en el máximo V-1 aristas entre dos vértices).
En el algoritmo de Dijkstra, las distancias se finalizan en no decrecientes, es decir, la distancia de los vértices más cercanos (a la fuente dada) se finaliza antes que los vértices distantes.
Acercarse:

La idea es utilizar la optimización basada en cubos para el algoritmo de Dijkstra cuando los pesos de los bordes son números enteros pequeños. En lugar de usar una cola de prioridad, creamos cubos para cada valor de distancia posible y procesamos los nodos en orden de distancia iterando a través de los cubos secuencialmente.

Dial_s-Algorithm-07.webp*/

public class DialsAlgorithm {


    // Function to find Shortest Path
    static int[] shortestPath(int n, int src, int[][] edges) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        int maxWeight = 0;

        // Build adjacency list and find maximum weight
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            ArrayList<Integer> edge1 = new ArrayList<>();
            edge1.add(e[1]);
            edge1.add(e[2]);
            adj.get(e[0]).add(edge1);

            ArrayList<Integer> edge2 = new ArrayList<>();
            edge2.add(e[0]);
            edge2.add(e[2]);
            adj.get(e[1]).add(edge2);

            maxWeight = Math.max(maxWeight, e[2]);
        }

        // Initialize distance array
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Create buckets for distances
        int maxDist = (n - 1) * maxWeight;
        ArrayList<HashSet<Integer>> buckets = new ArrayList<>(maxDist + 1);
        for (int i = 0; i <= maxDist; i++) {
            buckets.add(new HashSet<>());
        }

        // Add source to bucket 0
        buckets.get(0).add(src);

        // Process buckets in order
        for (int d = 0; d <= maxDist; d++) {

            // Process all nodes in current bucket
            while (!buckets.get(d).isEmpty()) {
                int u = buckets.get(d).iterator().next();
                buckets.get(d).remove(u);

                // Skip if we already found a better path
                if (d > dist[u]) continue;

                // Process all adjacent nodes
                for (ArrayList<Integer> edge : adj.get(u)) {
                    int v = edge.get(0);
                    int weight = edge.get(1);
                    int newDist = dist[u] + weight;

                    // If shorter path found
                    if (newDist < dist[v]) {

                        // Remove from old bucket if it was there
                        if (dist[v] != Integer.MAX_VALUE) {
                            buckets.get(dist[v]).remove(v);
                        }

                        // Update distance and add to new bucket
                        dist[v] = newDist;
                        buckets.get(newDist).add(v);
                    }
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int n = 9;
        int src = 0;
        int[][] edges = {
                {0, 1, 4},
                {0, 7, 8},
                {1, 2, 8},
                {1, 7, 11},
                {2, 3, 7},
                {2, 8, 2},
                {3, 4, 9},
                {3, 5, 14},
                {4, 5, 10},
                {5, 6, 2},
                {6, 7, 1},
                {6, 8, 6},
                {7, 8, 7}
        };

        int[] res = shortestPath(n, src, edges);
        for (int val : res) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
