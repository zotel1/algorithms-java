package busquedaBinaria;

public class IterativaTres {
    public static int bynary(int arr[], int x) {
        int start = 0;
        int end = arr.length -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (x == arr[mid]) {
                return mid;
            }
            else if (x >  arr[mid]) {
                start = mid +1;
            }
            else {
                end = mid -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 5, 7, 14, 17, 19, 22 };
        int search = bynary(arr, 22);
        System.out.println("El elemento que estamos buscando, en este caso el numero 22, se encuentra en la posicion: " + search + " del array.");
    }
}
