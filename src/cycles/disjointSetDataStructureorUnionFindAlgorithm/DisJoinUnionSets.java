package cycles.disjointSetDataStructureorUnionFindAlgorithm;

/* EJEMPLO DOS
Optimización (compresión de ruta y unión por rango/tamaño):
La idea principal es reducir las alturas de los árboles que representan diferentes conjuntos. Logramos esto con dos métodos más comunes:
1) Compresión de
ruta 2) Unión por rango

Compresión de ruta (utilizada para mejorar find()):

La idea es aplanar el árbol cuando se llama a find(). Cuando se llama a find() para un elemento x, se devuelve la raíz del árbol. La operación find() recorre desde x hasta encontrar la raíz. La idea de la compresión de ruta es hacer que la raíz encontrada sea el padre de x para que no tengamos que atravesar todos los nodos intermedios nuevamente. Si x es la raíz de un subárbol, entonces la ruta (a la raíz) de todos los nodos bajo x también se comprime.
*/

public class DisJoinUnionSets {

    int[] rank, parent;
    int n;

    // Constructor
    public DisJoinUnionSets(int n) {
        rank = new int[n];
        parent = new int[n];
        this.n = n;
        for (int i = 0; i < n; i++){
            // Initially, all elements are in their own set.
            parent[i] = i;
        }
    }

    // Returns representative of x's set
    public int find(int i) {
        int root  = parent[i];

        if (parent[root] != root) {
            return parent[i] = find(root);
        }
        return root;
    }

    // Unites the set that includes x and the set that includes x
    void union(int x, int y) {
        // Find representatives of two sets
        int xRoot = find(x), yRoot = find(y);

        // Elements are in the same set, no need to unite anything.
        if (xRoot == yRoot)
            return;

        // If x's rank is less than y's rank
        if (rank[xRoot] < rank[yRoot])

            // Then move x under y so that depth of tree remains less
            parent[xRoot] = yRoot;

        // Else if
    }

}
