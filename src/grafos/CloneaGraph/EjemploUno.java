package grafos.CloneaGraph;

import java.util.*;

/*Dado un grafo no dirigido conectado representado por una lista de adyacencia,
adjList[][] con n nodos y m bordes, con cada nodo con una etiqueta distinta de 0 a n-1, y
 cada adj[i] representa la lista de vértices conectados al vértice i.

Cree un clon del gráfico, donde cada nodo del gráfico contiene un valor entero y una matriz (vecinos) de nodos,
que contienen nodos adyacentes al nodo actual.*/
// Definition for a Node
class Node {
    public int val;
    public ArrayList<Nodee> neighbors;

    public Node() {
        neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }
}

public class EjemploUno {

    // Clone the graph
    public static Nodee cloneGraph(Nodee nodee) {
        if (nodee == null) return null;

        Map<Nodee, Nodee> mp = new HashMap<>();
        Queue<Nodee> q = new LinkedList<>();

        // Clone the starting node
        Nodee clone = new Nodee(nodee.val);
        mp.put(nodee, clone);
        q.offer(nodee);

        while (!q.isEmpty()) {
            Nodee current = q.poll();

            for (Nodee neighbor : current.neighbors) {

                // Clone neighbor if it hasn't been cloned yet
                if (!mp.containsKey(neighbor)) {
                    mp.put(neighbor, new Nodee(neighbor.val));
                    q.offer(neighbor);
                }

                // Add the clone of the neighbor to the current node's clone
                mp.get(current).neighbors.add(mp.get(neighbor));
            }
        }

        return mp.get(nodee);
    }

    // Build graph
    public static Nodee buildGraph() {
        Nodee nodee1 = new Nodee(0);
        Nodee nodee2 = new Nodee(1);
        Nodee nodee3 = new Nodee(2);
        Nodee nodee4 = new Nodee(3);

        nodee1.neighbors.addAll(new ArrayList<>
                (Arrays.asList(nodee2, nodee3)));
        nodee2.neighbors.addAll(new ArrayList<>
                (Arrays.asList(nodee1, nodee3)));
        nodee3.neighbors.addAll(new ArrayList<>
                (Arrays.asList(nodee1, nodee2, nodee4)));
        nodee4.neighbors.addAll(new ArrayList<>
                (Arrays.asList(nodee3)));

        return nodee1;
    }

    // Compare two graphs for structure and value
    public static boolean compareGraphs(Nodee n1, Nodee n2,
                                        HashMap<Nodee, Nodee> visited) {
        if (n1 == null || n2 == null)
            return n1 == n2;

        if (n1.val != n2.val || n1 == n2)
            return false;

        visited.put(n1, n2);

        if (n1.neighbors.size() != n2.neighbors.size())
            return false;

        for (int i = 0; i < n1.neighbors.size(); i++) {
            Nodee neighbor1 = n1.neighbors.get(i);
            Nodee neighbor2 = n2.neighbors.get(i);

            if (visited.containsKey(neighbor1)) {
                if (visited.get(neighbor1) != neighbor2)
                    return false;
            } else {
                if (!compareGraphs(neighbor1, neighbor2, visited))
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Nodee original = buildGraph();
        Nodee cloned = cloneGraph(original);
        boolean isEqual = compareGraphs(original, cloned,
                new HashMap<>());
        System.out.println(isEqual ? "true" : "false");
    }
}