package busquedaLineal;

public class EjemploNueve {

    public static int getSum(int[] arr1) {
        int n = arr1.length;
        if (n % 2 == 0) // (n) is even
            return 0;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr1[i];
        }

        return sum; // (n) is odd
    }

    public static void main(String[] args) {
        // Declaring two arrays, one with an odd length
        // and the other with an even length
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println(getSum(arr1));
        System.out.println(getSum(arr2));
    }
}
