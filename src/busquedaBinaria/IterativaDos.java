package busquedaBinaria;

import java.util.Arrays;

public class IterativaDos {

    public static int binary(int[] arr, int x){
        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            int mid = (start + end) / 2;

            if (x == arr[mid]) {
                return mid;
            } else if (x > arr[mid]){
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numeros = {2, 3, 4, 8, 10}; // Array debe estar ordenado
        int buscar = 4;

        System.out.println("Array: " + Arrays.toString(numeros));
        int resultado = binary(numeros, buscar);

        if (resultado != -1) {
            System.out.println("Elemento encontrado en el indice: " + resultado);
        } else {
            System.out.println("Elemento no encontrado.");
        }
    }
}
