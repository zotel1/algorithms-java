package shortestPath.floydWarshall;

/*Dada una matriz de tamaño ,
donde representa el peso de la arista de nodo a nodo .
Si no hay una arista directa,
se establece en un valor grande (por ejemplo, 10⁸) para representar el infinito.
Las entradas diagonales son ,
ya que la distancia de un nodo a sí mismo es cero.
El gráfico puede contener pesos de borde negativos,
pero no contiene ningún ciclo de peso negativo.dist[][]n x ndist[i][j]ijdist[i][j]dist[i][i]0

Su tarea es determinar la distancia de ruta más corta entre todos los pares de nodos i y j en el gráfico.

Algoritmo de Floyd Warshall:
El algoritmo de Floyd-Warshall funciona manteniendo una matriz bidimensional que representa las distancias entre nodos. Inicialmente, esta matriz se rellena utilizando solo los bordes directos entre los nodos. A continuación, el algoritmo actualiza gradualmente estas distancias comprobando si existen rutas más cortas a través de nodos intermedios.

Este algoritmo funciona tanto para los gráficos ponderados dirigidos como para los no dirigidos y puede manejar gráficos con bordes de peso positivos y negativos.

Nota: No funciona para los gráficos con ciclos negativos (donde la suma de las aristas de un ciclo es negativa).

Idea detrás del algoritmo de Floyd Warshall:
Supongamos que tenemos un grafo dist[][] con V vértices de 0 a V-1.
Ahora tenemos que evaluar un dist[][] donde dist[i][j] representa el camino más corto entre el vértice i a j.

Supongamos que los vértices i a j tienen nodos intermedios.
La idea detrás del algoritmo de Floyd Warshall es tratar todos y cada uno de los vértices k de 0 a V-1 como un nodo intermedio uno por uno.
Cuando consideramos el vértice k,
ya debemos haber considerado los vértices de 0 a k-1.
Por lo tanto, usamos las rutas más cortas construidas por los vértices anteriores para construir rutas más cortas con el vértice k incluido.

¿Por qué funciona Floyd Warshall (prueba de corrección)?
El algoritmo se basa en el principio de subestructura óptima, es decir:

Si el camino más corto de i a j pasa a través de algún vértice k,
entonces el camino de i a k y el camino de k a j también deben ser caminos más cortos.
El enfoque iterativo garantiza que,
en el momento en que se considera el vértice k,
todas las rutas más cortas que utilizan solo los vértices 0 a k-1 ya se han calculado.
Al final del algoritmo,
todas las rutas más cortas se calculan de forma óptima porque se ha considerado cada vértice intermedio posible.

¿Por qué el algoritmo de Floyd-Warshall es mejor para grafos densos y no para grafos dispersos?
Grafo denso: Grafo en el que el número de aristas es significativamente mayor que el número de vértices.
Grafo disperso: Grafo en el que el número de aristas es muy bajo.

No importa cuántas aristas haya en el gráfico,
el algoritmo de Floyd Warshall se ejecuta para O(V3) veces, por lo tanto,
es el más adecuado para grafos densos.
En el caso de grafos dispersos, el algoritmo de Johnson es más adecuado. */

public class EjemploUno {

    // Solves the all-pairs shortest path problem using Floyd Warshall algorithm
    static void floydWarshall(int[][] dist) {
        int V = dist.length;

        // Add all vertices one by one to the set of intermediate vertices.
        for (int k = 0; k < V; k++) {

            // Pick all vertices as source one by one
            for (int i = 0; i < V; i++) {

                // Pick all vertices as destination for the above picked source
                for (int j = 0; j < V; j++) {

                    // shortest path from i to j
                    if (dist[i][k] != 1e8 && dist[k][j]!= 1e8) dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int INF = 100000000;

        int[][] dist = {
                { 0,4, INF, 5, INF },
                { INF, 0, 1, INF, 6 },
                { 2, INF, 0, 3, INF },
                { INF, INF, 1, 0, 2 },
                { 1, INF, INF, 4, 0 }
        };

        floydWarshall(dist);
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                System.out.println(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
