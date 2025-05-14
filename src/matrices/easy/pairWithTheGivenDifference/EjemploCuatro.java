package matrices.easy.pairWithTheGivenDifference;

import java.util.HashSet;

public class EjemploCuatro {
    static boolean findPair(int[] arr, int x) {

        HashSet<Integer> st = new HashSet<>();

        for (int num : arr) {

            // Check if complement exists
            if (st.contains(num + x) || st.contains(num - x)) {
                return true;
            }

            st.add(num);
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
