package grafos.checkForBipartite;

/*
* Comprobar si un grafo es bipartito es como tratar de colorear el grafo usando solo dos colores, de modo que no haya
* dos vertices adyacentes que tengan el mismo color. Un enfoque es verificar si el grafico es de 2 colores o no
* utilizando el algoritmo de retroceso m problema de colocacion.
* Una forma comun y eficaz de resolver esto es mediante el uso de la busqueda de amplitud(BFS). La idea es
* recorrer el grafo nivel por nivel y asignar colores alternativamente a los vertices a medida que avanzamos. */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class EjemploUno {
    // Function to construct the adyacency list from edges
    static ArrayList<ArrayList<Integer>> constructadj(int V, int[][] edges ) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return adj;
    }

    // Function to check if the graph is Bipartite using BFS

    static boolean isBipartite(int V, int[][] edges) {

        int[] color = new int[V];
        Arrays.fill(color, -1);

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = constructadj(V, edges);

        for (int i = 0; i <V; i++) {
            if (color[i] == -1) {
                Queue<Integer> q = new LinkedList<>();
                color[i] = 0;
                q.offer(i);

                while (!q.isEmpty()) {
                    int u = q.poll();

                    for (int v : adj.get(u)) {
                        if (color[v] == -1) {
                            color[v] = 1 - color[u];
                            q.offer(v);
                        } else if (color[v] == color[u]) {
                            return false; // Conflict found
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int V = 4;

        // Edges of the graph
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};

        // check if the graph is bipartite
        System.out.println(isBipartite(V, edges));
    }
}
