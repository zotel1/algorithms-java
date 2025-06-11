package grafos.transitiveClosureOfaGraphusingDFS;

import java.util.ArrayList;
import java.util.Arrays;
/*Dado un grafo dirigido, averigue si se puede acceder a un vertice v desde otro
vertice u para todos los pares de vertices (u, v) en el grafo dado.
Aqui, alcanzable significa que hay un camino desde el vertice u hasta el v.
La matriz de alcanzabilidad se denomina cierre transitivo de un grafo.*/

// A directed graph using
// adjacency list representation
public class EjemploUno {

    // No. of vertices in graph
    private int vertices;

    // Adjacency list
    private ArrayList<Integer>[] adjList;

    // To store transitive closure
    private int[][] tc;

    // constructor
    public EjemploUno(int vertices) {

        // initialise vertex count
        this.vertices = vertices;
        this.tc = new int[this.vertices][this.vertices];

        // initialise adjacency list
        initAdjList();
    }

    // utility method to initialise adjacency list
    @SuppressWarnings("unchecked")
    private void initAdjList() {

        adjList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    // add edge from u to v
    public void addedge(int u, int v) {

        // Add v to u's list.
        adjList[u].add(v);
    }

    // The function to find transitive closure. It uses recursive DFSUtil()
    public void transitiveClosure() {
        // Call the recursive helper function to print DFS traversal starting from all vertices one by one
        for (int i = 0; i < vertices; i++) {
            dfsUtil(i, i);
        }

        for (int i = 0; i < vertices; i++) {
            System.out.println(Arrays.toString(tc[i]));
        }
    }

    // A recursive DFS traversal function that finds all reachable vertices for s

    private void dfsUtil(int s, int v) {

        // Mark reachability from s to v as true.
        if(s == v) {
            tc[s][v] = 1;
        }
        else tc[s][v] = 1;

        // Finmd all the vertices reachable through v
        for (int adj : adjList[v]) {
            if (tc[s][adj] == 0) {
                dfsUtil(s, adj);
            }
        }
    }

    public static void main(String[] args) {

        // Create a graph given in the above diagram
        EjemploUno g = new EjemploUno(4);

        g.addedge(0, 1);
        g.addedge(0, 2);
        g.addedge(1, 2);
        g.addedge(2, 0);
        g.addedge(2, 3);
        g.addedge(3, 3);
        System.out.println("Transitive closure " + "matrix is");
        g.transitiveClosure();
    }
}
