package bFSShortestPath;

import java.util.ArrayDeque;
import java.util.Deque;

/*Dado un grafo no dirigido en el que cada arista tiene un peso igual a 0 o 1. La tarea consiste en encontrar la ruta más corta desde el vértice de origen hasta todos los demás vértices del grafo.

Ejemplo:

Entrada: Fuente Vértice = 0 y por debajo del gráfico Con vértices como (u, v, w):
 bordes: [[0,1,0], [0, 7, 1], [1,2,1], [1, 7, 1], [2, 3, 0], [2, 5, 0], [2, 8, 1], [3, 4, 1],[3, 5, 1],[4, 5, 1],[5, 6, 1],[6, 7, 1],[7, 8, 1]]
Salida: 0 0 1 1 1 2 1 2 1 2 1 2

[Enfoque ingenuo] Uso del algoritmo de Dijkstra - O(E * log (V)) Tiempo y O(V) Espacio
En el algoritmo de Dijkstra, el objetivo es encontrar la distancia más corta desde un nodo de origen dado a todos los demás nodos del grafo. Como el nodo de origen es el punto de partida, su distancia se inicializa en cero. A partir de ahí, elegimos iterativamente el nodo sin procesar con la distancia mínima desde la fuente, aquí es donde normalmente se usa un montón mínimo (cola de prioridad) o un conjunto para mayor eficiencia.

Consulte el algoritmo de Dijkstra para encontrar el camino más corto para obtener una explicación detallada.

[Enfoque esperado] Uso de Deque - Tiempo O(V + E) y espacio O(V + E)
La idea es adaptar BFS para manejar de manera eficiente gráficos con pesos binarios (0 o 1) mediante el uso de un deque en lugar de una cola. Cuando nos encontramos con una arista con peso 0, añadimos su destino al frente del deque porque no aumenta la distancia. Cuando nos encontramos con una arista con peso 1, añadimos su destino a la parte posterior del deque porque aumenta la distancia en una unidad.

Enfoque paso a paso:

Inicialice la matriz de distancias con infinito para todos los vértices excepto el origen.
Utilice un deque para procesar los vértices en orden creciente de distancia.
Para cada vértice, examine todos los vértices adyacentes. Si la nueva distancia del vértice es menor que la distancia actual, entonces
Si el grosor del borde es 0, agregue el vértice adyacente al frente de la deque (prioridad).
Si el grosor del borde es 1, agregue el vértice adyacente a la parte posterior del deque.
¿Cómo funciona?*/

public class RutaMasCortaPesoBinario {

    static int[] minDist(int n, int src, int[][] edges) {

        // create adjacency list representation of the graph
        int[][][] adj = new int[n][][];
        int[] edgeCount = new int[n];

        // frist pass to count edges per node
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            edgeCount[u]++;
            edgeCount[v]++;
        }

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adj[i] = new int[edgeCount[i]][2];
            edgeCount[i] = 0; // Reset to use as index
        }

        // Populate adjacency list for (int[] edge : edges) {

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj[u][edgeCount[u]++] = new int[]{v, w};
            adj[v][edgeCount[v]++] = new int[]{u, w};
        }

        // Initialize distances to infinity
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        // Use deque for 0-1 BFS
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(src);

        while (!dq.isEmpty()) {
            int u = dq.removeFirst();

            // Process all adjacent vertices
            for (int[] edge : adj[u]) {
                int v = edge[0];
                int weight = edge[1];

                // If we can improve the distance
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;

                    // If weight is 0, push to front (higher priority)
                    // If weight is 1, push to back (lower priority)
                    if (weight == 0)
                        dq.addFirst(v);
                    else
                        dq.addLast(v);
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int n = 9, src = 0;
        int[][] edges = {
                {0, 1, 0}, {0, 7, 1}, {1, 2, 1}, {1, 7, 1},
                {2, 3, 0}, {2, 5, 0}, {2, 8, 1}, {3, 4, 1}, {3, 5, 1},
                {4, 5, 1}, {5, 6, 1}, {6, 7, 1}, {7, 8, 1}
        };

        int[] res = minDist(n, src, edges);
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}