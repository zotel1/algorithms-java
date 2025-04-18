package matrices.faciles;

import java.util.Arrays;

// la mayoria de los lenguajes tienen una funcion incorporada de tipo max() relevante para encontrar el elemento maximo

public class EjemploDos {

    static int largest(int[] arr) {

        Arrays.sort(arr);
        return arr[arr.length -1];
    }

    public static void main(String[] args) {
        int[] arr = { 10, 234, 45, 90, 9808};
        System.out.println(largest(arr));
    }
}
