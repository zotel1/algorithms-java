package busquedaBinaria;

public class Iterativa {

    // returns index of x if it is present in arr[].
    int binarySearch(int arr[], int x) {
        int low = 0, high = arr.length -1;
        while (low <= high) {
            int mid = low + (high - low ) / 2;

            // check if x is present at mid
            if (arr[mid] == x)
                return mid;

            // if x greater, ignore left half
            if (arr[mid] < x)
                low = mid + 1;



            // if x is smaller, ignore right half
            else
                high = mid -1;
        }

        // if we reach here, then element was not present
        return -1;
    }

    public static void main(String[] args) {
        Iterativa ob = new Iterativa();
        int arr[] = { 2, 3, 4, 10, 40 };
        int n = arr.length;
        int x = 10;
        int result = ob.binarySearch(arr, x);
        if (result == -1)
            System.out.println("Elements is not present in array");
        else
            System.out.println("Element is present at " + "index " + result);
    }
}
