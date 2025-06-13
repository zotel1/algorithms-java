package cycles.cycleInAnUndirectedGraph;

import java.util.ArrayList;
import java.util.List;
/*
* BFS es útil para la detección de ciclos en un grafo no dirigido porque explora nivel por nivel,
* asegurando que cada nodo se visite de la manera más corta posible.
* Detecta eficazmente los ciclos mediante una matriz visitada y una cola,
* al tiempo que evita las llamadas recursivas innecesarias,
* lo que lo hace más eficiente en la memoria que DFS para gráficos grandes.

Durante el recorrido de BFS,
* mantenemos una matriz visitada y una cola.
* Procesamos los nodos sacándolos uno por uno de la cola,
* marcándolos como visitados y empujando sus nodos adyacentes no visitados a la cola.
* Se detecta un ciclo si nos encontramos con un nodo que ya ha sido visitado antes de ser retirado de la cola,
* es decir, que se ha llegado a él a través de una ruta diferente.
* Este enfoque garantiza que detectemos los ciclos de manera eficiente mientras mantenemos un rendimiento óptimo.
*
* Uso de la búsqueda de profundidad primero: tiempo O(V+E) y espacio O(V)
Depth First Traversal se puede utilizar para detectar un ciclo en un grafo no dirigido.
* Si volvemos a encontrar un vértice visitado,
* entonces decimos que hay un ciclo.
* Pero hay una trampa en este algoritmo,
* debemos asegurarnos de que no consideramos cada borde como un ciclo porque en un grafo no dirigido,
* un borde de 1 a 2 también significa un borde de 2 a 1.
* Para manejar esto, mantenemos un seguimiento del nodo principal
* (el nodo desde el que llegamos al nodo actual) en el recorrido DFS e ignoramos el nodo principal de la condición visitada.*/

public class EjemploUno {

    // Helper function to check cycle using DFS
    static boolean isCycleutil(int v, List<Integer>[] adj, boolean[] visited, int parent) {

        visited[v] = true;
        // If an adjacent vertex is not visited, the recur for that adjacent
        for (int i : adj[v]) {
            if (!visited[i]) {
                if (isCycleutil(i, adj, visited, v))
                    return true;
            }

            // If an adjacent vertex is visited and is not parent of current vertex, then there exists a cycle in the graph
            else if (i != parent) {
                return true;
            }
        }
        return false;
    }
    static List<Integer>[] constructadj(int V, int[][] edges) {

        List<Integer>[] adj = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        return adj;
    }

    // Function to check if graph constains a cycle
    static boolean isCycle(int V, int[][] edges) {
        List<Integer> [] adj = constructadj(V, edges);

        for  (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[V];
        // Call the recursive helper function to detectec cycle in diferent DFS trees
        for (int u = 0; u < V; u++) {
            if (!visited[u]) {
                if (isCycleutil(u, adj, visited, -1))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {
                {0, 1}, {0, 2}, {0, 3}, {1, 2}, {3, 4}
        };

        if (isCycle(V, edges)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
