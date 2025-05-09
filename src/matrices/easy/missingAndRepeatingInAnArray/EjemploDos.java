package matrices.easy.missingAndRepeatingInAnArray;

import java.util.ArrayList;

public class EjemploDos {
    static ArrayList<Integer> findTwoElement(int[] arr) {
        int n = arr.length;

        int repeating = -1;

        for (int i = 0; i < n; i++) {
            int val = Math.abs(arr[i]);

            if (arr[val - 1] > 0) {
                arr[val - 1] = -arr[val - 1];
            }
            else {

                // Element is repeating.
                repeating = val;
            }
        }

        int missing = -1;

        // Value at missing value index
        // will be positive.
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                missing = i + 1;
                break;
            }
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
