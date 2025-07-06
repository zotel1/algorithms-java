package minimumMeanWeightCycleAlgorithm;

import java.util.Vector;

/*Dado un grafo dirigido y fuertemente conectado con pesos de borde no negativos.
Definimos el peso medio de un ciclo como la suma de todos los pesos de los bordes del ciclo divididos por el no. de los bordes.
Nuestra tarea es encontrar el peso medio mínimo entre todos los ciclos dirigidos del gráfico.

La entrada se proporciona como una lista de aristas,
donde cada arista está representada por un triplete que indica una arista dirigida de nodo a nodo con peso .
Los nodos se etiquetan desde hasta ,
y se garantiza que el grafo está fuertemente conectado,
lo que significa que existe una ruta entre cada par de nodos.[u, v, w]uvw0n-1

Ejemplo:

Entrada: [[0, 1, 1], [0, 2, 10], [1, 2, 3], [2, 3, 2], [3, 1, 0], [3, 0, 8]]

112

Salida: 1.66667

Acercarse:*/

public class PesoMinimo {

        static int V = 4;

// a struct to represent edges
        static class Edge {
            int from, weight;

            Edge(int from, int weight) {
                this.from = from;
                this.weight = weight;
            }
        }

// vector to store edges
//@SuppressWarnings("unchecked")
        static Vector<Edge>[] edges = new Vector[V];
        static
        {
            for (int i = 0; i < V; i++)
                edges[i] = new Vector<>();
        }

        static void addedge ( int u, int v, int w)
        {
            edges[v].add(new Edge(u, w));
        }

// calculates the shortest path
        static void shortestpath ( int[][] dp)
        {
            // initializing all distances as -1
            for (int i = 0; i <= V; i++)
                for (int j = 0; j < V; j++)
                    dp[i][j] = -1;

            // shortest distance from first vertex
            // to in itself consisting of 0 edges
            dp[0][0] = 0;

            // filling up the dp table
            for (int i = 1; i <= V; i++) {
                for (int j = 0; j < V; j++) {
                    for (int k = 0; k < edges[j].size(); k++) {
                        if (dp[i - 1][edges[j].elementAt(k).from] != -1) {
                            int curr_wt = dp[i - 1][edges[j].elementAt(k).from] +
                                    edges[j].elementAt(k).weight;
                            if (dp[i][j] == -1)
                                dp[i][j] = curr_wt;
                            else
                                dp[i][j] = Math.min(dp[i][j], curr_wt);
                        }
                    }
                }
            }
        }

// Returns minimum value of average weight
// of a cycle in graph.
        static double minAvgWeight ()
        {
            int[][] dp = new int[V + 1][V];
            shortestpath(dp);

            // array to store the avg values
            double[] avg = new double[V];
            for (int i = 0; i < V; i++)
                avg[i] = -1;

            // Compute average values for all vertices using
            // weights of shortest paths store in dp.
            for (int i = 0; i < V; i++) {
                if (dp[V][i] != -1) {
                    for (int j = 0; j < V; j++)
                        if (dp[j][i] != -1)
                            avg[i] = Math.max(avg[i],
                                    ((double) dp[V][i] -
                                            dp[j][i]) / (V - j));
                }
            }

            // Find minimum value in avg[]
            double result = avg[0];
            for (int i = 0; i < V; i++)
                if (avg[i] != -1 && avg[i] < result)
                    result = avg[i];

            return result;
        }

// Driver Code
        public static void main (String[]args)
        {
            addedge(0, 1, 1);
            addedge(0, 2, 10);
            addedge(1, 2, 3);
            addedge(2, 3, 2);
            addedge(3, 1, 0);
            addedge(3, 0, 8);

            System.out.printf("%.5f", minAvgWeight());
        }
    }

    /*Complejidad temporal : La complejidad temporal del programa dado es O(V^3),
    donde V es el número de vértices en el grafo.
    Esto se debe a que el programa utiliza un bucle anidado para llenar la tabla dp y el tamaño de la tabla dp es V^2.
    El bucle más externo se ejecuta V veces,
    el bucle central se ejecuta V veces y el bucle más interno puede ejecutarse hasta V veces en el peor de los casos,
    lo que da una complejidad de tiempo total de O(V^3).
    Las otras partes del programa tienen una menor complejidad de tiempo
    y no contribuyen significativamente a la complejidad de tiempo general.

Complejidad del espacio: La complejidad del espacio del programa dado es O(V^2),
donde V es el número de vértices en el grafo.
Esto se debe a que el programa crea una matriz 2D dp de tamaño (V+1)xV,
que requiere O(V^2) espacio. Además, el programa crea un vector de aristas,
que ocupa el espacio O(E), donde E es el número de aristas en el gráfico.
Sin embargo, en esta implementación en particular,
el número de aristas no se almacena directamente y no está claro si todas las aristas se agregan realmente al vector.
Por lo tanto, la complejidad del espacio está determinada principalmente por el tamaño de la matriz dp, que es O(V^2).*/
