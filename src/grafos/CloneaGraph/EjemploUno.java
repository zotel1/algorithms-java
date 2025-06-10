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
    public ArrayList<Node> neighbors;

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
    public static Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> mp = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        // Clone the starting node
        Node clone = new Node(node.val);
        mp.put(node, clone);
        q.offer(node);

        while (!q.isEmpty()) {
            Node current = q.poll();

            for (Node neighbor : current.neighbors) {

                // Clone neighbor if it hasn't been cloned yet
                if (!mp.containsKey(neighbor)) {
                    mp.put(neighbor, new Node(neighbor.val));
                    q.offer(neighbor);
                }

                // Add the clone of the neighbor to the current node's clone
                mp.get(current).neighbors.add(mp.get(neighbor));
            }
        }

        return mp.get(node);
    }

    // Build graph
    public static Node buildGraph() {
        Node node1 = new Node(0);
        Node node2 = new Node(1);
        Node node3 = new Node(2);
        Node node4 = new Node(3);

        node1.neighbors.addAll(new ArrayList<>
                (Arrays.asList(node2, node3)));
        node2.neighbors.addAll(new ArrayList<>
                (Arrays.asList(node1, node3)));
        node3.neighbors.addAll(new ArrayList<>
                (Arrays.asList(node1, node2, node4)));
        node4.neighbors.addAll(new ArrayList<>
                (Arrays.asList(node3)));

        return node1;
    }

    // Compare two graphs for structure and value
    public static boolean compareGraphs(Node n1, Node n2,
                                        HashMap<Node, Node> visited) {
        if (n1 == null || n2 == null)
            return n1 == n2;

        if (n1.val != n2.val || n1 == n2)
            return false;

        visited.put(n1, n2);

        if (n1.neighbors.size() != n2.neighbors.size())
            return false;

        for (int i = 0; i < n1.neighbors.size(); i++) {
            Node neighbor1 = n1.neighbors.get(i);
            Node neighbor2 = n2.neighbors.get(i);

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
        Node original = buildGraph();
        Node cloned = cloneGraph(original);
        boolean isEqual = compareGraphs(original, cloned,
                new HashMap<>());
        System.out.println(isEqual ? "true" : "false");
    }
}