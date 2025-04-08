package busquedaLineal;

public class EjemploCuatro {

    // Estructura del array
    static class Array {
        int []A = new int[10];
        int size;
        int length;

        Array(int []A, int size, int length){
            this.A = A;
            this.size = size;
            this.length = length;
        }
    };

    // function to print the array element
    static void Display(Array arr){
        int i;

        // Traverse the array arr[]
        for (i = 0; i < arr.length; i++){
            System.out.printf("%d ", arr.A[i]);
        }
        System.out.printf("\n");
    }

    // Function that performs the linear search transposition

    static int LinearSearchTransposition(Array arr, int key){
        int i;
        // Traverse the array
        for( i = 0; i < arr.length; i++){
            // if key is found, then swap
        }
    }
}
