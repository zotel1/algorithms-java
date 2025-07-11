package shortestPath.shortestPathinDirectedAcyclicGraph;

/*Dado un grafo acíclico dirigido ponderado y un vértice de origen en el grafo, encuentre las rutas más cortas desde el origen dado a todos los demás vértices.

Para un gráfico ponderado general, podemos calcular las distancias más cortas de una sola fuente en tiempo O(VE) utilizando el algoritmo de Bellman-Ford. Para un gráfico sin pesos negativos, podemos hacerlo mejor y calcular las distancias más cortas de una sola fuente en tiempo O(E + VLogV) utilizando el algoritmo de Dijkstra. ¿Podemos hacerlo aún mejor para el grafo acíclico dirigido (DAG)? Podemos calcular las distancias más cortas de una sola fuente en tiempo O (V + E) para DAG. La idea es utilizar la ordenación topológica.

Inicializamos las distancias a todos los vértices como infinitas y la distancia a la fuente como 0, luego encontramos una ordenación topológica del grafo. La clasificación topológica de un grafo representa un ordenamiento lineal del grafo (ver más abajo, la figura (b) es una representación lineal de la figura (a)). Una vez que tenemos el orden topológico (o representación lineal), procesamos uno por uno todos los vértices en orden topológico. Para cada vértice que se está procesando, actualizamos las distancias de su adyacente utilizando la distancia del vértice actual.
*/

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class ShortestPath {
    static final int INF=Integer.MAX_VALUE;
    class AdjListNode
    {
        private int v;
        private int weight;
        AdjListNode(int _v, int _w) { v = _v;  weight = _w; }
        int getV() { return v; }
        int getWeight()  { return weight; }
    }

    // Class to represent graph as an adjacency list of
    // nodes of type AdjListNode
    class Graph
    {
        private int V;
        private LinkedList<AdjListNode> adj[];
        Graph(int v)
        {
            V=v;
            adj = new LinkedList[V];
            for (int i=0; i<v; ++i)
                adj[i] = new LinkedList<AdjListNode>();
        }
        void addEdge(int u, int v, int weight)
        {
            AdjListNode node = new AdjListNode(v,weight);
            adj[u].add(node);// Add v to u's list
        }

        // A recursive function used by shortestPath.
        // See below link for details
        void topologicalSortUtil(int v, Boolean visited[], Stack stack)
        {
            // Mark the current node as visited.
            visited[v] = true;
            Integer i;

            // Recur for all the vertices adjacent to this vertex
            Iterator<AdjListNode> it = adj[v].iterator();
            while (it.hasNext())
            {
                AdjListNode node =it.next();
                if (!visited[node.getV()])
                    topologicalSortUtil(node.getV(), visited, stack);
            }
            // Push current vertex to stack which stores result
            stack.push(new Integer(v));
        }

        // The function to find shortest paths from given vertex. It
        // uses recursive topologicalSortUtil() to get topological
        // sorting of given graph.
        void shortestPath(int s)
        {
            Stack stack = new Stack();
            int dist[] = new int[V];

            // Mark all the vertices as not visited
            Boolean visited[] = new Boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;

            // Call the recursive helper function to store Topological
            // Sort starting from all vertices one by one
            for (int i = 0; i < V; i++)
                if (visited[i] == false)
                    topologicalSortUtil(i, visited, stack);

            // Initialize distances to all vertices as infinite and
            // distance to source as 0
            for (int i = 0; i < V; i++)
                dist[i] = INF;
            dist[s] = 0;

            // Process vertices in topological order
            while (stack.empty() == false)
            {
                // Get the next vertex from topological order
                int u = (int)stack.pop();

                // Update distances of all adjacent vertices
                Iterator<AdjListNode> it;
                if (dist[u] != INF)
                {
                    it = adj[u].iterator();
                    while (it.hasNext())
                    {
                        AdjListNode i= it.next();
                        if (dist[i.getV()] > dist[u] + i.getWeight())
                            dist[i.getV()] = dist[u] + i.getWeight();
                    }
                }
            }

            // Print the calculated shortest distances
            for (int i = 0; i < V; i++)
            {
                if (dist[i] == INF)
                    System.out.print( "INF ");
                else
                    System.out.print( dist[i] + " ");
            }
        }
    }

    // Method to create a new graph instance through an object
    // of ShortestPath class.
    Graph newGraph(int number)
    {
        return new Graph(number);
    }

    public static void main(String args[])
    {
        // Create a graph given in the above diagram.  Here vertex
        // numbers are 0, 1, 2, 3, 4, 5 with following mappings:
        // 0=r, 1=s, 2=t, 3=x, 4=y, 5=z
        ShortestPath t = new ShortestPath();
        Graph g = t.newGraph(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);

        int s = 1;
        System.out.println("Following are shortest distances "+
                "from source " + s );
        g.shortestPath(s);
    }
}
