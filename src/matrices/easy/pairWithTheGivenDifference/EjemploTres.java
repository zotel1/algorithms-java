package matrices.easy.pairWithTheGivenDifference;

import java.util.Arrays;

public class EjemploTres {

    static boolean findPair(int[] arr, int x) {
        int n = arr.length;

        // Sort the array.
        Arrays.sort(arr);

        int j = 1;

        for (int i = 0; i < n; i++) {

            // Increment j till difference is less than x.
            while (j < n && arr[j] - arr[i] < x) j++;

            // If difference is x
            if (j < n && i != j && arr[j] - arr[i] == x) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {5, 20, 3, 2, 50, 80};
        int x = 78;
        if (findPair(arr, x)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
