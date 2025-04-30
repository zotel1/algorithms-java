package matrices.missingAndRepeatingInAnArray;

import java.util.ArrayList;

public class EjemploCuatro {
    static ArrayList<Integer> findTwoElement(int[] arr) {
        int n = arr.length;
        int xorVal = 0;

        // Get the xor of all array elements
        // And numbers from 1 to n
        for (int i = 0; i < n; i++) {
            xorVal ^= arr[i];
            xorVal ^= (i + 1);  // 1 to n numbers
        }

        // Get the rightmost set bit in xorVal
        int setBitIndex = xorVal & ~(xorVal - 1);

        int x = 0, y = 0;

        // Now divide elements into two sets
        // by comparing rightmost set bit
        for (int i = 0; i < n; i++) {

            // Decide whether arr[i] is in first set
            // or second
            if ((arr[i] & setBitIndex) != 0) {
                x ^= arr[i];
            }
            else {
                y ^= arr[i];
            }

            // Decide whether (i+1) is in first set
            // or second
            if (((i + 1) & setBitIndex) != 0) {
                x ^= (i + 1);
            }
            else {
                y ^= (i + 1);
            }
        }

        // x and y are the repeating and missing values.
        // to know which one is what, traverse the array
        int missing, repeating;

        int xCnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                xCnt++;
            }
        }

        if (xCnt == 0) {
            missing = x;
            repeating = y;
        }
        else {
            missing = y;
            repeating = x;
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(repeating);
        result.add(missing);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 3};
        ArrayList<Integer> ans = findTwoElement(arr);

        System.out.println(ans.get(0) + " " + ans.get(1));
    }
}
