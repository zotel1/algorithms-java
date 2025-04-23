package matrices.findTheMissingNumber;

public class EjemploDos {

    public static int missingNum(int[] arr) {
        int n = arr.length + 1;

        // Create hash array of size n+1
        int[] hash = new int[n + 1];

        // store frequencies of elements
        for (int i = 0; i < n - 1; i++) {
            hash[arr[i]]++;
        }

        // find the missing number
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {8, 2, 4, 5, 3, 7, 1};
        int res = missingNum(arr);
        System.out.println(res);
    }
}
