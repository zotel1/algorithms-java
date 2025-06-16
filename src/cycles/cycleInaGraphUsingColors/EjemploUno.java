package cycles.cycleInaGraphUsingColors;

import java.util.ArrayList;
import java.util.List;

/*Dado un grafo dirigido representado por el número de vértices y una lista de aristas dirigidas,
determine si el grafo contiene un ciclo.V

Su tarea es implementar una función que acepte (número de vértices) y (una matriz de bordes dirigidos donde cada borde es un par ),
y devuelva si el gráfico contiene al menos un ciclo, de lo contrario, devuelva .Vedges[u, v]truefalse.

La búsqueda en profundidad (DFS) es una técnica eficaz que se puede utilizar para detectar ciclos en un grafo dirigido.
Durante un recorrido DFS, si el grafo está conectado, forma un árbol DFS (o bosque para grafos desconectados).

En un árbol de este tipo, existe un ciclo si y solo si hay un borde posterior.
 Un borde trasero es un borde que apunta de un nodo a uno de sus antecesores,
 en el recorrido DFS, esto incluye bucles propios (un borde de un nodo a sí mismo).*/

public class EjemploUno {

    // Constructs amn adjacency list for a directed graph
    static List<Integer>[] consttructadj(int V, int[][] edges) {
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge: edges) {
            adj[edge[0]].add(edge[1]);
        }

        return adj;
    }

    // Utility function for DFS traversal and cycle detection
    static boolean dfsutil(int u, List<Integer>[] adj, int[] color) {
        final int gray = 1, black = 2;

        color[u] = gray;

        for (int v : adj[u]) {
            if (color[v] == gray) // back edge found
                return true;

            if (color[v] == 0 && dfsutil(v, adj, color)) // visit unvisited
                return true;
        }

        color[u] = black;
        return false;
    }

    // Main function to detect cycle in a directed graph
    static boolean isCyclic(int V, int[][] edges) {
        int[] color = new int[V];
        List<Integer>[] adj = consttructadj(V, edges);

        for (int i = 0; i < V; i++) {
            if (color[i] == 0) {
                if (dfsutil(i, adj, color))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 0 }, { 2, 3 }, { 3, 3} };
        System.out.println(isCyclic(V, edges) ? "true" : "false");
    }
}
