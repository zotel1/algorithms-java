package busquedaLineal;

public class EjemploDos {

    public static int search(int arr[], int N, int x) {
        for (int i = 0; i < N; i++) {
            if (arr[i] == x)
                return i;
        }
                return -1;
        }
        // driver code

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 10, 40 };
        int x = 10;

        // Function call
        int result = search(arr, arr.length, x);
        if (result == -1 )
            System.out.println("El elemento no esta presente en el array");
        else System.out.println("El elemento esta presente en el indice " + result);
    }
}
