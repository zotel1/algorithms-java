package matrices.easy.twoSumPairClosestTo0;

import java.util.Arrays;

public class EjemploTres {

    public static int minAbsSumPair(int[] arr) {

        // Sorting the array ins ascending order
        Arrays.sort(arr);

        int i = 0, j = arr.length - 1;

        // Initializins sum with the first and last elements
        int sum  = arr[i] + arr[j];

        // Initializing  the result with the absolute value of the initial sum
        int diff = Math.abs(sum);

        while (i < j) {
            // If we have zero sum, there's no result better. Hence, we return 0.
            if (arr[i] + arr[j] == 0)
                return 0;

            // If we get a better result, we update the difference
            if (Math.abs(arr[i] + arr[j])
            < Math.abs(diff)) {
                diff = (arr[i] + arr[j]);
                sum = Math.max(sum, arr[i] + arr[j]);
            }

            // If the current sum is greater than zero, we search for a smaller sum
            if (arr[i] + arr[j] > 0)
                j--;
            // Else, we search for a larger sum
            else i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = { 0, -8, -6, 3};
        System.out.println(minAbsSumPair(arr));
    }
}
