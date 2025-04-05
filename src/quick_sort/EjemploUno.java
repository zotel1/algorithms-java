package quick_sort;

public class EjemploUno {

    // Partition function
    static int partition(int[] arr,  int low, int high){

        // Choose the pivot
        int pivot = arr[high];

        // Index of smaller element and indicates
        // the right  position of pivot found so far
        int i = low -1;

        // Traverse arr[low..high] and move all smaller
        // elements to the left side. Elements from low to
        // i are smaller after every iteration
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Move pivot after smaller elements and
        // return its position
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Swap function
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
