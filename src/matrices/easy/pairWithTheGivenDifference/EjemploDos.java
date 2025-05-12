package matrices.easy.pairWithTheGivenDifference;

import java.util.Arrays;

public class EjemploDos {

    // Binary search function
    static boolean binarySearch(int[] arr, int left, int right, int key){
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                return true;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    // function to fond a pair with the given difference
    static boolean findPair(int[] arr, int x) {

    // sort the array first
        Arrays.sort(arr);

        int n = arr.length;

        // for each element, search for its complement
        for (int i = 0; i < n; i++) {

            // try find arr[i] + x
            int target = arr[i] + x;

            // binary search for target
            if ( binarySearch(arr, i + 1, n - 1, target)) {
                return true;
            }
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
