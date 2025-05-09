package matrices.easy.count1sInASortedBinaryArray;

public class EjemploDos {
    /* Returns counts of 1's in arr[low..high). the array is assumed to be sorted in non-increasing order*/

    public static int countOnes(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int low = 0, high = n - 1;

        // get the middle index
        while (low <= high) {
            int mid = (low + high) / 2;

            // if mid element is 0
            if (arr[mid] == 0)
                high = mid - 1;

            // if element is last 1
            else if (mid == n - 1 || arr[mid + 1] != 1)
                return mid + 1;

            // if element is not last 1
            else
                low = mid + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 0, 0, 0, 0 };
        System.out.println(countOnes(arr));
    }
}
