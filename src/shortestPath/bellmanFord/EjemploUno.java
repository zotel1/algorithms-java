package shortestPath.bellmanFord;

/*Dado un grafo ponderado con vértices V y bordes E,
junto con un vértice de origen src,
la tarea consiste en calcular las distancias más cortas desde el origen hasta todos los demás vértices.
Si un vértice es inalcanzable desde el origen,
su distancia debe marcarse como 108.
En presencia de un ciclo de peso negativo,
devuelva -1 para indicar que los cálculos de la ruta más corta no son factibles.
Enfoque: Algoritmo de Bellman-Ford - Tiempo O(V*E) y espacio O(V)
Ciclo de peso negativo:
Un ciclo de peso negativo es un ciclo en un gráfico,
cuya suma de pesos de borde es negativa. Si atraviesa el ciclo,
el peso total acumulado sería menor que cero.
En presencia de un ciclo de peso negativo en el gráfico, el camino más corto no existe porque con cada recorrido del ciclo, el camino más corto sigue disminuyendo.

Limitación del algoritmo de Dijkstra:
Dado que necesitamos encontrar el camino más corto de una sola fuente,
inicialmente podríamos pensar en usar el algoritmo de Dijkstra.
Sin embargo, Dijkstra no es adecuado cuando el gráfico consta de bordes negativos.
La razón es que no vuelve a visitar los nodos que ya se han marcado como visitados.
Si existe una ruta más corta a través de una ruta más larga con bordes negativos,
el algoritmo de Dijkstra no podrá manejarla.

Principio de relajación de los bordes
La relajación significa actualizar la distancia más corta a un nodo si se encuentra una ruta más corta a través de otro nodo. Para un borde (u, v) con peso w:
Si al pasar por u se obtiene un camino más corto a v desde el nodo de origen (es decir, distancia [v] > distancia [u] + w), actualizamos la distancia [v] como distancia [u] + w.
En el algoritmo de Bellman-Ford, este proceso se repite (V - 1) veces para todas las aristas.
¿Por qué los bordes relajantes (V - 1) veces nos dan el camino más corto de una sola fuente?
Una ruta más corta entre dos vértices puede tener como máximo (V - 1) bordes. No es posible tener un camino simple con más de (V - 1) aristas (de lo contrario, formaría un ciclo). Por lo tanto, repetir el proceso de relajación (V - 1) veces asegura que se hayan cubierto todos los caminos posibles entre la fuente y cualquier otro nodo.

En la primera relajación, dado que los caminos más cortos para los vértices 1 y 2 son desconocidos (infinito, es decir, 108),
los caminos más cortos para los vértices 2 y 3 también seguirán siendo infinitos (108) .
Y, para el vértice 1, la distancia se actualizará a 4, como (es decir, 10dist[0] + 4 < dist[1]0 + 4 < 8).
En la segunda relajación, el camino más corto para el vértice 2 sigue siendo infinito (por ejemplo, 108),
lo que significa que la ruta más corta para el vértice 3 también seguirá siendo infinita. Para el vértice 2,
la distancia se puede actualizar a 3, ya que dist[1] + (-1) = 3.
En la tercera relajación, el camino más corto para el vértice 3 se actualizará a 5, ya que dist[2] + 2 = 5.
Entonces, en el ejemplo anterior, dist[1] se actualiza en la 1ª relajación, dist[2] se actualiza en la segunda relajación,
por lo que el dist para el último nodo (V - 1), se actualizará en (V - 1) ª relajación.

Detección de un ciclo de peso negativo
Como hemos discutido anteriormente,
necesitamos relajaciones (V - 1) de todos los bordes para lograr el camino más corto de una sola fuente.
Si es posible una relajación adicional (Vth) para cualquier borde,
indica que algunos bordes con peso negativo total se han atravesado una vez más.
Esto indica la presencia de un ciclo de peso negativo en el gráfico.
*/

import java.util.Arrays;

public class EjemploUno {
    static int[] bellmanFord(int V, int[][] edges, int src) {

        // Initially distance from source to all other vertices
        // is not known(Infinite).
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e8);
        dist[src] = 0;

        // Relaxation of all the edges V times, not (V - 1) as we
        // need one additional relaxation to detect negative cycle
        for (int i = 0; i < V; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {

                    // If this is the Vth relaxation, then there is
                    // a negative cycle
                    if (i == V - 1)
                        return new int[]{-1};

                    // Update shortest distance to node v
                    dist[v] = dist[u] + wt;
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {

        // Number of vertices in the graph
        int V = 5;

        // Edge list representation: {source, destination, weight}
        int[][] edges = new int[][] {
                {1, 3, 2},
                {4, 3, -1},
                {2, 4, 1},
                {1, 2, 1},
                {0, 1, 5}
        };

        // Source vertex for Bellman-Ford algorithm
        int src = 0;

        // Run Bellman-Ford algorithm from the source vertex
        int[] ans = bellmanFord(V, edges, src);

        // Print shortest distances from the source to all vertices
        for (int dist : ans)
            System.out.print(dist + " ");
    }

}
