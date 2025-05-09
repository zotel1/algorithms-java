package matrices.easy.twoSumPairClosestTo0;

import java.util.Arrays;

public class EjemploDos {

    static int minAbsSumPair(int[] arr) {

        Arrays.sort(arr);

        int n = arr.length;

        // Variable to store the closest sum
        int res = Integer.MAX_VALUE;

        // Iterate over the array
        for (int i = 0; i < n; i++) {

            // Consider current element as first
            // element of the pair and find the
            // other element using binary search
            int x = arr[i];

            int left = i + 1, right = n - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                int curr = arr[mid] + x;

                // If exact pair is found
                if (curr == 0) {
                    return 0;
                }

                // Update res if the current pair is closer
                if (Math.abs(curr) < Math.abs(res)) {
                    res = curr;
                }

                else if (Math.abs(curr) == Math.abs(res)) {
                    res = Math.max(res, curr);
                }

                // If current is smaller than 0,
                // go to right side. Else on the
                // left side.
                if (curr < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 0, -8, -6, 3 };
        System.out.println(minAbsSumPair(arr));
    }

}
