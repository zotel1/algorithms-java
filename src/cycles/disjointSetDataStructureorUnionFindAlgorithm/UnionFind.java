package cycles.disjointSetDataStructureorUnionFindAlgorithm;

/*
* Dos conjuntos se denominan conjuntos disjuntos si no tienen ningún elemento en común.
* La estructura de datos de conjuntos disjuntos se utiliza para almacenar dichos conjuntos. Admite las siguientes operaciones:

Fusión de dos conjuntos disjuntos en un solo conjunto mediante la operación Union.
Encontrar el representante de un conjunto disconexo mediante la operación Buscar.
Comprueba si dos elementos pertenecen al mismo conjunto o no.
* Principalmente encontramos representativos de ambos y comprobamos si son iguales.
Considere una situación con varias personas y las siguientes tareas que se deben realizar en ellas:

Agregue una nueva relación de amistad, es decir, una persona x se convierte en amiga de otra persona y, es decir, agrega un nuevo elemento a un conjunto.
Averiguar si el individuo x es amigo del individuo y (amigo directo o indirecto)
*
* Partición de los individuos en diferentes conjuntos según los grupos en los que se encuentran. Este método se conoce como unión de conjuntos disjuntos, que mantiene una colección de conjuntos disjuntos y cada conjunto está representado por uno de sus miembros.

Para responder a la pregunta anterior, dos puntos clave a tener en cuenta son:

¿Cómo resolver conjuntos? Inicialmente,
* todos los elementos pertenecen a diferentes conjuntos.
* Después de trabajar en las relaciones dadas,
* seleccionamos a un miembro como representante.
¿Comprobar si hay 2 personas en el mismo grupo?
* Si los representantes de dos individuos son iguales, entonces son amigos.
Las estructuras de datos utilizadas son:
Matriz: Una matriz de enteros se llama Parent[].
* Si se trata de N elementos,
* el i-ésimo elemento de la matriz representa el i-ésimo elemento.
* Más precisamente,
* el i-ésimo elemento de la matriz Parent[] es el padre del i-ésimo elemento.
* Estas relaciones crean uno o más árboles virtuales.

Árbol: Es un conjunto disyuntivo.
* Si dos elementos están en el mismo árbol,
* entonces están en el mismo conjunto Disjoint.
* El nodo raíz (o el nodo superior) de cada árbol se denomina representante del conjunto.
* Siempre hay un único representante de cada conjunto.
* Una regla simple para identificar a un representante
* es que si 'i' es el representante de un conjunto, entonces Parent[i] = i.
* Si i no es el representante de su conjunto,
* entonces se puede encontrar subiendo por el árbol hasta encontrar al representante.
*
* Ejemplo UNO*/

import java.util.Arrays;

public class UnionFind {
    private int[] parent;

    public UnionFind(int size) {

        // Initialize the parent array with each
        // element as its own representative
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    // Find the representative (root) of the
    // set that includes element i
    public int find(int i) {

        // if i itself is root or representative
        if (parent[i] == i) {
            return i;
        }

        // Else recursively find the representative
        // of the parent
        return find(parent[i]);
    }

    // Unite (merge) the set that includes element
    // i and the set that includes element j
    public void union(int i, int j) {

        // Representative of set containing i
        int irep = find(i);

        // Representative of set containing j
        int jrep = find(j);

        // Make the representative of i's set be
        // the representative of j's set
        parent[irep] = jrep;
    }

    public static void main(String[] args) {
        int size = 5;
        UnionFind uf = new UnionFind(size);
        uf.union(1, 2);
        uf.union(3, 4);
        boolean inSameSet = uf.find(1) == uf.find(2);
        System.out.println("Are 1 and 2 in the same set? " + inSameSet);
    }
}