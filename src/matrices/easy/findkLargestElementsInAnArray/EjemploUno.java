package matrices.easy.findkLargestElementsInAnArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class EjemploUno {

    static ArrayList<Integer> kLargest(int[] arr, int k) {
        int n = arr.length;

        // Convert int type to Integer for sorting with a comparator
        Integer[] arrInteger = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        // Sort the array in descending order
        Arrays.sort(arrInteger, Collections.reverseOrder());

        // Store the first k elements in result list
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++)
            res.add(arrInteger[i]);

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 23, 12, 9, 30, 2, 50};
        int k = 3;

        ArrayList<Integer> res = kLargest(arr, k);
        for (int ele : res)
            System.out.println(ele + " ");
    }
}
