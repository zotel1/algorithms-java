package matrices.easy.largestThreeDistinctElementsInArray;

import java.util.ArrayList;
import java.util.List;

public class EjemploUno {

    // Function to return three largest elements
    public static List<Integer> get3largest(int[] arr) {
        int fst = Integer.MIN_VALUE, sec = Integer.MIN_VALUE, thd = Integer.MIN_VALUE;

        for (int x : arr) {
            // if current element is greader than fst
            if (x > fst) {
                thd = sec;
                sec = fst;
                fst = x;
            }

            // If x is between sec and thd
            else if (x > thd && x != sec && x != fst) {
                thd = x;
            }
        }

        List<Integer> res = new ArrayList<>();
        if (fst == Integer.MIN_VALUE) return res;
        res.add(fst);
        if (sec == Integer.MIN_VALUE) return res;
        res.add(sec);
        if (thd == Integer.MIN_VALUE) return res;
        res.add(thd);

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {12, 13, 1, 10, 34, 1};
        List<Integer> res = get3largest(arr);
        for (int x : res) {
            System.out.println(x + " ");
        }
        System.out.println();
    }
}
