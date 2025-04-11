package busquedaLineal;

public class EjemploOcho {
    public static int liner(int arr[], int x){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 12, 114, 0, 4, 9 };
        int search = liner(arr, 4);
        // here we are searching for 10 element in the array which is not present in the array so, it will print -1
        System.out.println("El elemento que estamos buscando esta en la posicion: " + search);
    }
}
