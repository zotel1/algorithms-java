package cycles.cyclesOfLengthN;

/*Dado un grafo no dirigido y conexo y un número n,
cuenta el número total de ciclos simples de longitud n en el grafo.
Un ciclo simple de longitud n se define como un ciclo que contiene exactamente n vértices y n aristas.
Tenga en cuenta que para un grafo no dirigido, cada ciclo solo debe contarse una vez,
independientemente del vértice o la dirección iniciales.*/

public class EjemploUno {

    // Number of vertices
    public static final int V = 5;
    static int count = 0;

    static void DFS(int graph[][], boolean marked[], int n, int vert, int start) {

        // Mark the vertex vert as visited
        marked[vert] = true;

        // If the path of length (n-1) is found
        if (n == 0) {

            // Mark vert as un-visited to make it usable again
            marked[vert] = false;

            // Check if vertex vert end with vertex start
            if (graph[vert][start] == 1) {
                count++;
                return;
            } else
                return;
        }

        // For searching every possible path of length (n-1)
        for (int i = 0; i < V; i++)
            if (!marked[i] && graph[vert][i] == 1)

                // DFS for searching path by decreasing length by 1
                DFS(graph, marked, n-1, i, start);

        // marking vert as unvisited to make it usable again
        marked[vert] = false;
    }

    // Count cycles of length N in an undirected and connected graph.
    static int countCycles(int graph[][], int n) {

        // all vertex are marked un-visited initially.
        boolean marked[] = new boolean[V];

        // Searching for cycle by using v-n+1 vertices
        for (int i = 0; i < V - (n - 1); i++) {
            DFS(graph, marked, n-1, i, i);

            // ith vertex is marked as visited and will not be visited again
            marked[i] = true;
        }

        return count / 2;
    }

    public static void main(String[] args) {
        int graph[][] = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0}
        };
        int n = 4;

        System.out.println("Total cycles of length " + n + " are " + countCycles(graph, n));
    }
}
