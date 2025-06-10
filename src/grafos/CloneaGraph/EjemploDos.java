package grafos.CloneaGraph;

import java.util.*;

// Definition for a Node
class Nodee {
    int val;
    ArrayList<Nodee> neighbors;

    Nodee() {
        neighbors = new ArrayList<>();
    }

    Nodee(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }
}

public class EjemploDos {

    // Map to hold original node to its copy
    static HashMap<Nodee, Nodee> copies = new HashMap<>();

    // Function to clone the graph using DFS
    public static Nodee cloneGraph(Nodee nodee) {
        // If the node is NULL, return NULL
        if (nodee == null) return null;

        // If node is not yet cloned, clone it
        if (!copies.containsKey(nodee)) {
            Nodee clone = new Nodee(nodee.val);
            copies.put(nodee, clone);

            // Recursively clone neighbors
            for (Nodee neighbor : nodee.neighbors) {
                clone.neighbors.add(cloneGraph(neighbor));
            }
        }

        // Return the clone
        return copies.get(nodee);
    }

    // Build graph
    public static Nodee buildGraph() {
        Nodee nodee1 = new Nodee(0);
        Nodee nodee2 = new Nodee(1);
        Nodee nodee3 = new Nodee(2);
        Nodee nodee4 = new Nodee(3);

        nodee1.neighbors.addAll(Arrays.asList(nodee2, nodee3));
        nodee2.neighbors.addAll(Arrays.asList(nodee1, nodee3));
        nodee3.neighbors.addAll(Arrays.asList(nodee1, nodee2, nodee4));
        nodee4.neighbors.addAll(Arrays.asList(nodee3));

        return nodee1;
    }

    // Compare two graphs for structural and value equality
    public static boolean compareGraphs(Nodee nodee1, Nodee nodee2,
                                        HashMap<Nodee, Nodee> visited) {
        if (nodee1 == null || nodee2 == null)
            return nodee1 == nodee2;

        if (nodee1.val != nodee2.val || nodee1 == nodee2)
            return false;

        visited.put(nodee1, nodee2);

        if (nodee1.neighbors.size() != nodee2.neighbors.size())
            return false;

        for (int i = 0; i < nodee1.neighbors.size(); i++) {
            Nodee n1 = nodee1.neighbors.get(i);
            Nodee n2 = nodee2.neighbors.get(i);

            if (visited.containsKey(n1)) {
                if (visited.get(n1) != n2)
                    return false;
            } else {
                if (!compareGraphs(n1, n2, visited))
                    return false;
            }
        }

        return true;
    }

    // Driver Code
    public static void main(String[] args) {
        Nodee original = buildGraph();

        // Clone the graph
        Nodee cloned = cloneGraph(original);

        // Compare original and cloned graph
        boolean result = compareGraphs(original, cloned, new HashMap<>());
        System.out.println(result ? "true" : "false");
    }
}