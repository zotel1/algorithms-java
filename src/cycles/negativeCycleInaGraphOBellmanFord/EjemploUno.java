package cycles.negativeCycleInaGraphOBellmanFord;

import java.util.Arrays;
/*Dado un grafo ponderado dirigido,
su tarea es encontrar si el grafo dado contiene algún ciclo negativo al que se pueda acceder desde el vértice de origen
(por ejemplo, nodo 0).

Nota: Un ciclo de peso negativo es un ciclo en un gráfico cuyos bordes se suman a un valor negativo.*/

public class EjemploUno {

    // A structure to represent a weighted edge in graph
    static class Edge {
        int src, dest, weight;
    }

    // A structure to represent a connected, directed and weighted graph
    static class Graph {

        // V -> Number of vertices,
        // E -> Number of edges
        int V, E;

        // Graph is represented as an array of edges.
        Edge edge[];
    }

    // Creates a graph with V vertices and E edges
    static Graph createGraph(int V, int E) {
        Graph graph = new Graph();
        graph.V = V;
        graph.E = E;
        graph.edge = new Edge[graph.E];

        for (int i = 0; i < graph.E; i++) {
            graph.edge[i] = new Edge();
        }

        return graph;
    }

    // the main function that finds shortest distances
    // from src to all other vertices using Bellman-
    // Ford algorithm. The function also detects
    // negative weight cycle
    static boolean isNegCycleBellmanFord(Graph graph, int src, int dist[]) {
        int V = graph.V;
        int E = graph.E;

        // Step 1: Initialize distances from src
        // to all other vertices as INFINITE
        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;

        dist[src] = 0;

        // Step 2: Relax all edges |V| - 1 times.
        // A simple shortest path from src to any
        // other vertex can have at-most |V| - 1
        // edges
        for (int i = 1; i <= V - 1; i++) {
            for ( int j = 0; j < E; j++) {
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                int weight = graph.edge[j].weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        // Step 3: check for negative-weight cycles.
        // The above step guarantees shortest distances
        // if graph doesn't contain negative weight cycle.
        // If we get a shorter path, then there is a cycle.
        for (int i = 0; i < E; i++) {
            int u = graph.edge[i].src;
            int v = graph.edge[i].dest;
            int weight = graph.edge[i].weight;

            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                return true;
        }
        return false;
    }

    // Returns true if given graph has negative weight cycle.
    static boolean isNegCycleDisconnected(Graph graph) {
        int V = graph.V;

        // to keep track of visited vertices to avoid recomputations.
        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);

        // This array is filled by Bellman-Ford
        int dist[] = new int[V];

        // Call Bellman-Ford for all those vertices
        // that are not visited
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {

                // If cycle found
                if (isNegCycleBellmanFord(graph, i, dist))
                    return true;

                // Mark all vertices that are visited in above call.
                for (int j = 0; j < V; i++)
                    if (dist[j] != Integer.MAX_VALUE)
                        visited[j] = true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5, E = 8;
        Graph graph = createGraph(V, E);

        // Add edge 0-1 (or A-B in above figure)
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;

        // Add edge 0-2 (or A-C in above figure)
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;

        // Add edge 1-2 (or B-C in above figure)
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;

        // Add edge 1-3 (or B-D in above figure)
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;

        // Add edge 1-4 (or A-E in above figure)
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;

        // Add edge 3-2 (or D-C in above figure)
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;

        // Add edge 3-1 (or D-B in above figure)
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;

        // Add edge 4-3 (or E-D in above figure)
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;

        if (isNegCycleDisconnected(graph))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
