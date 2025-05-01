package matrices.easy.missingAndRepeatingInAnArray;

import java.util.ArrayList;

public class EjemploUno {
    static ArrayList<Integer> findTwoElement(int[] arr) {
        int n = arr.length;

        // Creating frequency array of size n+1 with
        // initial values as 0. Note that array
        // values will go upto n, that is why we
        // have taken the size as n+1
        int[] freq = new int[n + 1];
        int repeating = -1;
        int missing = -1;

        // Find the frequency of all elements.
        for (int i = 0; i < n; i++) {
            freq[arr[i]]++;
        }

        for (int i = 1; i <= n; i++) {

            // For missing element, frequency
            // will be 0.
            if (freq[i] == 0) {
                missing = i;
            }

            // For repeating element, frequency
            // will be 2.
            else if (freq[i] == 2) {
                repeating = i;
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
