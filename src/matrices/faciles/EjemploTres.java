package matrices.faciles;

public class EjemploTres {

    static int findMax(int[] arr, int i) {
        // Last index returns the element
        if (i == arr.length -1) {
            return arr[i];
        }

        // find the maximun from the rest of the array
        int recMax = findMax(arr, i + 1);

        // Compare with i-th element and return
        return Math.max(recMax, arr[i]);
    }
    static int largest(int[] arr) {
        return findMax(arr, 0);
    }

    public static void main(String[] args) {
        int[] arr = {10, 234, 45, 90, 9808};
        System.out.println(largest(arr));
    }
}
