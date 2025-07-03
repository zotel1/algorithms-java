package multistageGraph;

/*Un grafo multietapa es un grafo dirigido y ponderado en el que los nodos se pueden dividir en un conjunto de etapas tal que todos los bordes son de una etapa a la siguiente etapa solamente (en otras palabras, no hay borde entre los vértices de la misma etapa y desde un vértice de la etapa actual a la etapa anterior).

Los vértices de un grafo multietápico se dividen en n número de subconjuntos disjuntos S = { S1 , S2 , S3 ........... Sn }, donde S1 es la fuente y Sn es el sumidero ( destino ). La cardinalidad de S1 y Sn son iguales a 1. es decir, |S1| = |Sn| = 1.
Se nos da un gráfico de varias etapas, un origen y un destino, necesitamos encontrar el camino más corto desde el origen hasta el destino. Por convención, consideramos el origen en la etapa 1 y el destino en la última etapa.
A continuación se muestra un gráfico de ejemplo que consideraremos en este artículo
Ahora hay varias estrategias que podemos aplicar:

El método de fuerza bruta para encontrar todas las rutas posibles entre el origen y el destino y, a continuación, encontrar el mínimo. Esa es la peor estrategia posible.
Algoritmo de Dijkstra de las rutas más cortas de una sola fuente. Este método encontrará las rutas más cortas desde el origen hasta todos los demás nodos, lo que no es necesario en este caso. Por lo tanto, llevará mucho tiempo y ni siquiera utiliza la función ESPECIAL que tiene este gráfico MULTIETAPA.
Método codicioso simple: en cada nodo, elija la ruta de salida más corta. Si aplicamos este enfoque al gráfico de ejemplo dado anteriormente, obtenemos la solución como 1 + 4 + 18 = 23. Pero un vistazo rápido al gráfico mostrará caminos mucho más cortos disponibles que 23. ¡Así que el método codicioso falla!
La mejor opción es la Programación Dinámica. Por lo tanto, necesitamos encontrar subestructuras óptimas, ecuaciones recursivas y subproblemas superpuestos.

Subestructura óptima y ecuación recursiva: -
Definimos la notación: - M(x, y) como el costo mínimo para T (nodo objetivo) de la etapa x, nodo y.*/

public class EjemploUno {


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
