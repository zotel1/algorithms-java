package platzi;

/*
* Dadas dos listas de números enteros nums1 y
* nums2, cada una ordenada en orden ascendente, y
* dos enteros m y n, que representan la cantidad de
* elementos en nums1 y nums2 respectivamente.
*
* Combinar nums1 y nums2 en un único array
* ordenado de forma ascendente.
*
* Para ello, nums1 tiene una longitud de m + n, donde
* los primeros m elementos denotan los elementos que
* deben ser combinados, y los últimos n elementos son
* 0 y deben ser ignorados.
*
* [1,2,3,0,0,0,0] m = 3
*
* [-4,2,3,9] n = 4
*
*
 * Mezcla dos arreglos ordenados nums1 y nums2 dentro  de nums1.
 * Se asume que nums1 tiene suficiente espacio para contener todos los elementos.
 *
 * @param nums1 Arreglo destino, con espacio suficiente (tamaño m + n)
 * @param nums2 Segundo arreglo a fusionar
 * @param m Número de elementos válidos en nums1
 * @param n Número de elemento válidos en nums2
 * @return El arreglo nums1 modificado con todos los elementos ordenados
* */

public class EjemploDos {

    public static int[] merge(int[] nums1, int[] nums2, int m, int n) {

        // Recorremos desde el final del arreglo combinado
        for (int i = m + n - 1; i >= 0; i--) {

            // Si uno de los arreglos se ha vaciado, salimos del bucle
            if (m < 1 || n < 1) break;

            // Comparamos el últio elemento válido de cada arreglo y colocamos el mayor al final
            if (nums1[m - 1] >= nums2[n - 1]) {
                nums1[i] = nums1[m - 1];
                m--;
            } else {
                nums1[i] = nums2[n - 1];
                n--;
            }
        }

        // Si quedan elementos en nums2 que aún no se copiaron, los copiamos al principio de nums1
        if (m != n) {
            System.arraycopy(nums2, 0, nums1, 0, n);
        }

        return nums1;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0, 0}; // m = 3 (primeros 3 elementos son válidos)
        int[] nums2 = {-4, 2, 3, 9}; // n = 4

        int m = 3;
        int n = 4;

        // Ejecutamos la fusión
        int[] resultado = merge(nums1, nums2, m, n);

        // Imprimimos el resultado
        System.out.println("Resultado del merge: ");
        for (int num: resultado) {
            System.out.println(num + " ");
        }
    }


}
