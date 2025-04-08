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
            // if key is found, then swap the element with it's previus index
            if (key == arr.A[i]){
                // If key is first element
                if (i == 0)
                    return i;
                int temp = arr.A[i];
                arr.A[i] = arr.A[i - 1];
                arr.A[i - 1] = temp;
                return i;
            }
        }
        return -1;
    }

    // Driver Code
    public static void main(String[] args) {
        // Given array arr[]
        int tempArr[] = {2, 23, 14, 5, 6, 9, 8, 12};
        Array arr = new Array(tempArr, 10, 8);

        System.out.printf("Elements before Linear" + " Search Transposition: ");

        // function Call for displaying the array arr[]
        Display(arr);

        // Function call for transposition
        LinearSearchTransposition(arr, 14);

        System.out.printf("Elements after Linear" + " Search Transposition: " );

        // Function Call for displaying the array
        Display(arr);
    }
}
