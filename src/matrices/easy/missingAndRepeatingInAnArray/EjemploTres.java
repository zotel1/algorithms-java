package matrices.easy.missingAndRepeatingInAnArray;

import java.util.ArrayList;

public class EjemploTres {
    static ArrayList<Integer> findTwoElement(int[] arr) {
        int n = arr.length;

        int s = (n * (n + 1)) / 2;
        int ssq = (n * (n + 1) * (2 * n + 1)) / 6;

        int missing = 0, repeating = 0;

        for (int i = 0; i < arr.length; i++) {
            s -= arr[i];
            ssq -= arr[i] * arr[i];
        }

        missing = (s + ssq / s) / 2;
        repeating = missing - s;

        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(repeating);
        res.add(missing);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 3};
        ArrayList<Integer> ans = findTwoElement(arr);

        System.out.println(ans.get(0) + " " + ans.get(1));
    }
}
