package multistageGraph;

/*Complejidad temporal : La complejidad temporal del código dado es O(N^2), donde N es el número de nodos en el grafo. Esto se debe a que el código implica dos bucles anidados que iteran sobre todos los pares de nodos del gráfico, y cada iteración realiza una cantidad constante de trabajo (es decir, comparar y actualizar distancias). Dado que el grafo se representa mediante una matriz de adyacencia, el acceso a un elemento lleva un tiempo constante. Por lo tanto, la complejidad temporal general del algoritmo es O(N^2).

Complejidad del espacio: La complejidad del espacio del programa dado es O(N), donde N es el número de nodos en el grafo. Esto se debe a que el programa utiliza una matriz de tamaño N para almacenar la distancia más corta desde cada nodo hasta el nodo de destino N-1.
 */

public class EjemploDos {
    static int N = 8;
    static int INF = Integer.MAX_VALUE;

    // Returns shortest distance from 0 to
    // N-1.
    public static int shortestDist(int[][] graph)
    {

        // dist[i] is going to store shortest
        // distance from node i to node N-1.
        int[] dist = new int[N];

        dist[N - 1] = 0;

        // Calculating shortest path for
        // rest of the nodes
        for (int i = N - 2; i >= 0; i--) {

            // Initialize distance from i to
            // destination (N-1)
            dist[i] = INF;

            // Check all nodes of next stages
            // to find shortest distance from
            // i to N-1.
            for (int j = i; j < N; j++) {
                // Reject if no edge exists
                if (graph[i][j] == INF) {
                    continue;
                }

                // We apply recursive equation to
                // distance to target through j.
                // and compare with minimum distance
                // so far.
                dist[i] = Math.min(dist[i],
                        graph[i][j] + dist[j]);
            }
        }

        return dist[0];
    }

    // Driver code
    public static void main(String[] args)
    {
        // Graph stored in the form of an
        // adjacency Matrix
        int[][] graph = new int[][] {
                { INF, 1, 2, 5, INF, INF, INF, INF },
                { INF, INF, INF, INF, 4, 11, INF, INF },
                { INF, INF, INF, INF, 9, 5, 16, INF },
                { INF, INF, INF, INF, INF, INF, 2, INF },
                { INF, INF, INF, INF, INF, INF, INF, 18 },
                { INF, INF, INF, INF, INF, INF, INF, 13 },
                { INF, INF, INF, INF, INF, INF, INF, 2 }
        };

        System.out.println(shortestDist(graph));
    }
}
